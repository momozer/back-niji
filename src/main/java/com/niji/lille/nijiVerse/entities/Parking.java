package com.niji.lille.nijiVerse.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "parking")
public class Parking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;


    @Column(name = "placeMax")
    private Integer placeMax = 6;


    @Column(name = "occupant")
    private String occupant;


}
