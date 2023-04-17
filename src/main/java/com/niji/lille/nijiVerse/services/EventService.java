package com.niji.lille.nijiVerse.services;

import com.niji.lille.nijiVerse.entities.Event;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

public interface EventService {

    /**
     * Récupère tous les events
     * @return la liste de tous les events
     */
     List<Event> findAll();

    /**
     * Crée un nouvel event
     * @param entity les infos de l'event à créer
     * @return l'event sauvegardé
     */
    Event save(Event entity);

    /**
     * Met à jour les informations d'un event
     * @param event les informations de l'event à modifier
     * @return le client modifié
     */
     Event update(Event event) ;

    /**
     * Recherche un event par son id.
     * Si aucun event n'est trouvé, retourne un 404
     * @param id l'id de l'event à trouver
     * @return l'event trouvé
     */
    Event findById(Long id) ;

    /**
     * Supprime un event par son id
     * @param id l'id de l'event à supprimer
     */
    void deleteById(Long id);
}
