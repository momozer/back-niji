package com.niji.lille.nijiVerse.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

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
    private LocalDateTime date;

    @Column(name = "category", nullable = false)
    private Category category;

    @Column(name = "lieu", nullable = false)
    private String lieu;

    @Column(name = "titre")
    private String titre;

    @Column(name = "description")
    private String description;

    // TODO : join column with user_id
    //@ManyToOne()
    @Column(name = "organisateur")
    private String organisateur;

    @Column(name="image_url")
    private String image_url;

}
