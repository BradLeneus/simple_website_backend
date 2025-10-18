package com.example.labo1.Service;

import com.example.labo1.Model.Series;
import com.example.labo1.Repositories.IRepositorySeries;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service pour la gestion des séries.
 * Fournit des méthodes pour créer, récupérer, mettre à jour et supprimer des séries.
 */
@Service
public class SeriesService {

    private final IRepositorySeries repositorySeries;

    /**
     * Constructeur injectant le repository de séries.
     *
     * @param repositorySeries Repository pour accéder aux données des séries.
     */
    public SeriesService(IRepositorySeries repositorySeries) {
        this.repositorySeries = repositorySeries;
    }

    /**
     * Récupère toutes les séries existantes.
     *
     * @return Liste de toutes les séries.
     */
    public List<Series> getAllSeries() {
        return repositorySeries.findAll();
    }

    /**
     * Récupère toutes les séries correspondant à un genre donné.
     *
     * @param genre Genre recherché.
     * @return Liste des séries correspondant au genre.
     */
    public List<Series> getAllByGenre(String genre) {
        return repositorySeries.getAllByGenre(genre);
    }

    /**
     * Récupère une série à partir de son identifiant.
     *
     * @param id Identifiant de la série.
     * @return La série correspondante ou null si non trouvée.
     */
    public Series getByid(int id) {
        return repositorySeries.getSerieById(id);
    }

    /**
     * Supprime une série à partir de son identifiant.
     *
     * @param id Identifiant de la série.
     * @return true si la suppression a été effectuée.
     */
    public boolean deleteById(int id) {
        repositorySeries.deleteById(id);
        return true;
    }

    /**
     * Crée une nouvelle série.
     * La création est ignorée si une série avec le même titre existe déjà.
     *
     * @param s Série à créer.
     * @return true si la création a été effectuée.
     */
    public boolean createSerie(Series s) {
        if (repositorySeries.getAllByTitle(s.getTitle()) == null) {
            repositorySeries.save(s);
            return true;
        }
        return false;
    }

    /**
     * Met à jour le titre d'une série existante.
     *
     * @param id    Identifiant de la série.
     * @param title Nouveau titre.
     * @return true si la mise à jour a été effectuée.
     */
    public boolean updateSerieTitle(int id, String title) {
        Series findS = repositorySeries.getSerieById(id);
        findS.setTitle(title);
        repositorySeries.save(findS);
        return true;
    }

    /**
     * Met à jour le genre d'une série existante.
     *
     * @param id    Identifiant de la série.
     * @param genre Nouveau genre.
     * @return true si la mise à jour a été effectuée.
     */
    public boolean updateSerieGenre(int id, String genre) {
        Series findS = repositorySeries.getSerieById(id);
        findS.setGenre(genre);
        repositorySeries.save(findS);
        return true;
    }

    /**
     * Met à jour le nombre d'épisodes d'une série existante.
     *
     * @param id             Identifiant de la série.
     * @param episodesNumber Nouveau nombre d'épisodes.
     * @return true si la mise à jour a été effectuée.
     */
    public boolean updateSerieEpisodesNumber(int id, int episodesNumber) {
        Series findS = repositorySeries.getSerieById(id);
        findS.setEpisodesNumber(episodesNumber);
        repositorySeries.save(findS);
        return true;
    }

    /**
     * Met à jour la note d'une série existante.
     *
     * @param id     Identifiant de la série.
     * @param rating Nouvelle note.
     * @return true si la mise à jour a été effectuée.
     */
    public boolean updateSerieRating(int id, double rating) {
        Series findS = repositorySeries.getSerieById(id);
        findS.setRating(rating);
        repositorySeries.save(findS);
        return true;
    }
}
