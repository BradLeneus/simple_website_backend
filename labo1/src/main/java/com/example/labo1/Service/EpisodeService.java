package com.example.labo1.Service;

import com.example.labo1.Model.Episode;
import com.example.labo1.Repositories.RepositoryEpisode;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service pour gérer les opérations liées aux épisodes.
 * Fournit des méthodes pour récupérer, créer, supprimer et rechercher des épisodes.
 */
@Service
public class EpisodeService {

    /**
     * Repository pour accéder aux données des épisodes.
     */
    private final RepositoryEpisode repositoryEpisode;

    /**
     * Constructeur principal pour l'injection du repository.
     *
     * @param repositoryEpisode Le repository pour accéder aux épisodes.
     */
    public EpisodeService(RepositoryEpisode repositoryEpisode) {
        this.repositoryEpisode = repositoryEpisode;
    }

    /**
     * Récupère un épisode par son identifiant.
     *
     * @param episodeId L'identifiant de l'épisode.
     * @return L'épisode correspondant ou null s'il n'existe pas.
     */
    public Episode getById(int episodeId) {
        return repositoryEpisode.findById(episodeId).orElse(null);
    }

    /**
     * Récupère tous les épisodes d'une série donnée.
     *
     * @param seriesId L'identifiant de la série.
     * @return La liste des épisodes de la série.
     */
    public List<Episode> getEpisodesBySeries(int seriesId) {
        return repositoryEpisode.findBySeries_Id(seriesId);
    }

    /**
     * Crée un nouvel épisode.
     *
     * @param e L'épisode à créer.
     * @return true si la création a réussi.
     */
    public boolean createEpisode(Episode e) {
        repositoryEpisode.save(e);
        return true;
    }

    /**
     * Supprime un épisode par son identifiant.
     *
     * @param episodeId L'identifiant de l'épisode à supprimer.
     * @return true si la suppression a réussi.
     */
    public boolean deleteEpisode(int episodeId) {
        repositoryEpisode.deleteById(episodeId);
        return true;
    }

    /**
     * Récupère tous les épisodes correspondant à un titre donné.
     *
     * @param title Le titre de l'épisode à rechercher.
     * @return La liste des épisodes correspondant au titre.
     */
    public List<Episode> getAllByTitle(String title) {
        return repositoryEpisode.findAllByTitle(title);
    }
}
