package com.example.labo1.Controller;


import com.example.labo1.Service.RatingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    RatingsService  ratingsService;


    @PostMapping("/series/{SeriesId}")
    public boolean rateSeries(@PathVariable int SeriesId, @RequestParam int personId, @RequestParam int rating){
        return ratingsService.rateSeries(SeriesId, personId, rating);
    }


    @GetMapping("/series/{seriesId}")
    public Double getAverageRating(@PathVariable int seriesId){
        return ratingsService.getAverageRating(seriesId);
    }
}
