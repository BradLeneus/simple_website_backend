package com.example.labo1.Service;

import com.example.labo1.Model.Episode;
import com.example.labo1.Repositories.RepositoryEpisode;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EpisodeService {


    private final RepositoryEpisode repositoryEpisode;


    public EpisodeService(RepositoryEpisode repositoryEpisode) {
        this.repositoryEpisode = repositoryEpisode;
    }

    public Episode getById(int episodeId){
        return repositoryEpisode.findById(episodeId).orElse(null);
    }


    public List<Episode> getEpisodesBySeries(int seriesId){
        return repositoryEpisode.findBySeries_Id(seriesId);
    }

    public Episode createEpisode (Episode e){
        return repositoryEpisode.save(e);
    }

    public boolean deleteEpisode(int episodeId){
        repositoryEpisode.deleteById(episodeId);
        return true;
    }
}
