package com.niji.lille.nijiVerse.services;

import com.niji.lille.nijiVerse.entities.Idee;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

public interface IdeeService {

    /**
     * Récupère toutes les idees
     * @return la liste de toutes les idees
     */
    List<Idee> findAll();

    /**
     * Crée une nouvelle idee
     * @param entity les infos de l'idee à créer
     * @return l'idee sauvegardée
     */
     Idee save(Idee entity);

    /**
     * Met à jour les informations d'une idee
     * @param idee les informations de l'idee à modifier
     * @return l'idee modifié
     */
    Idee update(Idee idee) ;

    /**
     * Recherche une idee par son id.
     * Si aucune idee n'est trouvée, retourne un 404
     * @param id l'id de l'idee à trouver
     * @return l'idee trouvée
     */
     Idee findById(Long id) ;
    /**
     * Supprime une idee par son id
     * @param id l'id de l'idee à supprimer
     */
    void deleteById(Long id);
}
