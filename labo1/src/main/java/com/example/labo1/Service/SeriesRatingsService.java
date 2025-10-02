package com.example.labo1.Service;

import com.example.labo1.Model.SeriesRatings;


import com.example.labo1.Repositories.RepositoryRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class SeriesRatingsService {




    private final RepositoryRating repositoryRating;

    @Autowired
     SeriesService seriesService;

    @Autowired
    PersonService personService;


    public SeriesRatingsService(RepositoryRating repositoryRating) {

    public RatingsService(RepositoryRating repositoryRating) {

        this.repositoryRating = repositoryRating;
    }


    public boolean rateSeries( int personId,  int seriesId , double rating){

        SeriesRatings seriesRatings = repositoryRating.findByPerson_IdAndSeries_Id(personId,seriesId);
        if (seriesRatings ==null){
            seriesRatings = new SeriesRatings();
            seriesRatings.setPerson(personService.getByid(personId));
            seriesRatings.setSeries(seriesService.getByid(seriesId));
        }
        seriesRatings.setRating(rating);
        repositoryRating.save(seriesRatings);
        return true;
    }

   public double getAverageRating( int seriesId){

        Double avg = repositoryRating.avgForSeries(seriesId);
        if (avg==null){
            return 0.0;
        }
        else  {
            return avg;
        }
    }



}
