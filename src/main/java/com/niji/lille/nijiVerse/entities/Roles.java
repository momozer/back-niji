package com.niji.lille.nijiVerse.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "roles")
public class Roles extends AbstractEntity{

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "role")
    private String role;

    @OneToMany(mappedBy = "role")
    private List<User> users;


}
