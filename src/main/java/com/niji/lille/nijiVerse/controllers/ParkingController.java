package com.niji.lille.nijiVerse.controllers;

import com.niji.lille.nijiVerse.entities.Parking;
import com.niji.lille.nijiVerse.services.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/parkings")
@CrossOrigin
public class ParkingController {

    @Autowired
    private final ParkingService service;

    public ParkingController(ParkingService service) {
        this.service = service;
    }

    /**
     * Récupère tous les parking
     * @return la liste de tous les parkings
     */
    @GetMapping("/all")
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
    public Parking save(Parking entity) {
        return service.save(entity);
    }

    /**
     * Met à jour les informations d'un parking
     * @param parking les informations du parking à modifier
     * @return le parking modifié
     */
    @PutMapping("/edit/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Parking update(Parking parking, String id) {
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
    public Parking findById(String id) {
            return service.findById(id);
    }

    /**
     * Supprime un event par son id
     * @param id l'id de l'event à supprimer
     */
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void deleteById(String id) {
        service.deleteById(id);
    }


}
