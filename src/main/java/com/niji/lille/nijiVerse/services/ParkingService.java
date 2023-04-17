package com.niji.lille.nijiVerse.services;

import com.niji.lille.nijiVerse.entities.Parking;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

public interface ParkingService {

    /**
     * Récupère
     * @return la liste de tous les parkings
     */
    List<Parking> findAll();

    /**
     * Crée un nouveau parking
     * @param entity les infos du parking à créer
     * @return le parking sauvegardé
     */
     Parking save(Parking entity);

    /**
     * Met à jour les informations d'un parking
     * @param parking les informations du parking à modifier
     * @return le parking modifié
     */
    Parking update(Parking parking) ;

    /**
     * Recherche un parking par son id.
     * Si aucun parking n'est trouvé, retourne un 404
     * @param id l'id du parking à trouver
     * @return le parking trouvé
     */
   Parking findById(Long id) ;


    /**
     * Supprime un event par son id
     * @param id l'id de l'event à supprimer
     */
    void deleteById(Long id);
}
