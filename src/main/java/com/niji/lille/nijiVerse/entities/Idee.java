package com.niji.lille.nijiVerse.entities;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "idee")
public class Idee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "vote")
    private Integer vote;

    @Column(name = "titre")
    private String titre;

    @Column(name = "description")
    private String description;

    // TODO: add creator id (ManyToOne)

}
