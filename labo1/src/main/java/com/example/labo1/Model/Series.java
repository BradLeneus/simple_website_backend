package com.example.labo1.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Représente une série télévisée.
 * Contient les informations principales comme le titre, le genre, le nombre d'épisodes et la note moyenne.
 */
@Entity
public class Series {

    /**
     * Identifiant unique de la série.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * Titre de la série.
     */
    private String title;

    /**
     * Genre de la série (ex: Drame, Comédie, Action, etc.).
     */
    private String genre;

    /**
     * Nombre total d'épisodes dans la série.
     */
    private int episodesNumber;

    /**
     * Note moyenne de la série.
     */
    private double rating;

    // --- Getters et Setters ---

    /**
     * Récupère l'identifiant de la série.
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Définit l'identifiant de la série.
     * @param id identifiant
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Récupère le titre de la série.
     * @return titre
     */
    public String getTitle() {
        return title;
    }

    /**
     * Définit le titre de la série.
     * @param title titre
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Récupère le genre de la série.
     * @return genre
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Définit le genre de la série.
     * @param genre genre
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * Récupère le nombre total d'épisodes.
     * @return nombre d'épisodes
     */
    public int getEpisodesNumber() {
        return episodesNumber;
    }

    /**
     * Définit le nombre total d'épisodes.
     * @param episodesNumber nombre d'épisodes
     */
    public void setEpisodesNumber(int episodesNumber) {
        this.episodesNumber = episodesNumber;
    }

    /**
     * Récupère la note moyenne de la série.
     * @return note
     */
    public double getRating() {
        return rating;
    }

    /**
     * Définit la note moyenne de la série.
     * @param rating note
     */
    public void setRating(double rating) {
        this.rating = rating;
    }

    /**
     * Retourne une représentation textuelle de la série.
     * @return chaîne représentant la série
     */
    @Override
    public String toString() {
        return "Series{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", episodesNumber=" + episodesNumber +
                ", rating=" + rating +
                '}';
    }
}
