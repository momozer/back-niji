package com.niji.lille.nijiVerse.dto;

import com.niji.lille.nijiVerse.security.token.Token;
import com.niji.lille.nijiVerse.entities.User;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
@Builder @Data
public class UserDTO {
    private Long id;
    private String username;
    private String nom;
    private LocalDate dateNaissance;
    private String email;
    private String motPasse;
    private List<Token> tokens;

    public static UserDTO fromEntity(User user){
        if(user == null){
            return null;
        }
        return UserDTO.builder().build();
    }

    public static User toEntity (UserDTO userDTO){
        if (userDTO == null){
            return null;
        }
        User user = new User();
        user.setNom(userDTO.getNom());
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setDateNaissance(userDTO.getDateNaissance());
        user.setMotPasse(user.getMotPasse());

        return user;
    }
}
