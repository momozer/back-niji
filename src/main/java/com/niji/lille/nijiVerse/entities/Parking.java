package com.niji.lille.nijiVerse.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Table(name = "parking")
public class Parking extends AbstractEntity{

    @Id
    @Column(name = "id")
    private String id;


    @Column(name = "placeMax")
    private Integer placeMax = 6;


}
