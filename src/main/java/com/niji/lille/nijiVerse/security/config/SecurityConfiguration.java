package com.niji.lille.nijiVerse.security.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    /*
     * Ce code configure la sécurité de l'application web en utilisant Spring Security.
     * Il crée une chaîne de filtres de sécurité pour gérer les requêtes entrantes et sortantes.
     */

    /**
     * un filtre qui extrait le jeton JWT de l'en-tête de demande, valide le jeton et configure l'authentification
     * en fonction des informations du jeton.
     */
    private final JwtAuthenticationFilter jwtAuthFilter;

    /**
     * fournit l'authentification de l'utilisateur en fonction des informations fournies.
     */
    private final AuthenticationProvider authenticationProvider;

    /**
     * fournit une gestion personnalisée du processus de déconnexion
     */
    private final LogoutHandler logoutHandler;

    /**
     * Le filtre de sécurité est configuré pour désactiver la protection CSRF, autoriser les requêtes vers /auth/** sans
     * authentification, exiger une authentification pour toutes les autres requêtes, utiliser une politique de session
     * sans état pour les sessions utilisateur et enfin, ajouter un filtre de filtre
     * personnalisé (JwtAuthenticationFilter) pour toutes les requêtes entrantes avant le filtre
     * de nom d'utilisateur/mot de passe (UsernamePasswordAuthenticationFilter).
     * @param http protocole de requete
     * @return  le build de Http
     * @throws Exception
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/auth/**")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .logout()
                .logoutUrl("/auth/logout")
                .addLogoutHandler(logoutHandler)
                .logoutSuccessHandler((request, response, authentication) -> SecurityContextHolder.clearContext());
        return http.build();

    }

    protected  void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(auth.getDefaultUserDetailsService());
    }
}
