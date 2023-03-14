package com.niji.lille.nijiVerse.controllers;

import com.niji.lille.nijiVerse.entities.Parking;
import com.niji.lille.nijiVerse.services.ParkingService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/parkings")
@CrossOrigin
public class ParkingController {

    private final ParkingService service;

    public ParkingController(ParkingService service) {
        this.service = service;
    }

    /**
     * Récupère tous les parking
     * @return la liste de tous les parkings
     */
    public List<Parking> findAll() {
        return service.findAll();
    }

    /**
     * Crée un nouveau parking
     * @param entity les infos du parking à créer
     * @return le parking sauvegardé
     */
    public Parking save(Parking entity) {
        return service.save(entity);
    }

    /**
     * Met à jour les informations d'un parking
     * @param parking les informations du parking à modifier
     * @return le parking modifié
     */
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
    public Parking findById(String id) {
            return service.findById(id);
    }

    /**
     * Supprime un event par son id
     * @param id l'id de l'event à supprimer
     */
    public void deleteById(String id) {
        service.deleteById(id);
    }


}
