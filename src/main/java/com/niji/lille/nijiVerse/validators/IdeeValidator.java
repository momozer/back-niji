package com.niji.lille.nijiVerse.validators;

import com.niji.lille.nijiVerse.dto.IdeeDTO;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class IdeeValidator {
    public static List<String> validatre (IdeeDTO ideeDTO){
        List<String> errors = new ArrayList<>();

        if (ideeDTO == null){
            errors.add("Veuillez renseigner le titre de l'idée");
            errors.add("Veuillez renseigner la description de l'idée");
            return errors;
        }
        if(!StringUtils.hasLength(ideeDTO.getTitre())){
            errors.add("Veuillez renseigner le titre de l'idée");
        }
        if (!StringUtils.hasLength(ideeDTO.getDescription())){
            errors.add("Veuillez renseigner la description de l'idée");
        }
        return errors;
    }
}
