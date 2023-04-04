package com.niji.lille.nijiVerse.security.config;
import com.niji.lille.nijiVerse.entities.User;

import com.niji.lille.nijiVerse.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collections;
import java.util.Optional;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {

    /**
     * Cette classe est utilisée pour rechercher les utilisateurs dans la base de données.
     */
    private UserRepository repository;

    /**
     * Cette méthode retourne une instance de UserDetailsService, qui est une interface fournie par Spring Security
     * pour gérer les informations d'identification des utilisateurs.
     * Cette méthode utilise la méthode findByEmail de UserRepository pour rechercher l'utilisateur par e-mail.
     *
     * @return Si l'utilisateur est trouvé, les informations d'identification de cet utilisateur sont retournées sous forme
     * d'objet UserDetails. Sinon, une exception UsernameNotFoundException est levée.
     */

    @Bean
    public UserDetailsService userDetailsService(){
        return username -> (UserDetails) repository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("user non trouvé"));
    }

    /**
     *  Cette méthode retourne une instance d'implémentation de AuthenticationProvider qui utilise
     *  l'implémentation de UserDetailsService et le PasswordEncoder configuré pour vérifier
     *  les informations d'identification de l'utilisateur lors de l'authentification.
     * @return les informations vérifiées de l'utilisateur renseignées lors de l'authentificiation
     */
    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    /**
     *Cette méthode retourne une instance d'AuthenticationManager, qui est une interface fournie par Spring Security
     * pour gérer l'authentification des utilisateurs.
     * @param config AuthenticationConfiguration pour obtenir :
     * @return l'instance d'AuthenticationManager configurée.
     * @throws Exception
     */
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception{
        return config.getAuthenticationManager();
    }

    /**
     * Cette méthode retourne une instance de PasswordEncoder, qui est utilisée pour encoder les mots de passe
     * des utilisateurs avant de les stocker dans la base de données.
     * Cette méthode utilise l'implémentation BCryptPasswordEncoder fournie par Spring Security pour encoder
     * les mots de passe en utilisant l'algorithme BCrypt.
     * @return une instance de PasswordEncoder
     */
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
//        Optional<User> utilisateur = repository.findByEmail(email);
//        return new org.springframework.security.core.userdetails.User("", "", Collections.emptyList());
//    }


}
