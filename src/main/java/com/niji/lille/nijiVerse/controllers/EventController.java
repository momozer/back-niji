package com.niji.lille.nijiVerse.controllers;

import com.niji.lille.nijiVerse.entities.Event;
import com.niji.lille.nijiVerse.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/nijiverse/events")
@CrossOrigin("*")
@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
public class EventController {

    @Autowired
    private final EventService service;

    public EventController(EventService service) {
        this.service = service;
    }

    /**
     * Récupère tous les events
     *
     * @return la liste de tous les events
     */
    @GetMapping("/all")
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
    @PostMapping("/create")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Event save(@RequestBody Event entity) {
        return service.save(entity);
    }

    /**
     * Met à jour les informations d'un event
     *
     * @param event les informations de l'event à modifier
     * @return l'event modifié
     */
    @PutMapping("/edit/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Event update(@RequestBody Event event, @PathVariable Long id) {
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
    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.FOUND)
    public Event findById(@PathVariable Long id) {
        return service.findById(id);
    }

    /**
     * Supprime un event par son id
     *
     * @param id l'id de l'event à supprimer
     */
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }
}
