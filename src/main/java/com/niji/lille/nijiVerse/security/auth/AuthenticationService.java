package com.niji.lille.nijiVerse.security.auth;

import com.niji.lille.nijiVerse.entities.User;
import com.niji.lille.nijiVerse.repositories.UserRepository;
import com.niji.lille.nijiVerse.security.config.JwtService;
import com.niji.lille.nijiVerse.security.token.TokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository repository;
    private final TokenRepository tokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request){
        var user = User.builder()
                .
    }
}
