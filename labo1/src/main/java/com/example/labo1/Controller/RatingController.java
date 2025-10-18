package com.example.labo1.Controller;


import com.example.labo1.Model.EpisodesRatings;
import com.example.labo1.Service.EpisodeRatingsService;
import com.example.labo1.Service.SeriesRatingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    SeriesRatingsService seriesRatingsService;

    @Autowired
    EpisodeRatingsService episodeRatingsService;


    @PostMapping("/series/{SeriesId}")
    public boolean rateSeries(@PathVariable int SeriesId, @RequestParam int personId, @RequestParam double rating){
        return seriesRatingsService.rateSeries(SeriesId, personId, rating);
    }


    @GetMapping("/series/{seriesId}")
    public Double getAverageRating(@PathVariable int seriesId){
        return seriesRatingsService.getAverageRating(seriesId);
    }


    @PostMapping("/episodes/{episodesId}")
    public boolean rateEpisodes(@PathVariable int episodesId, @RequestParam int personId, @RequestParam double rating){
        return episodeRatingsService.rateEpisodes(episodesId,personId,rating);
    }

    @GetMapping("/episodes/{episodesId}")
    public Double getEpisodeAverageRating(@PathVariable int episodesId){
        return episodeRatingsService.getAverageRating(episodesId);
    }
}
