package com.example.labo1.Repositories;

import com.example.labo1.Model.SeriesRatings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RepositoryRating extends JpaRepository<SeriesRatings, Integer> {

    SeriesRatings findByPerson_IdAndSeries_Id(int  personId, int seriesId);



    @Query("select avg(r.rating) from SeriesRatings r where r.series.id = :seriesId")
    Double avgForSeries(@Param("seriesId") int seriesId);



}
