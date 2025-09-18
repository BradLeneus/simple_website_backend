package com.example.labo1.Controller;

import com.example.labo1.Model.Person;
import com.example.labo1.Model.Series;
import com.example.labo1.Repositories.RepositoryPerson;
import com.example.labo1.Service.SeriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/series")
public class SeriesController {

    @Autowired
    SeriesService seriesService;

    @GetMapping("/search/{genre}")
    public List<Series> filterSerieByGenre(@PathVariable String genre){
       return  seriesService.getAllByGenre(genre);
    }


    @GetMapping("/getAll")
    public List<Series> getAllSeries(){


        return seriesService.getAllSeries() ;
    }

    @GetMapping("/getById/{id}")
    public Series getSerieById(@PathVariable int id){


        return seriesService.getByid(id);
    }


    @DeleteMapping("/deleteById/{id}")
    public boolean deleteById(@PathVariable int id){


        return seriesService.deleteById(id);
    }
    @PostMapping("/newSerie")
    public boolean createSerie(@RequestBody Series s){


        return seriesService.createSerie(s);
    }

    @PutMapping("/modifyTitle/{id}/{title}")
    public  boolean updateTitle(@PathVariable String title,@PathVariable int id){
        seriesService.updateSerieTitle(id,title);
        return  true;

    }

    @PutMapping("/modifyGenre/{id}/{genre}")
    public  boolean updateGenre(@PathVariable String genre,@PathVariable int id){
        seriesService.updateSerieGenre(id, genre);
        return  true;

    }

    @PutMapping("/modifyEpisodesNumber/{id}/{episodesNumber}")
    public  boolean updateEpisodesNumber(@PathVariable int episodesNumber,@PathVariable int id){
        seriesService.updateSerieEpisodesNumber(id,episodesNumber);
        return  true;

    }

    @PutMapping("/modifyRating/{id}/{rating}")
    public  boolean updateSeriesRating(@PathVariable double rating,@PathVariable int id){

        seriesService.updateSerieRating(id,rating);

        return  true;

    }




}
