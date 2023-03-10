package com.niji.lille.nijiVerse.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "parking")
public class Parking extends AbstractEntity{

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "placeLibre")
    private Integer placeLibre;

    @Column(name = "placeMax")
    private Integer placeMax = 6;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getPlaceLibre() {
        return placeLibre;
    }

    public void setPlaceLibre(Integer placeLibre) {
        this.placeLibre = placeLibre;
    }

    public Integer getPlaceMax() {
        return placeMax;
    }

    public void setPlaceMax(Integer placeMax) {
        this.placeMax = placeMax;
    }
}
