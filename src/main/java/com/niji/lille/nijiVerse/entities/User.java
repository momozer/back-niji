package com.niji.lille.nijiVerse.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "user")
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
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

    @ManyToOne
    @JoinColumn(name = "id_role")
    private Roles role;
    


}
