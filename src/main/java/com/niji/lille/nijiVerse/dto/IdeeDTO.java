package com.niji.lille.nijiVerse.dto;

import com.niji.lille.nijiVerse.entities.Idee;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Builder @Data
public class IdeeDTO {
    private Long id;
    private Integer vote;
    private String titre;
    private String description;

    public static IdeeDTO fromEntity(Idee idee){
        if (idee == null){
            return null;
        }
        return IdeeDTO.builder().build();
    }

    public static Idee toEntity(IdeeDTO ideeDTO){
        if (ideeDTO == null){
            return null;
        }
        Idee idee = new Idee();
        idee.setTitre(ideeDTO.getTitre());
        idee.setDescription(ideeDTO.getDescription());
        idee.setVote(ideeDTO.getVote());

        return idee;
    }
}
