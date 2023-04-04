package com.niji.lille.nijiVerse.security.config;

import com.niji.lille.nijiVerse.security.token.TokenRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    /**
     * Ce code représente un filtre de sécurité qui intercepte les requêtes entrantes, vérifie
     * si elles contiennent un jeton d'authentification JWT valide, puis authentifie l'utilisateur correspondant en conséquence.
     */


    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;
    private final TokenRepository tokenRepository;


    /**
     * Le filtre vérifie si la requête contient un en-tête "Authorization" avec
     * la valeur "Bearer" (Bearer Authentication Scheme). Si ce n'est pas le cas, la requête est transmise à
     * la prochaine étape de la chaîne de filtres. Sinon, il extrait le jeton JWT de l'en-tête, extrait le nom d'utilisateur
     * correspondant en utilisant le service JwtService, puis utilise le UserDetailsService pour charger
     * les informations d'utilisateur correspondantes.
     *
     *
     * Enfin, la requête est transmise à la prochaine étape de la chaîne de filtres.
     * @param request URL
     * @param response
     * @param filterChain
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain) throws ServletException, IOException {
        final String authHeader = request.getHeader("Authorization");
        final String jwt;
        final String userEmail;
        /**
         * Ici, le filtre vérifie si la requête contient un en-tête "Authorization" avec la valeur "Bearer"
         * (Bearer Authentication Scheme). Si ce n'est pas le cas, la requête est transmise à la prochaine étape de la chaîne
         * de filtres. Sinon, il extrait le jeton JWT de l'en-tête, extrait le nom d'utilisateur correspondant en utilisant
         * le service JwtService, puis utilise le UserDetailsService pour charger les informations d'utilisateur correspondantes.
         */
        System.out.println(request.getQueryString());
        if (authHeader == null || !authHeader.startsWith("Bearer ")){
            filterChain.doFilter(request, response);
            return;
        }
        System.out.println("c quoi ça ?");
        jwt = authHeader.substring(7);
        userEmail = jwtService.extractUsername(jwt);
        /**
         * Ensuite, le filtre vérifie si le jeton est valide en utilisant le service JwtService
         */
        if (userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null){
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(userEmail);
            var isTokenValid = tokenRepository.findByToken(jwt)
                    .map(t -> !t.isExpired() && !t.isRevoked())
                    .orElse(false);
            /**
             * , puis vérifie si le jeton est
             * présent et est valide en se basant sur le TokenRepository. Si le jeton est valide, il crée une nouvelle
             * instance de UsernamePasswordAuthenticationToken avec les détails
             * de l'utilisateur authentifié et place cette instance dans le SecurityContextHolder.
             */
            if (jwtService.isTokenValid(jwt, userDetails) && isTokenValid){
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null,
                        userDetails.getAuthorities()
                );
                authToken.setDetails(
                        new WebAuthenticationDetailsSource().buildDetails(request)
                );
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }
        filterChain.doFilter(request, response);

    }
}
