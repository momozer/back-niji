package com.niji.lille.nijiVerse.security.auth;

import com.niji.lille.nijiVerse.entities.ERole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    /**
     *Ce code définit une classe Java nommée "RegisterRequest" utilisée pour encapsuler les données
     * d'une demande d'inscription. La classe possède les champs suivants:
     *
     * "nom": de type String, représentant le nom de l'utilisateur.
     * "username": de type String, représentant le nom d'utilisateur choisi par l'utilisateur.
     * "email": de type String, représentant l'adresse e-mail de l'utilisateur.
     * "motPasse": de type String, représentant le mot de passe de l'utilisateur.
     */
    private String nom;
    private String username;
    private String email;
    private String motPasse;
}
