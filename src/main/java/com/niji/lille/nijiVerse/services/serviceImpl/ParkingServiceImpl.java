package com.niji.lille.nijiVerse.services;

import com.niji.lille.nijiVerse.entities.Event;
import com.niji.lille.nijiVerse.entities.Parking;
import com.niji.lille.nijiVerse.repositories.ParkingRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Slf4j
public class ParkingServiceImpl {

    private Logger logger = LoggerFactory.getLogger(Event.class);

    private ParkingRepository repository;


    public ParkingServiceImpl(ParkingRepository repository){
        this.repository = repository;
    }

    /**
     * Récupère
     * @return la liste de tous les parkings
     */
    public List<Parking> findAll() {
        return repository.findAll();
    }

    /**
     * Crée un nouveau parking
     * @param entity les infos du parking à créer
     * @return le parking sauvegardé
     */
    public Parking save(Parking entity) {
        return repository.save(entity);
    }

    /**
     * Met à jour les informations d'un parking
     * @param parking les informations du parking à modifier
     * @return le parking modifié
     */
    public Parking update(Parking parking) {
        if (!this.repository.existsById(parking.getId())){
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "event non trouvé.");
        }
        return this.repository.save(parking);
    }

    /**
     * Recherche un parking par son id.
     * Si aucun parking n'est trouvé, retourne un 404
     * @param id l'id du parking à trouver
     * @return le parking trouvé
     */
    public Parking findById(Long id) {
        return repository.findById(id).orElseThrow(() -> {
            logger.warn("findByIdInvalid: " +id);
            return new ResponseStatusException(HttpStatus.NOT_FOUND);
        });
    }


    /**
     * Supprime un event par son id
     * @param id l'id de l'event à supprimer
     */
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
