package com.example.labo1.Service;

import com.example.labo1.Model.Episode;
import com.example.labo1.Model.EpisodesRatings;
import com.example.labo1.Model.Person;
import com.example.labo1.Repositories.RepositoryEpisodesRatings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service pour gérer les notes des épisodes.
 * Permet de créer ou mettre à jour une note pour un épisode par un utilisateur
 * et de calculer la note moyenne d'un épisode.
 */
@Service
public class EpisodeRatingsService {

    /**
     * Repository pour accéder aux notes des épisodes.
     */
    private final RepositoryEpisodesRatings repositoryEpisodesRatings;

    @Autowired
    EpisodeService episodeService;

    @Autowired
    PersonService personService;

    /**
     * Constructeur principal pour l'injection du repository.
     *
     * @param repositoryEpisodesRatings Le repository pour EpisodesRatings.
     */
    public EpisodeRatingsService(RepositoryEpisodesRatings repositoryEpisodesRatings) {
        this.repositoryEpisodesRatings = repositoryEpisodesRatings;
    }

    /**
     * Ajoute ou met à jour une note pour un épisode donné par un utilisateur.
     *
     * @param personId  L'identifiant de l'utilisateur.
     * @param episodeId L'identifiant de l'épisode.
     * @param rating    La note à attribuer (ex: 4.5).
     * @return true si l'opération a réussi.
     */
    public boolean rateEpisodes(int personId, int episodeId, double rating) {
        EpisodesRatings episodesRatings = repositoryEpisodesRatings.findByPerson_IdAndEpisode_Id(personId, episodeId);

        if (episodesRatings != null) {
            // Mise à jour de la note existante
            episodesRatings.setRating(rating);
            repositoryEpisodesRatings.save(episodesRatings);
        } else {
            // Création d'une nouvelle note
            Person person = personService.getByid(personId);
            Episode episode = episodeService.getById(episodeId);

            EpisodesRatings newRating = new EpisodesRatings();
            newRating.setEpisode(episode);
            newRating.setPerson(person);
            newRating.setRating(rating);

            repositoryEpisodesRatings.save(newRating);
        }
        return true;
    }

    /**
     * Calcule la note moyenne pour un épisode donné.
     *
     * @param episodeId L'identifiant de l'épisode.
     * @return La note moyenne. Retourne 0.0 si aucune note n'existe.
     */
    public double getAverageRating(int episodeId) {
        Double avg = repositoryEpisodesRatings.avgForEpisodes(episodeId);
        return avg == null ? 0.0 : avg;
    }
}
