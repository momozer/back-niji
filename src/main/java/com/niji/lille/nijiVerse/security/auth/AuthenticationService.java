package com.niji.lille.nijiVerse.security.auth;

import com.niji.lille.nijiVerse.entities.Role;
import com.niji.lille.nijiVerse.entities.User;
import com.niji.lille.nijiVerse.repositories.UserRepository;
import com.niji.lille.nijiVerse.security.config.JwtService;
import com.niji.lille.nijiVerse.security.token.Token;
import com.niji.lille.nijiVerse.security.token.TokenRepository;
import com.niji.lille.nijiVerse.security.token.TokenType;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Ce code implémente un service pour l'authentification et l'enregistrement des utilisateurs.
 * La classe a plusieurs dépendances injectées par l'intermédiaire du constructeur, et de plusieurs méthodes permettant
 * la gestion de l'authentification.
 */
@Service
@RequiredArgsConstructor
public class AuthenticationService {

    /**
     * UserRepository pour la gestion de la base de données des utilisateurs
     */
    private final UserRepository repository;

    /**
     * TokenRepository pour la gestion des jetons d'authentification
     */
    private final TokenRepository tokenRepository;

    /**
     * PasswordEncoder pour encoder les mots de passe
     */
    private final PasswordEncoder passwordEncoder;

    /**
     *  JwtService pour la génération et la validation des jetons JWT (JSON Web Token)
     */
    private final JwtService jwtService;

    /**
     * AuthenticationManager pour la gestion de l'authentification
     */
    private final AuthenticationManager authenticationManager;


    /**
     * La méthode register enregistre un nouvel utilisateur avec les informations fournies dans la demande d'inscription
     * (RegisterRequest). La méthode crée un nouvel utilisateur avec les informations fournies, l'enregistre dans
     * la base de données à l'aide de repository.save(user), génère un jeton JWT à l'aide de jwtService.generateToken(user)
     * et enregistre le jeton dans la base de données avec saveUserToken(savedUser, jwtToken).
     * @param request les informations fournies  nouvel utilisateur
     * @return le jeton JWT dans un objet AuthenticationResponse pour l'utilisateur nouvellement enregistré
     */
    public AuthenticationResponse register(RegisterRequest request){
        var user = User.builder()
                .nom(request.getNom())
                .username(request.getUsername())
                .email(request.getEmail())
                .motPasse(passwordEncoder.encode(request.getMotPasse()))
                .role(Role.USER)
                .build();
        var savedUser = repository.save(user);
        var jwtToken = jwtService.generateToken(user);
        saveUserToken(savedUser, jwtToken);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    /**
     * La méthode authenticate vérifie les informations d'authentification fournies dans la demande d'authentification
     * (AuthenticationRequest). La méthode utilise l'authenticationManager pour vérifier les informations d'authentification
     * et récupère l'utilisateur correspondant à l'e-mail fourni dans la demande
     * en utilisant repository.findByEmail(request.getEmail()). La méthode génère ensuite un nouveau jeton JWT à l'aide de
     * jwtService.generateToken(user), révoque tous les jetons précédents de l'utilisateur en utilisant
     * revokeAllUserTokens(user) et enregistre le nouveau jeton dans la base de données avec
     * saveUserToken(user, jwtToken).
     * @param request
     * @return le jeton JWT dans un objet AuthenticationResponse pour l'utilisateur authentifié.
     */
    public AuthenticationResponse authenticate (AuthenticationRequest request){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = repository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        revokeAllUserTokens(user);
        saveUserToken(user, jwtToken);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

// saveUserToken et revokeAllUserTokens methods:
    /**
     *Les méthodes saveUserToken et revokeAllUserTokens sont des méthodes utilitaires utilisées pour enregistrer et
     * révoquer des jetons d'authentification pour un utilisateur donné.
     */


    /**
     * La méthode saveUserToken enregistre un jeton JWT
     * pour un utilisateur donné dans la BDD à l'aide de tokenRepository.save(token).
     * @param user utilisateur donné
     * @param jwtToken jeton d'authentification
     */
    private void saveUserToken(User user, String jwtToken){
        var token = Token.builder()
                .user(user)
                .token(jwtToken)
                .tokenType(TokenType.BEARER)
                .expired(false)
                .revoked(false)
                .build();
        tokenRepository.save(token);
    }

    /**
     * La méthode revokeAllUserTokens récupère tous les jetons valides pour un utilisateur donné
     * l'aide de tokenRepository.finAllValidTokenByUser(user.getId()), les révoque tous et les enregistre dans
     * la base de données avec tokenRepository.saveAll(validUserTokens).
     * @param user utilisateur donné
     */
    private void revokeAllUserTokens(User user){
        var validUserTokens = tokenRepository.findAllValidTokenByUser(user.getId());
        if (validUserTokens.isEmpty())
            return;
        validUserTokens.forEach(token -> {
            token.setExpired(true);
            token.setRevoked(true);
        });
        tokenRepository.saveAll(validUserTokens);
        }
}
