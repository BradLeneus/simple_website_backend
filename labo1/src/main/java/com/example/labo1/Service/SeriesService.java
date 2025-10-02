package com.example.labo1.Service;


import com.example.labo1.Model.Person;
import com.example.labo1.Model.Series;
import com.example.labo1.Repositories.IRepositorySeries;
import com.example.labo1.Repositories.RepositoryPerson;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeriesService {

    private  final IRepositorySeries repositorySeries;

    public SeriesService(IRepositorySeries repositorySeries){
        this.repositorySeries = repositorySeries;
    }




    public List<Series> getAllSeries(){
        return repositorySeries.findAll();
    }


    public List<Series> getAllByGenre(String genre){
        return repositorySeries.getAllByGenre(genre);

    }
    public Series getByid(int id){
        return repositorySeries.getSerieById(id);
    }






    public boolean deleteById(int id){

        repositorySeries.deleteById(id);
        return true;
    }
    public boolean createSerie(Series s){
        if(repositorySeries.getAllByTitle(s.getTitle()) == null){
            repositorySeries.save(s);
            return true;
        }
        return false;
    }


   /* public List<Series> search(String genre) {
        if (genre == null || genre.isEmpty()) {
            return repositorySeries.findAll();
        } else {
            return repositorySeries.getAllByGenre(genre);
        }
    }*/


    public  boolean updateSerieTitle(int id,String title){
        Series findS = repositorySeries.getSerieById(id);
        findS.setTitle(title);
        repositorySeries.save(findS);
        return  true;
    }

    public  boolean updateSerieGenre(int id,String genre){
        Series findS = repositorySeries.getSerieById(id);
        findS.setGenre(genre);
        repositorySeries.save(findS);
        return  true;
    }

    public  boolean updateSerieEpisodesNumber(int id,int episodesNumber){
        Series findS = repositorySeries.getSerieById(id);
        findS.setEpisodesNumber(episodesNumber);
        repositorySeries.save(findS);
        return  true;
    }

    public  boolean updateSerieRating(int id,double rating){
        Series findS = repositorySeries.getSerieById(id);
        findS.setRating(rating);
        repositorySeries.save(findS);
        return  true;
    }



}
