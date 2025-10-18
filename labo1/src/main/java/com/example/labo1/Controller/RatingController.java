package com.example.labo1.Controller;

import com.example.labo1.Service.EpisodeRatingsService;
import com.example.labo1.Service.SeriesRatingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Contrôleur pour gérer les évaluations (ratings) des séries et des épisodes.
 * Permet de créer des notes et de récupérer la moyenne des notes.
 */
@RestController
@CrossOrigin
@RequestMapping("/ratings")
public class RatingController {

    /**
     * Service pour gérer les évaluations des séries.
     */
    @Autowired
    SeriesRatingsService seriesRatingsService;

    /**
     * Service pour gérer les évaluations des épisodes.
     */
    @Autowired
    EpisodeRatingsService episodeRatingsService;

    /**
     * Ajoute une note pour une série donnée.
     *
     * @param SeriesId L'identifiant de la série à noter.
     * @param personId L'identifiant de l'utilisateur qui note.
     * @param rating   La note attribuée (ex: 1.0 à 5.0).
     * @return true si la note a été ajoutée avec succès, false sinon.
     */
    @PostMapping("/series/{SeriesId}")
    public boolean rateSeries(@PathVariable int SeriesId,
                              @RequestParam int personId,
                              @RequestParam double rating){
        return seriesRatingsService.rateSeries(SeriesId, personId, rating);
    }

    /**
     * Récupère la note moyenne d'une série.
     *
     * @param seriesId L'identifiant de la série.
     * @return La note moyenne sous forme de Double.
     */
    @GetMapping("/series/{seriesId}")
    public Double getAverageRating(@PathVariable int seriesId){
        return seriesRatingsService.getAverageRating(seriesId);
    }

    /**
     * Ajoute une note pour un épisode donné.
     *
     * @param episodesId L'identifiant de l'épisode à noter.
     * @param personId   L'identifiant de l'utilisateur qui note.
     * @param rating     La note attribuée (ex: 1.0 à 5.0).
     * @return true si la note a été ajoutée avec succès, false sinon.
     */
    @PostMapping("/episodes/{episodesId}")
    public boolean rateEpisodes(@PathVariable int episodesId,
                                @RequestParam int personId,
                                @RequestParam double rating){
        return episodeRatingsService.rateEpisodes(episodesId, personId, rating);
    }

    /**
     * Récupère la note moyenne d'un épisode.
     *
     * @param episodesId L'identifiant de l'épisode.
     * @return La note moyenne sous forme de Double.
     */
    @GetMapping("/episodes/{episodesId}")
    public Double getEpisodeAverageRating(@PathVariable int episodesId){
        return episodeRatingsService.getAverageRating(episodesId);
    }
}
