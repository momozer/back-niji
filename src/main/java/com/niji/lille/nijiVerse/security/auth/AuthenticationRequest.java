package com.niji.lille.nijiVerse.security.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationRequest {

    /**
     * Ces champs représentent les informations d'identification de l'utilisateur qui sont nécessaires pour l'authentification.
     */
    private String email;
    String password;
}
