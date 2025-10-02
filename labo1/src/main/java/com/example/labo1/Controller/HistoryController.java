package com.example.labo1.Controller;

import com.example.labo1.Model.History;
import com.example.labo1.Model.Person;
import com.example.labo1.Model.Series;
import com.example.labo1.Repositories.RepositoryPerson;
import com.example.labo1.Service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/history")
public class HistoryController {

    @Autowired
    private HistoryService historyService;


    @GetMapping("/{userId}")
    public List<Series> findAllByUserId(@PathVariable int userId) {
        return historyService.findSerieByUserId(userId);
    }
    @GetMapping("/allWatchedSerie")
    public List<Series> findAllWatchedSerie() {
        return historyService.findAllWatchedSerie();
    }

    @PostMapping("/{userId}/{serieId}")
    public boolean addSerieToHistory(@PathVariable int userId, @PathVariable int serieId) {
        return historyService.addASerieToHistory(userId, serieId);
    }

}
