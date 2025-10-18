package com.example.labo1.Service;

import com.example.labo1.Model.Series;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class RecommendationSerieService {

    @Autowired
    private HistoryService historyService;
    @Autowired
    private SeriesService seriesService;

    public  List<String> getMostViewGender(){
        Dictionary<String, Integer> dict = new Hashtable<>();
        List<Series> WatchedSerie = historyService.findAllWatchedSerie();
        for(Series serie:WatchedSerie){
            if(dict.get(serie.getGenre())==null){
                dict.put(serie.getGenre(),1);
                System.out.println(serie.getGenre());
            }
            else {
                dict.put(serie.getGenre(),dict.get(serie.getGenre())+1);
            }



        }
        System.out.println(dict);
        //  prend un dictionnaire et retourne les 3 keys associes aux 3 valeurs les plus grosses(int)
        List<String> keys = ((Hashtable<String, Integer>) dict).entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).limit(3).map(Map.Entry::getKey).collect(Collectors.toList());
        return keys;
    }
    public  List<String> getMostViewGenderByTheUser(int userId){
        Dictionary<String, Integer> dict = new Hashtable<>();
        List<Series> WatchedSerie = historyService.findSerieByUserId(userId);
        for(Series serie:WatchedSerie){
            if(dict.get(serie.getGenre())==null){
                dict.put(serie.getGenre(),1);
            }
            else {
                dict.put(serie.getGenre(),dict.get(serie.getGenre())+1);
            }



        }
        //  prend un dictionnaire et retourne les 3 keys associes aux 3 valeurs les plus grosses(int)
        List<String> keys = ((Hashtable<String, Integer>) dict).entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).limit(3).map(Map.Entry::getKey).collect(Collectors.toList());
        return keys;
    }
    public List<Series> recommendNonWatchedSerie(int userId, boolean fromALluser){
        List<String> genres;
        if(fromALluser){
            genres = getMostViewGender();
        }
        else {
            genres = getMostViewGenderByTheUser(userId);
        }
        List<Series> serieToRecommend = new ArrayList<>();
        List<Series> watchedSerie = historyService.findSerieByUserId(userId);
        List<Series> genre1 = seriesService.getAllByGenre(genres.get(0));
        List<Series> genre2 = seriesService.getAllByGenre(genres.get(1));
        List<Series> genre3 = seriesService.getAllByGenre(genres.get(2));
        int i = 0;
        for(Series serie: genre1){

            if(!watchedSerie.contains(serie)){
                serieToRecommend.add(serie);
                i ++;
                if (i==3){
                    break;
                }
            }
        }
        i = 0;
        for(Series serie: genre2){

            if(!watchedSerie.contains(serie)){
                serieToRecommend.add(serie);
                i ++;
                if (i==3){
                    break;
                }
            }
        }
        i = 0;
        for(Series serie: genre3){

            if(!watchedSerie.contains(serie)){
                serieToRecommend.add(serie);
                i ++;
                if (i==3){
                    break;
                }
            }
        }
        return serieToRecommend;
    }
    public List<Series> tendance(){
        List<String> genres;

        genres = getMostViewGender();


        List<Series> serieToRecommend = new ArrayList<>();

        List<Series> genre1 = seriesService.getAllByGenre(genres.get(0));
        List<Series> genre2 = seriesService.getAllByGenre(genres.get(1));
        List<Series> genre3 = seriesService.getAllByGenre(genres.get(2));
        int i = 0;
        for(Series serie: genre1){


            serieToRecommend.add(serie);
            i ++;
            if (i==3){
                break;
            }

        }
        i = 0;
        for(Series serie: genre2){


            serieToRecommend.add(serie);
            i ++;
            if (i==3){
                break;
            }
        }

        i = 0;
        for(Series serie: genre3){


            serieToRecommend.add(serie);
            i ++;
            if (i==3){
                break;
            }
        }

        return serieToRecommend;
    }
}
