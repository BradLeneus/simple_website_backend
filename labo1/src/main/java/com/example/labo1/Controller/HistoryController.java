package com.example.labo1.Controller;

import com.example.labo1.Model.Series;
import com.example.labo1.Service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Contrôleur pour gérer l'historique de visionnage des séries.
 * Permet de récupérer les séries regardées par un utilisateur,
 * d'ajouter une série à l'historique et de récupérer toutes les séries regardées.
 */
@RestController
@CrossOrigin
@RequestMapping("/history")
public class HistoryController {

    /**
     * Service pour gérer la logique métier liée à l'historique.
     */
    @Autowired
    private HistoryService historyService;

    /**
     * Récupère toutes les séries regardées par un utilisateur spécifique.
     *
     * @param userId L'identifiant de l'utilisateur.
     * @return Liste des séries regardées par l'utilisateur.
     */
    @GetMapping("/{userId}")
    public List<Series> findAllByUserId(@PathVariable int userId) {
        return historyService.findSerieByUserId(userId);
    }

    /**
     * Récupère toutes les séries qui ont été regardées par n'importe quel utilisateur.
     *
     * @return Liste de toutes les séries regardées.
     */
    @GetMapping("/allWatchedSerie")
    public List<Series> findAllWatchedSerie() {
        return historyService.findAllWatchedSerie();
    }

    /**
     * Ajoute une série à l'historique d'un utilisateur.
     *
     * @param userId  L'identifiant de l'utilisateur.
     * @param serieId L'identifiant de la série à ajouter.
     * @return true si l'ajout a réussi, false sinon.
     */
    @PostMapping("/{userId}/{serieId}")
    public boolean addSerieToHistory(@PathVariable int userId, @PathVariable int serieId) {
        return historyService.addASerieToHistory(userId, serieId);
    }
}
