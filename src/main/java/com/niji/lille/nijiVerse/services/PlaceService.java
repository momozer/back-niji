package com.niji.lille.nijiVerse.services;

import com.niji.lille.nijiVerse.entities.Event;
import com.niji.lille.nijiVerse.entities.Place;
import com.niji.lille.nijiVerse.repositories.EventRepository;
import com.niji.lille.nijiVerse.repositories.PlaceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PlaceService {

    private Logger logger = LoggerFactory.getLogger(Event.class);

    private PlaceRepository repository;

    public PlaceService(PlaceRepository repository){
        this.repository = repository;
    }

    /**
     * Récupère toutes les places
     * @return la liste de toutes les places
     */
    public List<Place> findAll() {
        return repository.findAll();
    }

    /**
     * Crée une nouvelle place
     * @param entity les infos de la place à créer
     * @return la place sauvegardé
     */
    public Place save(Place entity) {
        return repository.save(entity);
    }

    /**
     * Met à jour les informations d'une place
     * @param place les informations de la place à modifier
     * @return la place modifiée
     */
    public Place update(Place place) {
        if (!this.repository.existsById(place.getId())){
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "event non trouvé.");
        }
        return this.repository.save(place);
    }

    /**
     * Recherche une place par son id.
     * Si aucune place n'est trouvée, retourne un 404
     * @param id l'id de la place à trouver
     * @return la place trouvée
     */
    public Place findById(String id) {
        return repository.findById(id).orElseThrow(() -> {
            logger.warn("findByIdInvalid: " +id);
            return new ResponseStatusException(HttpStatus.NOT_FOUND);
        });
    }

    /**
     * Supprime un event par son id
     * @param id l'id de l'event à supprimer
     */
    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
