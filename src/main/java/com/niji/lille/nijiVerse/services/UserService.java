package com.niji.lille.nijiVerse.services;

import com.niji.lille.nijiVerse.entities.User;
import com.niji.lille.nijiVerse.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UserService {

    private Logger logger = LoggerFactory.getLogger(User.class);

    private UserRepository repository;
    public UserService(UserRepository repository){
        this.repository = repository;
    }

    /**
     * Récupère tous les users
     * @return la liste de tous les users
     */
    public List<User> findAll() {
        return repository.findAll();
    }

    /**
     * Crée un nouveau user
     * @param entity les infos du user à créer
     * @return l'user sauvegardé
     */
    public User save(User entity) {
        return repository.save(entity);
    }

    /**
     * Met à jour les informations d'un user
     * @param user les informations du user à modifier
     * @return l'user modifié
     */
    public User update(User user) {
        if (!this.repository.existsById(user.getId())){
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "User non trouvé.");
        }
        return this.repository.save(user);
    }

    /**
     * Recherche un user par son id.
     * Si aucun user n'est trouvé, retourne un 404
     * @param id l'id du user à trouver
     * @return l'user trouvé
     */
    public User findById(Long id) {
        return repository.findById(id).orElseThrow(() -> {
            logger.warn("findByIdInvalid: " +id);
            return new ResponseStatusException(HttpStatus.NOT_FOUND);
        });
    }

    public User findByUsername(String username){
        return repository.findByUsername(username);
    }

    /**
     * Supprime un user par son id
     * @param id l'id du user à supprimer
     */
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Nom d'utilisateur (username) introuvable");
        }
        return user;
    }

}
