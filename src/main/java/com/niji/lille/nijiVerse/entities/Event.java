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
    private String id;

    @Column(name = "date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDate date;

    @Column(name = "category")
    private Category category;

    @Column(name = "lieu")
    private String lieu;

    @Column(name = "commentaire")
    private String commentaire;

    @Column(name = "organisateurId")
    private String organisateurId;


}
