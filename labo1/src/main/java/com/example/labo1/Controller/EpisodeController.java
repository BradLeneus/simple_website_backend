package com.example.labo1.Controller;


import com.example.labo1.Model.Episode;
import com.example.labo1.Service.EpisodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/episodes")
public class EpisodeController {


    @Autowired
    EpisodeService episodeService;

    @GetMapping("/Id/{id}")
    public Episode getEpisode(@PathVariable int id) {
        return episodeService.getById(id);
    }

    @GetMapping("/search/{title}")
    public List<Episode> searchByTitle(@PathVariable String title) {
        return episodeService.getAllByTitle(title);
    }

    @PostMapping("/newEpisode")
    public boolean createEpisode(@RequestBody Episode episode) {
        return episodeService.createEpisode(episode);
    }

    @DeleteMapping("/deletebyId")
    public boolean deleteEpisode(@PathVariable int id) {
        return episodeService.deleteEpisode(id);
    }
}
