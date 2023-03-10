package com.niji.lille.nijiVerse.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "event")
@AllArgsConstructor
@NoArgsConstructor
public class Event extends AbstractEntity{

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDate date;

    @Column(name = "category")
    private Category category;

    @Column(name = "lieu")
    private String lieu;

    @Column(name = "commentaire")
    private String commentaire;

    @Column(name = "organisateurId")
    private String organisateurId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public String getOrganisateurId() {
        return organisateurId;
    }

    public void setOrganisateurId(String organisateurId) {
        this.organisateurId = organisateurId;
    }
}
