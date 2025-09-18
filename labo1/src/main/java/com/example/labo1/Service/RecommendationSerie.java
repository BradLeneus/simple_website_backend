package com.example.labo1.Service;

import com.example.labo1.Model.Series;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendationSerie {

    @Autowired
    private HistoryService historyService;
    @Autowired
    private SeriesService seriesService;

//    public List<Series> getMostViewGender(){
//        List
//        return historyService.findAllWatchedSerie();
//    }
}
