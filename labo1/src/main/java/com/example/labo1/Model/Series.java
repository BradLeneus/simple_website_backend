package com.example.labo1.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Series {
    @Id
   @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private  String title;
    private  String genre;
    private  int episodesNumber;
    private  double rating;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getEpisodesNumber() {
        return episodesNumber;
    }

    public void setEpisodesNumber(int episodesNumber) {
        this.episodesNumber = episodesNumber;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id:=" + id +
                ", title:='" +title + '\'' +
                ", genre:='" + genre + '\'' +
                ", Number of episodes :='" + episodesNumber + '\'' +
                ", Rating: ='" + rating + '\'' +
                '}';
    }

}
