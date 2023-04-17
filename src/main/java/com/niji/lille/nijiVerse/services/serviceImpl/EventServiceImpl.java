package com.niji.lille.nijiVerse.services.serviceImpl;

import com.niji.lille.nijiVerse.entities.Event;
import com.niji.lille.nijiVerse.repositories.EventRepository;
import com.niji.lille.nijiVerse.services.EventService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Slf4j
public class EventServiceImpl implements EventService {

    private Logger logger = LoggerFactory.getLogger(Event.class);

    private EventRepository repository;

    public EventServiceImpl(EventRepository repository){
        this.repository = repository;
    }

    /**
     * Récupère tous les events
     * @return la liste de tous les events
     */
    public List<Event> findAll() {
        return repository.findAll();
    }

    /**
     * Crée un nouvel event
     * @param entity les infos de l'event à créer
     * @return l'event sauvegardé
     */
    public Event save(Event entity) {
        return repository.save(entity);
    }

    /**
     * Met à jour les informations d'un event
     * @param event les informations de l'event à modifier
     * @return le client modifié
     */
    public Event update(Event event) {
        if (!this.repository.existsById(event.getId())){
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "event non trouvé.");
        }
        return this.repository.save(event);
    }

    /**
     * Recherche un event par son id.
     * Si aucun event n'est trouvé, retourne un 404
     * @param id l'id de l'event à trouver
     * @return l'event trouvé
     */
    public Event findById(Long id) {
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
