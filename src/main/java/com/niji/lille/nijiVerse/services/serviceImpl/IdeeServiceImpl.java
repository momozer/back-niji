package com.niji.lille.nijiVerse.services.serviceImpl;

import com.niji.lille.nijiVerse.entities.Idee;
import com.niji.lille.nijiVerse.repositories.IdeeRepository;
import com.niji.lille.nijiVerse.services.IdeeService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Slf4j
public class IdeeServiceImpl implements IdeeService {

    private Logger logger = LoggerFactory.getLogger(Idee.class);

    private IdeeRepository repository;

    public IdeeServiceImpl(IdeeRepository repository) {
        this.repository = repository;
    }

    /**
     * Récupère toutes les idees
     * @return la liste de toutes les idees
     */
    public List<Idee> findAll() {
        logger.info("Return all Idee");
        return repository.findAll();
    }

    /**
     * Crée une nouvelle idee
     * @param entity les infos de l'idee à créer
     * @return l'idee sauvegardée
     */
    public Idee save(Idee entity) {
        logger.info("save a new idea " + entity);
        return repository.save(entity);
    }

    /**
     * Met à jour les informations d'une idee
     * @param idee les informations de l'idee à modifier
     * @return l'idee modifié
     */
    public Idee update(Idee idee) {
        if (!this.repository.existsById(idee.getId())){
            logger.warn("returns if the idee is found " + idee.getId() + idee.getTitre());
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "idee non trouvé.");
        }
        logger.info("save a new idee " + idee);
        return this.repository.save(idee);
    }

    /**
     * Recherche une idee par son id.
     * Si aucune idee n'est trouvée, retourne un 404
     * @param id l'id de l'idee à trouver
     * @return l'idee trouvée
     */
    public Idee findById(Long id) {
        return repository.findById(id).orElseThrow(() -> {
            logger.warn("findByIdInvalid: " + id);
            return new ResponseStatusException(HttpStatus.NOT_FOUND);
        });
    }
    /**
     * Supprime une idee par son id
     * @param id l'id de l'idee à supprimer
     */
    public void deleteById(Long id){
        logger.info("delete idee "+ id);
        repository.deleteById(id);
    }
}
