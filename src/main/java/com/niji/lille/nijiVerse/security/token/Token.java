package com.niji.lille.nijiVerse.security.token;

import com.niji.lille.nijiVerse.entities.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Token {
    /**
     * Ce code définit une entité Token qui est mappée à une table dans une base de données.
     * La table contient les colonnes suivantes :
     *
     * id : une clé primaire auto-générée.
     * token : une chaîne de caractères unique qui représente le jeton d'authentification.
     * tokenType : une énumération qui représente le type de jeton, Bearer ou autre.
     * revoked : un booléen qui indique si le jeton a été révoqué.
     * expired : un booléen qui indique si le jeton a expiré.
     * user : une relation many-to-one vers l'entité User pour laquelle le jeton a été émis.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @Column(unique = true)
    public String token;

    @Enumerated(EnumType.STRING)
    public TokenType tokenType = TokenType.BEARER;

    public boolean revoked;

    public boolean expired;

    @ManyToOne
    @JoinColumn(name = "user_id")
    public User user;
}
