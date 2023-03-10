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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDirecteur() {
        return directeur;
    }

    public void setDirecteur(String directeur) {
        this.directeur = directeur;
    }

    public String getRessourcesHumaines() {
        return ressourcesHumaines;
    }

    public void setRessourcesHumaines(String ressourcesHumaines) {
        this.ressourcesHumaines = ressourcesHumaines;
    }

    public String getManageur() {
        return manageur;
    }

    public void setManageur(String manageur) {
        this.manageur = manageur;
    }

    public String getCollaborateur() {
        return collaborateur;
    }

    public void setCollaborateur(String collaborateur) {
        this.collaborateur = collaborateur;
    }

    public String getStagiaire() {
        return stagiaire;
    }

    public void setStagiaire(String stagiaire) {
        this.stagiaire = stagiaire;
    }
}
