package com.niji.lille.nijiVerse.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "event")
public class Event {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "date", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    private LocalDate date;

    @Column(name = "category", nullable = false)
    private Category category;

    @Column(name = "lieu", nullable = false)
    private String lieu;

    @Column(name = "titre")
    private String titre;

    @Column(name = "commentaire")
    private String commentaire;

    @Column(name = "organisateur")
    private String organisateur;


}
