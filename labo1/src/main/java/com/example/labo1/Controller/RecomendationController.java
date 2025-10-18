package com.example.labo1.Controller;

import com.example.labo1.Model.Series;
import com.example.labo1.Service.RecommendationSerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Contrôleur pour gérer les recommandations de séries pour les utilisateurs.
 * Permet de récupérer les tendances générales, les genres populaires et
 * de recommander des séries à un utilisateur spécifique.
 */
@RestController
@CrossOrigin
@RequestMapping("/person")
public class RecomendationController {

    /**
     * Service pour générer les recommandations de séries.
     */
    @Autowired
    private RecommendationSerieService recommendationSerieService;

    /**
     * Retourne la liste des genres les plus regardés.
     *
     * @return Liste des genres en tendance.
     */
    @GetMapping("/gender")
    public List<String> TrendingGender() {
        return recommendationSerieService.getMostViewGender();
    }

    /**
     * Retourne les séries tendances recommandées pour un utilisateur spécifique.
     * Ne retourne que les séries que l'utilisateur n'a pas encore regardées.
     *
     * @param userId Identifiant de l'utilisateur.
     * @return Liste des séries recommandées pour l'utilisateur.
     */
    @GetMapping("/tendence/{userId}")
    public List<Series> TendenceSerieToUser(@PathVariable int userId) {
        return recommendationSerieService.recommendNonWatchedSerie(userId, true);
    }

    /**
     * Retourne les séries tendances globales (non spécifiques à un utilisateur).
     *
     * @return Liste des séries en tendance.
     */
    @GetMapping("/tendence")
    public List<Series> TendenceGeneral() {
        return recommendationSerieService.tendance();
    }

    /**
     * Retourne une recommandation de séries personnalisée pour un utilisateur.
     * Inclut toutes les recommandations, pas seulement les tendances.
     *
     * @param userId Identifiant de l'utilisateur.
     * @return Liste de séries recommandées pour l'utilisateur.
     */
    @GetMapping("/reco/{userId}")
    public List<Series> reommendSerieToUser(@PathVariable int userId) {
        return recommendationSerieService.recommendNonWatchedSerie(userId, false);
    }
}
