package com.niji.lille.nijiVerse.dto;

import com.niji.lille.nijiVerse.entities.Event;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
@Builder @Data
public class EventDTO {
    private Long id;
    private LocalDate date;
    private CategoryDTO categoryDTO;
    private String lieu;
    private String titre;
    private String commentaire;
    private String organisateur;

    public static EventDTO fromEntity(Event event){
        if (event == null){
            return null;
        }
        return EventDTO.builder().build();
    }

    public static Event toEntity(EventDTO eventDTO){
        if (eventDTO == null){
            return null;
        }
        Event event = new Event();
        event.setOrganisateur(eventDTO.getOrganisateur());
        event.setTitre(eventDTO.getTitre());
        event.setDate(eventDTO.getDate());
        event.setLieu(eventDTO.getLieu());
        event.setCommentaire(eventDTO.getCommentaire());

        return event;
    }
}
