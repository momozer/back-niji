package com.niji.lille.nijiVerse.security.config;

import com.niji.lille.nijiVerse.security.token.TokenRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogoutService implements LogoutHandler {
/*
Ce code implémente la méthode logout de l'interface LogoutHandler. Cette méthode est appelée par
le filtre de sécurité lorsque l'utilisateur se déconnecte.
 */
    private final TokenRepository tokenRepository;

    /**
     * Cette méthode révoque le jeton JWT utilisé lors de la connexion et empêche son utilisation ultérieure pour accéder aux ressources protégées par le système d'authentification.
     * @param request
     * @param response
     * @param authentication
     */
    @Override
    public void logout(
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication) {
        final String authHeader = request.getHeader("Authorization");
        final String jwt;
        /**
         * La méthode commence par extraire le jeton JWT à partir de l'en-tête d'autorisation de la requête HTTP.
         * Si le jeton n'est pas présent ou ne commence pas par le préfixe "Bearer ", la méthode retourne sans rien faire.
         */
        if (authHeader == null || !authHeader.startsWith("Bearer ")){
            return;
        }
        /**
         * Si le jeton JWT est présent, la méthode récupère l'objet Token correspondant à partir du TokenRepository.
         * Si un tel objet est trouvé, la méthode marque le jeton comme expiré et révoqué, puis enregistre
         * les modifications en utilisant le TokenRepository. Enfin, la méthode supprime l'objet Authentication
         * de la SecurityContextHolder.
         */
        jwt = authHeader.substring(7);
        var storedToken = tokenRepository.findByToken(jwt)
                .orElse(null);
        if (storedToken != null){
            storedToken.setExpired(true);
            storedToken.setRevoked(true);
            tokenRepository.save(storedToken);
            SecurityContextHolder.clearContext();
        }
    }
}
