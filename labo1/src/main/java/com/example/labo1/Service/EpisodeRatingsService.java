package com.example.labo1.Service;

import com.example.labo1.Model.Episode;
import com.example.labo1.Model.EpisodesRatings;
import com.example.labo1.Model.Person;
import com.example.labo1.Repositories.RepositoryEpisodesRatings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EpisodeRatingsService {

    private final RepositoryEpisodesRatings repositoryEpisodesRatings;


    @Autowired
    EpisodeService episodeService;

    @Autowired
    PersonService personService;


    public EpisodeRatingsService(RepositoryEpisodesRatings repositoryEpisodesRatings) {
        this.repositoryEpisodesRatings = repositoryEpisodesRatings;
    }

    public boolean rateEpisodes(int personId, int episodeId , double rating){
        EpisodesRatings episodesRatings = repositoryEpisodesRatings.findByPerson_IdAndEpisode_Id(personId,episodeId);

        if(episodesRatings != null){
            episodesRatings.setRating(rating);
            repositoryEpisodesRatings.save(episodesRatings);
        }
        else {

            Person person = personService.getByid(personId);
            Episode episode = episodeService.getById(episodeId);

            EpisodesRatings newRating = new EpisodesRatings();
            newRating.setEpisode(episode);
            newRating.setPerson(person);
            newRating.setRating(rating);

            repositoryEpisodesRatings.save(newRating);
        }
        return true;
    }


    public double getAverageRating( int episodeId){
        Double avg = repositoryEpisodesRatings.avgForEpisodes(episodeId);
        if (avg==null){
            return 0.0;
        }
        else  {
            return avg;
        }
    }


}
