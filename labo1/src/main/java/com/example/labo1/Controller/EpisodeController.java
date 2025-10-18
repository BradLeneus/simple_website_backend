package com.example.labo1.Controller;

import com.example.labo1.Model.Episode;
import com.example.labo1.Service.EpisodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Contrôleur pour gérer les opérations CRUD sur les épisodes.
 * Permet de récupérer, créer, rechercher et supprimer des épisodes.
 */
@RestController
@CrossOrigin
@RequestMapping("/episodes")
public class EpisodeController {

    /**
     * Service pour gérer la logique métier des épisodes.
     */
    @Autowired
    EpisodeService episodeService;

    /**
     * Récupère un épisode par son identifiant.
     *
     * @param id L'identifiant de l'épisode.
     * @return L'épisode correspondant à l'ID fourni.
     */
    @GetMapping("/Id/{id}")
    public Episode getEpisode(@PathVariable int id) {
        return episodeService.getById(id);
    }

    /**
     * Recherche tous les épisodes correspondant à un titre donné.
     * La recherche est généralement insensible à la casse.
     *
     * @param title Le titre à rechercher.
     * @return Liste des épisodes correspondant au titre.
     */
    @GetMapping("/search/{title}")
    public List<Episode> searchByTitle(@PathVariable String title) {
        return episodeService.getAllByTitle(title);
    }

    /**
     * Crée un nouvel épisode dans la base de données.
     *
     * @param episode Objet Episode contenant toutes les informations nécessaires.
     * @return true si la création a réussi, false sinon.
     */
    @PostMapping("/newEpisode")
    public boolean createEpisode(@RequestBody Episode episode) {
        return episodeService.createEpisode(episode);
    }

    /**
     * Supprime un épisode à partir de son identifiant.
     *
     * @param id L'identifiant de l'épisode à supprimer.
     * @return true si la suppression a réussi, false sinon.
     */
    @DeleteMapping("/deletebyId")
    public boolean deleteEpisode(@PathVariable int id) {
        return episodeService.deleteEpisode(id);
    }
}
