package com.niji.lille.nijiVerse.entities;

import com.sun.xml.bind.v2.TODO;
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
    private int places;

//TODO: liste d'occupant ' @onetomany
    @Column(name = "occupant")
    private String occupant;



}
