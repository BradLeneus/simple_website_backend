package com.example.labo1.Service;


import com.example.labo1.Model.Ratings;
import com.example.labo1.Repositories.RepositoryRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingsService {


    private final RepositoryRating repositoryRating;

    @Autowired
     SeriesService seriesService;

    @Autowired
    PersonService personService;


    public RatingsService(RepositoryRating repositoryRating) {
        this.repositoryRating = repositoryRating;
    }


    public boolean rateSeries( int personId,  int seriesId , double rating){
        Ratings ratings = repositoryRating.findByPerson_IdAndSeries_Id(personId,seriesId);
        if (ratings==null){
            ratings = new Ratings();
            ratings.setPerson(personService.getByid(personId));
            ratings.setSeries(seriesService.getByid(seriesId));
        }
        ratings.setRating(rating);
        repositoryRating.save(ratings);
        return true;
    }

    public double getAverageRating( int seriesId){
        Double avg = repositoryRating.avgForSeries(seriesId);
        if (avg==null){
            seriesService.getByid(seriesId);
            seriesService.updateSerieRating(seriesId,avg);
            return 0.0;
        }
        else  {
            return avg;
        }
    }



}
