package com.niji.lille.nijiVerse.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.data.annotation.Id;

public class AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
}
