package com.example.labo1.Controller;

import com.example.labo1.Model.Series;
import com.example.labo1.Service.SeriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Contrôleur pour gérer les opérations liées aux séries.
 * Permet de créer, lire, mettre à jour et supprimer des séries,
 * ainsi que de filtrer les séries par genre.
 */
@RestController
@CrossOrigin
@RequestMapping("/series")
public class SeriesController {

    /**
     * Service pour gérer la logique métier des séries.
     */
    @Autowired
    SeriesService seriesService;

    /**
     * Filtre les séries par genre.
     *
     * @param genre Genre des séries à filtrer.
     * @return Liste des séries correspondant au genre.
     */
    @GetMapping("/search/{genre}")
    public List<Series> filterSerieByGenre(@PathVariable String genre) {
        return seriesService.getAllByGenre(genre);
    }

    /**
     * Retourne toutes les séries.
     *
     * @return Liste complète des séries.
     */
    @GetMapping("/getAll")
    public List<Series> getAllSeries() {
        return seriesService.getAllSeries();
    }

    /**
     * Récupère une série par son identifiant.
     *
     * @param id Identifiant de la série.
     * @return La série correspondante.
     */
    @GetMapping("/getById/{id}")
    public Series getSerieById(@PathVariable int id) {
        return seriesService.getByid(id);
    }

    /**
     * Supprime une série par son identifiant.
     *
     * @param id Identifiant de la série à supprimer.
     * @return true si la suppression a réussi, false sinon.
     */
    @DeleteMapping("/deleteById/{id}")
    public boolean deleteById(@PathVariable int id) {
        return seriesService.deleteById(id);
    }

    /**
     * Crée une nouvelle série.
     *
     * @param s Objet Series contenant les informations de la série.
     * @return true si la création a réussi, false sinon.
     */
    @PostMapping("/newSerie")
    public boolean createSerie(@RequestBody Series s) {
        return seriesService.createSerie(s);
    }

    /**
     * Met à jour le titre d'une série.
     *
     * @param title Nouveau titre de la série.
     * @param id    Identifiant de la série à modifier.
     * @return true si la mise à jour a réussi.
     */
    @PutMapping("/modifyTitle/{id}/{title}")
    public boolean updateTitle(@PathVariable String title, @PathVariable int id) {
        seriesService.updateSerieTitle(id, title);
        return true;
    }

    /**
     * Met à jour le genre d'une série.
     *
     * @param genre Nouveau genre de la série.
     * @param id    Identifiant de la série à modifier.
     * @return true si la mise à jour a réussi.
     */
    @PutMapping("/modifyGenre/{id}/{genre}")
    public boolean updateGenre(@PathVariable String genre, @PathVariable int id) {
        seriesService.updateSerieGenre(id, genre);
        return true;
    }

    /**
     * Met à jour le nombre d'épisodes d'une série.
     *
     * @param episodesNumber Nouveau nombre d'épisodes.
     * @param id             Identifiant de la série à modifier.
     * @return true si la mise à jour a réussi.
     */
    @PutMapping("/modifyEpisodesNumber/{id}/{episodesNumber}")
    public boolean updateEpisodesNumber(@PathVariable int episodesNumber, @PathVariable int id) {
        seriesService.updateSerieEpisodesNumber(id, episodesNumber);
        return true;
    }
}