package com.niji.lille.nijiVerse.validators;

import com.niji.lille.nijiVerse.dto.UserDTO;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class UserValidator {
    public static List<String> validate (UserDTO userDTO){
        List<String> errors = new ArrayList<>();

        if (userDTO == null){
            errors.add("Veuillez rensiegner le nom d'utilisateur");
            errors.add("Veuillez renseigner le username de l'utilisateur");
            errors.add("Veuillez renseigner l'adresse email de l'utilisateur");
            errors.add("Veuillez renseigner la date de naissance de l'utilisateur");
            errors.add("Veuillez renseigner le mot de passe de l'utilisateur");
            return  errors;
        }
        if (!StringUtils.hasLength(userDTO.getNom())){
            errors.add("Veuillez rensiegner le nom d'utilisateur");
        }
        if (!StringUtils.hasLength(userDTO.getUsername())){
            errors.add("Veuillez renseigner le username de l'utilisateur");
        }
        if (!StringUtils.hasLength(userDTO.getEmail())){
            errors.add("Veuillez renseigner l'adresse email de l'utilisateur");
        }
        if (userDTO.getDateNaissance() == null){
            errors.add("Veuillez renseigner la date de naissance de l'utilisateur");
        }
        if (!StringUtils.hasLength(userDTO.getMotPasse())){
            errors.add("Veuillez renseigner le mot de passe de l'utilisateur");
        }
        return errors;
    }

}
