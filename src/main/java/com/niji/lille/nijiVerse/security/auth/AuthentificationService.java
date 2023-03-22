package com.niji.lille.nijiVerse.security.auth;

import com.niji.lille.nijiVerse.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthentificationService {

    private final UserRepository repository;
    //tokenRepo
    private final PasswordEncoder passwordEncoder;
    //JwtService
    private final AuthenticationManager authenticationManager;
}
