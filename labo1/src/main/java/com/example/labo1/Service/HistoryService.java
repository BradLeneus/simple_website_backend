package com.example.labo1.Service;

import com.example.labo1.Model.History;
import com.example.labo1.Model.Series;
import com.example.labo1.Repositories.RepositoryHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Service pour gérer l'historique des séries vues par les utilisateurs.
 * Fournit des méthodes pour récupérer les séries vues et ajouter des entrées à l'historique.
 */
@Service
public class HistoryService {

    /**
     * Repository pour accéder aux historiques.
     */
    private final RepositoryHistory repositoryHistory;

    @Autowired
    private PersonService personService;

    @Autowired
    private SeriesService seriesService;

    /**
     * Constructeur principal pour l'injection du repository d'historique.
     *
     * @param repositoryHistory Le repository pour accéder aux historiques.
     */
    public HistoryService(RepositoryHistory repositoryHistory) {
        this.repositoryHistory = repositoryHistory;
    }

    /**
     * Récupère la liste des séries vues par un utilisateur donné.
     *
     * @param userId L'identifiant de l'utilisateur.
     * @return Liste des séries vues par l'utilisateur.
     */
    public List<Series> findSerieByUserId(Integer userId) {
        List<Series> seriesList = new ArrayList<>();
        List<History> histories = repositoryHistory.findHistoriesByPerson_Id(userId);
        for (History history : histories) {
            seriesList.add(history.getSeries());
        }
        return seriesList;
    }

    /**
     * Récupère toutes les séries qui ont été vues par tous les utilisateurs.
     *
     * @return Liste de toutes les séries vues.
     */
    public List<Series> findAllWatchedSerie() {
        List<Series> seriesList = new ArrayList<>();
        List<History> histories = repositoryHistory.findAll();
        for (History history : histories) {
            seriesList.add(history.getSeries());
        }
        return seriesList;
    }

    /**
     * Ajoute une série à l'historique d'un utilisateur.
     *
     * @param userId   L'identifiant de l'utilisateur.
     * @param seriesId L'identifiant de la série.
     * @return true si l'ajout a réussi.
     */
    public boolean addASerieToHistory(int userId, int seriesId) {
        History history = new History();
        history.setSeries(seriesService.getByid(seriesId));
        history.setPerson(personService.getByid(userId));
        repositoryHistory.save(history);
        return true;
    }
}
