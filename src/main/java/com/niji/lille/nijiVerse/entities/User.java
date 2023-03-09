package com.niji.lille.nijiVerse.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User extends AbstractEntity{

    @Id
    @Column(name = "id" )
    private String id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "username")
    private String username;

    @Column(name = "dateNaissance")
    private LocalDate dateNaissance;

    @Column(name = "email" )
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "motPasse")
    private String motPasse;

}
