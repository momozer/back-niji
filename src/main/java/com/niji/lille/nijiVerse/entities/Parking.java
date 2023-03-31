package com.niji.lille.nijiVerse.entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "parking")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Parking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;


    @Column(name = "places")
    private Integer places;


    @Column(name = "occupant")
    private String occupant;



}
