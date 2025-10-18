package com.example.labo1.Service;

import com.example.labo1.Model.SeriesRatings;
import com.example.labo1.Repositories.RepositoryRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service de gestion des notes attribuées aux séries par les utilisateurs.
 * Permet de créer, mettre à jour et calculer la note moyenne d'une série.
 */
@Service
public class SeriesRatingsService {

    private final RepositoryRating repositoryRating;

    @Autowired
    SeriesService seriesService;

    @Autowired
    PersonService personService;

    /**
     * Constructeur injectant le repository de gestion des ratings.
     *
     * @param repositoryRating Repository pour accéder aux données des notes.
     */
    public SeriesRatingsService(RepositoryRating repositoryRating) {
        this.repositoryRating = repositoryRating;
    }

    /**
     * Attribue ou met à jour la note d'une série pour un utilisateur donné.
     * Si aucune note n'existe pour cet utilisateur et cette série, une nouvelle est créée.
     *
     * @param personId Identifiant de l'utilisateur qui note.
     * @param seriesId Identifiant de la série à noter.
     * @param rating   Valeur de la note à attribuer.
     * @return true si l'opération est réussie.
     */
    public boolean rateSeries(int personId, int seriesId, double rating) {
        SeriesRatings seriesRatings = repositoryRating.findByPerson_IdAndSeries_Id(personId, seriesId);

        if (seriesRatings == null) {
            seriesRatings = new SeriesRatings();
            seriesRatings.setPerson(personService.getByid(personId));
            seriesRatings.setSeries(seriesService.getByid(seriesId));
        }

        seriesRatings.setRating(rating);
        repositoryRating.save(seriesRatings);
        return true;
    }

    /**
     * Calcule la note moyenne d'une série à partir de toutes les notes existantes.
     *
     * @param seriesId Identifiant de la série.
     * @return Note moyenne. Retourne 0.0 si aucune note n'est disponible.
     */
    public double getAverageRating(int seriesId) {
        Double avg = repositoryRating.avgForSeries(seriesId);
        return avg != null ? avg : 0.0;
    }
}
