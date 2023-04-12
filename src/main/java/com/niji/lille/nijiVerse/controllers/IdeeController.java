package com.niji.lille.nijiVerse.controllers;
import com.niji.lille.nijiVerse.entities.Idee;
import com.niji.lille.nijiVerse.services.IdeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/nijiverse/idees")
@CrossOrigin(origins = "*", maxAge = 3600)

public class IdeeController {

    @Autowired
    private final IdeeService service;

    public IdeeController(IdeeService service) {
        this.service = service;
    }

    /**
     * Récupère tous les events
     *
     * @return la liste de tous les events
     */
    @GetMapping("/all")
    @ResponseStatus(code = HttpStatus.OK)
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    List<Idee> findAll() {
        return service.findAll();
    }

    /**
     * Crée une nouvelle idee
     *
     * @param entity les infos de l'idee à créer
     * @return l'idee sauvegardée
     */
    @PostMapping("/create")
    @ResponseStatus(code = HttpStatus.CREATED)
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    Idee save(@RequestBody Idee entity) {
        return service.save(entity);
    }

    /**
     * Met à jour les informations d'une idee
     *
     * @param idee les informations de l'idee à modifier
     * @return l'idee modifiée
     */
    @PutMapping("/edit/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    Idee update(@RequestBody Idee idee, @PathVariable Long id) {
        if (!id.equals(idee.getId())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id non trouvé.");
        }
        return this.service.update(idee);
    }

    /**
     * Recherche une idee par son id.
     * Si aucune idee n'est trouvée, retourne un 404
     * @param id l'id de l'idee à trouver
     * @return l'idee trouvé
     */
    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.FOUND)
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    Idee findById(@PathVariable Long id) {
        return service.findById(id);
    }

    /**
     * Supprime une idee par son id
     *
     * @param id l'id de l'idee à supprimer
     */
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }
}
