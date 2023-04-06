package com.niji.lille.nijiVerse.controllers;
import com.niji.lille.nijiVerse.entities.User;
import com.niji.lille.nijiVerse.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@CrossOrigin("*")
public class UserController {

    //TODO

    @Autowired
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    /**
     * Récupère tous les users
     *
     * @return la liste de tous les users
     */
    @GetMapping("/all")
    @ResponseStatus(code = HttpStatus.OK)
    public List<User> findAll() {
        return service.findAll();
    }

    /**
     * Crée un nouvel user
     *
     * @param entity les infos du user à créer
     * @return l'user sauvegardé
     */
    @PostMapping("/create")
    @ResponseStatus(code = HttpStatus.CREATED)
    public User save(@RequestBody User entity) {
        return service.save(entity);
    }

    /**
     * Met à jour les informations d'un user
     *
     * @param user les informations du user à modifier
     * @return l'user modifié
     */
    @PutMapping("/edit/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public User update(@RequestBody User user, @PathVariable Long id) {
        if ( !id.equals(user.getId())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id non trouvé.");
        }
        return this.service.update(user);
    }

    /**
     * Recherche un user par son id.
     * Si aucun user n'est trouvé, retourne un 404
     * @param id l'id du user à trouver
     * @return l'user trouvé
     */
    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.FOUND)
    public User findById(@PathVariable Long id) {
        return service.findById(id);
    }
    
    /**
     * Recherche un user par son email.
     * Si aucun user n'est trouvé, retourne un 404
     * @param email l'email du user à trouver
     * @return l'user trouvé
     */
    @GetMapping("/{email}")
    @ResponseStatus(code = HttpStatus.FOUND)
    public Optional<User> findByEmail(@PathVariable String email){
        return  service.findByEmail(email);
    }

    /**
     * Recherche un user par son username
     * @param username de l'user à trouver
     * @return l'user trouvé
     */
    @GetMapping("/username")
    @ResponseStatus(code = HttpStatus.FOUND)
    public Optional<User> findByUsername(@PathVariable String username){
        return service.findByUsername(username);
    }

    /**
     * Supprime un user par son id
     *
     * @param id l'id du user à supprimer
     */
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }
}
