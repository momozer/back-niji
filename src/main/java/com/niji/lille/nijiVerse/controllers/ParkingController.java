package com.niji.lille.nijiVerse.controllers;

import com.niji.lille.nijiVerse.entities.Parking;
import com.niji.lille.nijiVerse.repositories.ParkingRepository;
import com.niji.lille.nijiVerse.services.ParkingService;
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

class ParkingController {

    //TODO : faire incremente(), getParking(), decrmente(), getPlace(), le reste ne pas exposer.

    @Autowired
    private final ParkingService service;

    @Autowired
    private ParkingRepository repository;

    public ParkingController(ParkingService service) {
        this.service = service;
    }

    /**
     * Récupère tous les parking
     * @return la liste de tous les parkings
     */
    @GetMapping("/all")
    @MessageMapping("/user")
    @SendTo("place-dispo")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Parking> findAll() {
        return service.findAll();
    }

    /**
     * Met à jour les informations d'un parking
     * @param parking les informations du parking à modifier
     * @return le parking modifié
     */
    @PutMapping("/edit/")
    @MessageMapping("places-restantes")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    @SendTo("topic/greetings")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Parking update(@RequestBody Parking parking) {
        return this.service.save(parking);
    }

    /**
     * Recherche un parking par son id.
     * Si aucun parking n'est trouvé, retourne un 404
     * @param id l'id du parking à trouver
     * @return le parking trouvé
     */
    @GetMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    @ResponseStatus(code = HttpStatus.FOUND)
    public Parking findById(Long id) {
            return service.findById(id);
    }

    /**
     * Supprime un event par son id
     * @param id l'id de le parking à supprimer
     */
    //@DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    @ResponseStatus(code = HttpStatus.OK)
    public void deleteById(Long id) {
        service.deleteById(id);
    }



}
