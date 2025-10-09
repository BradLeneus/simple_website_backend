package com.example.labo1.Repositories;

import com.example.labo1.Model.Episode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

public interface RepositoryEpisode extends JpaRepository<Episode, Integer> {

    List<Episode> findBySeries_Id(int seriesId);


}
