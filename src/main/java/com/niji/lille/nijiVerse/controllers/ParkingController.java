package com.niji.lille.nijiVerse.controllers;

import com.niji.lille.nijiVerse.entities.Parking;
import com.niji.lille.nijiVerse.repositories.ParkingRepository;
import com.niji.lille.nijiVerse.services.serviceImpl.ParkingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/nijiverse/parkings")
@CrossOrigin(origins = "*", maxAge = 3600)
@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
class ParkingController {

    @Autowired
    private final ParkingServiceImpl service;

    @Autowired
    private ParkingRepository repository;

    public ParkingController(ParkingServiceImpl service) {
        this.service = service;
    }

    /**
     * Récupère tous les parking
     * @return la liste de tous les parkings
     */
    @GetMapping("/all")
    @MessageMapping("/user")
    @SendTo("place-dispo")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Parking> findAll() {
        return service.findAll();
    }

    /**
     * Crée un nouveau parking
     * @param entity les infos du parking à créer
     * @return le parking sauvegardé
     */
    @PostMapping("/create")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Parking save(@RequestBody Parking entity) {
        return service.save(entity);
    }

    /**
     * Met à jour les informations d'un parking
     * @param parking les informations du parking à modifier
     * @return le parking modifié
     */
    @PutMapping("/edit/{id}")
    @MessageMapping("places-restantes")
    @SendTo("topic/greetings")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Parking update(@RequestBody Parking parking, @PathVariable Long id) {
        if (!id.equals(parking.getId())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id non trouvé.");
        }
        return this.service.save(parking);
    }

    /**
     * Recherche un parking par son id.
     * Si aucun parking n'est trouvé, retourne un 404
     * @param id l'id du parking à trouver
     * @return le parking trouvé
     */
    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.FOUND)
    public Parking findById(Long id) {
            return service.findById(id);
    }

    /**
     * Supprime un event par son id
     * @param id l'id de l'event à supprimer
     */
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void deleteById(Long id) {
        service.deleteById(id);
    }



}
