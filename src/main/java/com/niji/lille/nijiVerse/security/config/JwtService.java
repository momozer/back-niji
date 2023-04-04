package com.niji.lille.nijiVerse.security.config;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.*;
import java.util.function.Function;


@Service
public class JwtService {
    /*
    Ce code implémente un service permettant de générer et de valider des tokens JWT (JSON Web Token).
     Le JWT est un standard ouvert (RFC 7519) pour créer des jetons d'accès qui peuvent être utilisés pour
     authentifier et autoriser les requêtes HTTP.
     */


    private static final String SECRET_KEY = "404E635266556A586E3272357538782F413F4428472B4B6250645367566B5970";

    /**
     * Cette méthode prend un token en entrée et retourne le nom d'utilisateur (username) stocké dans le claim
     * (revendication) "subject" du JWT.
     * @param token
     * @return le nom d'utilisateur (username) stocké dans le claim (revendication) "subject" du JWT.
     */
    public String extractUsername(String token){
        return extractClaim(token, Claims::getSubject);
    }

    /**
     * Cette méthode générique prend un token JWT en entrée et une fonction claimsResolver qui prend un objet Claims
     * et renvoie un objet de type T. La méthode extrait tous les claims du JWT et utilise la fonction claimsResolver
     * pour extraire une valeur spécifique d'un claim particulier.
     * @param token
     * @param claimsResolver
     * @return
     * @param <T>
     */
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver){
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    /**
     * Cette méthode prend un objet UserDetails qui contient les détails de l'utilisateur
     * (nom d'utilisateur, mot de passe, rôles, etc.) et retourne un token JWT signé avec la clé secrète.
     * @param userDetails un objet UserDetails qui contient les détails de l'utilisateur
     * @return un token JWT signé avec la clé secrète
     */
    public String generateToken(UserDetails userDetails){
        return generateToken(new HashMap<>(), userDetails);
    }

    /**
     * Cette méthode génère un token JWT avec des revendications (claims) supplémentaires spécifiées dans
     * le paramètre extraClaims.
     * @param extraClaims revendications (réclamations pour authentification)
     * @param userDetails les details de l'user
     * @return un Token (qui est généré)
     */
    public String generateToken(
            Map<String, Object> extraClaims,
            UserDetails userDetails
    ){
        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
                .signWith(SignatureAlgorithm.HS256, getSignInKey())
                .compact();
    }

    /**
     * Cette méthode prend un token JWT en entrée et un objet UserDetails qui contient les détails de l'utilisateur.
     * La méthode vérifie si le token est valide en comparant le nom d'utilisateur stocké dans le claim "subject" avec
     * le nom d'utilisateur de userDetails et en vérifiant si le token a expiré.
     * @param token un token JWT
     * @param userDetails un objet UserDetails qui contient les détails de l'utilisateur
     * @return l'user correspondant et letoken actif correspondant au token
     */
    public boolean isTokenValid(String token, UserDetails userDetails){
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    /**
     * Cette méthode vérifie si le token JWT est expiré en comparant sa date d'expiration avec la date actuelle.
     * @param token
     * @return la date d'expiration du token ainsi que la date actuelle
     */
    private boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date());
    }

    /**
     * Cette méthode retourne la date d'expiration du token JWT.
     * @param token
     * @return la date d'expiration
     */
    private Date extractExpiration(String token){
        return extractClaim(token, Claims::getExpiration);
    }

    /**
     * Cette méthode extrait tous les claims du JWT.
     * @param token
     * @return les claims du JWT
     */
    private  Claims extractAllClaims(String token){
        return Jwts
                .parser()
                .setSigningKey(getSignInKey())
                .parseClaimsJwt(token)
                .getBody();
    }

    /**
     * Cette méthode retourne la clé secrète utilisée pour signer le JWT. La clé est stockée
     * sous forme de chaîne de caractères encodée en base64. La méthode la décode en un tableau d'octets
     * et crée une instance de la classe Key à partir de celle-ci.
     * @return la clé secrète utilisée pour signer le JWT
     */
    private String getSignInKey(){
        return Base64.getEncoder().encodeToString(HexFormat.of().parseHex(SECRET_KEY));
    }




}
