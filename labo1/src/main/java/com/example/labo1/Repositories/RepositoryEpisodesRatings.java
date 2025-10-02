package com.example.labo1.Repositories;

import com.example.labo1.Model.EpisodesRatings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RepositoryEpisodesRatings extends JpaRepository<EpisodesRatings, Integer> {

    EpisodesRatings findByPerson_IdAndEpisode_Id(int personId, int episodeId);


    @Query("select avg(r.rating) from EpisodesRatings r where r.episode.id = :episodeId")
    Double avgForEpisodes(@Param("episodeId") int episodeId);
}
