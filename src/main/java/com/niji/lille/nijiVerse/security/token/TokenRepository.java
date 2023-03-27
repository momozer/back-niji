package com.niji.lille.nijiVerse.security.token;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TokenRepository  extends JpaRepository<Token, Long> {

    /**
     * La méthode findAllValidTokenByUser est une requête personnalisée (écrite en JPQL)
     * qui permet de récupérer tous les jetons (tokens) valides pour un utilisateur spécifique.
     * Elle prend en paramètre l'ID de l'utilisateur et retourne une liste de Token.
     * @param id de l'utilisateur
     * @return une liste de Token
     */
    @Query(value = """
      select t from Token t inner join User u\s
      on t.user.id = u.id\s
      where u.id = :id and (t.expired = false or t.revoked = false)\s
      """)
    List<Token> findAllValidTokenByUser(Long id);

    /**
     * La méthode findByToken permet de récupérer un objet Token à partir de son jeton (token) unique.
     * Elle prend en paramètre le jeton (token) en question et retourne un objet Optional<Token> pour prendre en compte
     * le cas où le jeton n'existe pas dans la base de données.
     * @param token le jeton (token) en question
     * @return un objet Optional<Token>
     */
    Optional<Token> findByToken(String token);
}
