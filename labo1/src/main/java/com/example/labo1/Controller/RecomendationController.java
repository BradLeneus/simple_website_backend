package com.example.labo1.Controller;

import com.example.labo1.Model.Series;
import com.example.labo1.Service.RecommendationSerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Dictionary;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/person")
public class RecomendationController {

    @Autowired
    private RecommendationSerieService recommendationSerieService;


    @GetMapping("/gender")
    public List<String> TrendingGender() {
        return recommendationSerieService.getMostViewGender();
    }
    @GetMapping("/tendence/{userId}")
    public List<Series> TendenceSerieToUser(@PathVariable int userId) {
        return recommendationSerieService.recommendNonWatchedSerie(userId, true);
    }
    @GetMapping("/reco/{userId}")
    public List<Series> reommendSerieToUser(@PathVariable int userId) {
        return recommendationSerieService.recommendNonWatchedSerie(userId, false);
    }


}
