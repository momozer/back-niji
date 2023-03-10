package com.niji.lille.nijiVerse.controllers;

import com.niji.lille.nijiVerse.entities.Place;
import com.niji.lille.nijiVerse.services.PlaceService;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/places")
@CrossOrigin
public class PlaceController {

    private final PlaceService service;

    public PlaceController(PlaceService service) {
        this.service = service;
    }

    /**
     * Récupère toutes les places
     * @return la liste de toutes les places
     */
    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<Place> findAll() {
        return service.findAll();
    }

    /**
     * Crée une nouvelle place
     * @param entity les infos de la place à créer
     * @return la place sauvegardé
     */
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Place save(Place entity) {
        return service.save(entity);
    }

    /**
     * Met à jour les informations d'une place
     * @param place les informations de la place à modifier
     * @return la place modifiée
     */
    @PutMapping("{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Place update(@RequestBody Place place, @PathVariable String id) {
        if (!id.equals(place.getId())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id non trouvé.");
        }
        return this.service.update(place);
    }

    /**
     * Recherche une place par son id.
     * Si aucune place n'est trouvée, retourne un 404
     * @param id l'id de la place à trouver
     * @return la place trouvée
     */
    @GetMapping("{id}")
    @ResponseStatus(code = HttpStatus.FOUND)
    public Place findById(@PathVariable String id) {
        return service.findById(id);
    }

    /**
     * Supprime un event par son id
     * @param id l'id de l'event à supprimer
     */
    @DeleteMapping("{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void deleteById(@PathVariable String id) {
        service.deleteById(id);
    }
}
