package com.niji.lille.nijiVerse.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "roles")
public class Roles extends AbstractEntity{

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "directeur")
    private String directeur;

    @Column(name = "ressourcesHumaines")
    private String ressourcesHumaines;

    @Column(name = "manageur")
    private String manageur;

    @Column(name = "collaborateur")
    private String collaborateur;

    @Column(name = "stagiaire")
    private String stagiaire;


}
