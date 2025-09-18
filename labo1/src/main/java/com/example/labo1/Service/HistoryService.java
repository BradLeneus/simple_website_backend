package com.example.labo1.Service;


import com.example.labo1.Model.History;
import com.example.labo1.Model.Series;
import com.example.labo1.Repositories.IRepositorySeries;
import com.example.labo1.Repositories.RepositoryHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Service
public class HistoryService {
    private  final RepositoryHistory repositoryHistory;
    @Autowired
    PersonService personService;
    @Autowired
    SeriesService seriesService;
    public HistoryService(RepositoryHistory repositoryHistory){
        this.repositoryHistory = repositoryHistory;
    }


    public List<Series> findSerieByUserId(Integer userId){
        List<Series> seriesList = new ArrayList<>();
        List<History> histories = repositoryHistory.findHistoriesByPerson_Id(userId);
        for(History history : histories){
            seriesList.add(history.getSeries());
        }
      return seriesList;
    }
    public List<Series> findAllWatchedSerie(){
        List<Series> seriesList = new ArrayList<>();
        List<History> histories = repositoryHistory.findAll();
        for(History history : histories){
            seriesList.add(history.getSeries());
        }
        return seriesList;
    }


    public boolean addASerieToHistory(int userId, int seriesId){
        History history = new History();
        history.setSeries(seriesService.getByid(seriesId));
        history.setPerson(personService.getByid(userId));
        repositoryHistory.save(history);
        return true;
    }
}
