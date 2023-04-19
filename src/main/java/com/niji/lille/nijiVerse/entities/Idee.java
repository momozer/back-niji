package com.niji.lille.nijiVerse.entities;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "idees_organizer",
            joinColumns = @JoinColumn(name = "idee_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private User organizer ;


}
