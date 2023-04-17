package com.niji.lille.nijiVerse.services;

import com.niji.lille.nijiVerse.entities.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

public interface UserService {

     List<User> findAll();

    /**
     * Crée un nouveau user
     * @param entity les infos du user à créer
     * @return l'user sauvegardé
     */
    User save(User entity) ;

    /**
     * Met à jour les informations d'un user
     * @param user les informations du user à modifier
     * @return l'user modifié
     */
    public User update(User user) ;

    /**
     * Recherche un user par son id.
     * Si aucun user n'est trouvé, retourne un 404
     * @param id l'id du user à trouver
     * @return l'user trouvé
     */
    public User findById(Long id) ;

    /**
     * Recherche un user par son email.
     * @param email de l'user à rechercher
     * @return l'user correspondant à l'email
     */
    public Optional<User> findByEmail(String email);
    public Optional<User> findByUsername(String username);

    /**
     * Supprime un user par son id
     * @param id l'id du user à supprimer
     */
    public void deleteById(Long id);
}
