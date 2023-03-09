package com.niji.lille.nijiVerse.entities;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "idee")
public class Idee extends AbstractEntity{

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "vote")
    private Integer vote;

    @Column(name = "titre")
    private String titre;

    @Column(name = "description")
    private String description;
}
