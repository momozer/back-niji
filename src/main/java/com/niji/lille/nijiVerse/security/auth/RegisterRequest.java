package com.niji.lille.nijiVerse.security.auth;

import com.niji.lille.nijiVerse.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    private String nom;
    private String username;
    private String email;
    private String motPasse;
}
