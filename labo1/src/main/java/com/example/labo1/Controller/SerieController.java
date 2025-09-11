package com.example.labo1.Controller;

import com.example.labo1.Model.Serie;
import com.example.labo1.Service.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/serie")
public class SerieController {

    @Autowired
    SerieService serieService;


    @GetMapping("/search/{name}")
    public List<Serie> filterPersonByName(@PathVariable String name){


        return serieService.filterByTitre(name);
    }

    @GetMapping("/getAll")
    public List<Serie> getAllSerie(){


        return serieService.listSerie;
    }

    @GetMapping("/getById/{id}")
    public Serie getSerieById(@PathVariable int id){


        return serieService.filterById(id);
    }

    @DeleteMapping("/deleteById/{id}")
    public boolean deleteById(@PathVariable int id){


        return serieService.deleteById(id);
    }



}
