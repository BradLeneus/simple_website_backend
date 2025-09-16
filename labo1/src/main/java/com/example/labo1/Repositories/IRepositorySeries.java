package com.example.labo1.Repositories;

import com.example.labo1.Model.Series;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "series", path = "oui")
public interface IRepositorySeries  extends JpaRepository<Series,Integer> {
    List<Series> getAllByGenre(String genre);

    Series getSerieById(int id);

    Series getAllByTitle(String title);

    Series getAllByEpisodesNumberGreaterThanEqual(int episodes);
}
