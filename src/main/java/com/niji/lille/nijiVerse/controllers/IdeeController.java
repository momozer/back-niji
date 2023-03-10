package com.niji.lille.nijiVerse.controllers;

import com.niji.lille.nijiVerse.entities.Event;
import com.niji.lille.nijiVerse.entities.Idee;
import com.niji.lille.nijiVerse.services.IdeeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/idees")
@CrossOrigin
public class IdeeController {

    private final IdeeService service;

    public IdeeController(IdeeService service) {
        this.service = service;
    }

    /**
     * Récupère tous les events
     *
     * @return la liste de tous les events
     */
    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<Event> findAll() {
        return service.findAll();
    }

    /**
     * Crée un nouvel event
     *
     * @param entity les infos de l'event à créer
     * @return l'event sauvegardé
     */
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Event save(Event entity) {
        return service.save(entity);
    }

    /**
     * Met à jour les informations d'un event
     *
     * @param event les informations de l'event à modifier
     * @return l'event modifié
     */
    @PutMapping("{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Event update(@RequestBody Event event, @PathVariable String id) {
        if (!id.equals(event.getId())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id non trouvé.");
        }
        return this.service.update(event);
    }

    /**
     * Recherche un event par son id.
     * Si aucun event n'est trouvé, retourne un 404
     * @param id l'id de l'event à trouver
     * @return l'event trouvé
     */
    @GetMapping("{id}")
    @ResponseStatus(code = HttpStatus.FOUND)
    public Idee findById(@PathVariable String id) {
        return service.findById(id);
    }

    /**
     * Supprime une idee par son id
     *
     * @param id l'id de l'idee à supprimer
     */
    @DeleteMapping("{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void deleteById(@PathVariable String id) {
        service.deleteById(id);
    }
}
