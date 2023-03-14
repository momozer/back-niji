package com.niji.lille.nijiVerse.entities;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "idee")
public class Idee extends AbstractEntity{

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "vote")
    private Integer vote;

    @Column(name = "titre")
    private String titre;

    @Column(name = "description")
    private String description;


}
