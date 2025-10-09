package com.example.labo1.Repositories;

import com.example.labo1.Model.Episode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepositoryEpisode extends JpaRepository<Episode, Integer> {

    List<Episode> findBySeries_Id(int seriesId);


    List<Episode> findAllByTitle(String title);
}
