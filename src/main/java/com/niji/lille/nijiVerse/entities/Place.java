package com.niji.lille.nijiVerse.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.annotation.Documented;

@Data
@Table(name = "place")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Place extends AbstractEntity{

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "occupe")
    private boolean occupe;
}
