package com.niji.lille.nijiVerse.security.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {


    /**
     * Ce champ stocke le token d'authentification généré par le serveur pour l'utilisateur qui s'est authentifié avec succès.
     */
    private String token;
}
