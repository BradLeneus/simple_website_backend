package com.example.labo1.Model;

import jakarta.persistence.*;

/**
 * Représente un épisode d'une série.
 */
@Entity
public class Episode {

    /**
     * Identifiant unique de l'épisode.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * Titre de l'épisode.
     */
    private String title;

    /**
     * Numéro de l'épisode dans la série.
     */
    private int episodeNumber;

    /**
     * Série à laquelle l'épisode appartient.
     */
    @ManyToOne
    private Series series;

    /**
     * Retourne l'identifiant de l'épisode.
     *
     * @return l'id de l'épisode
     */
    public int getId() {
        return id;
    }

    /**
     * Définit l'identifiant de l'épisode.
     *
     * @param id l'identifiant à définir
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retourne le titre de l'épisode.
     *
     * @return le titre de l'épisode
     */
    public String getTitle() {
        return title;
    }

    /**
     * Définit le titre de l'épisode.
     *
     * @param title le titre à définir
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Retourne le numéro de l'épisode dans la série.
     *
     * @return le numéro de l'épisode
     */
    public int getEpisodeNumber() {
        return episodeNumber;
    }

    /**
     * Définit le numéro de l'épisode dans la série.
     *
     * @param episodeNumber le numéro à définir
     */
    public void setEpisodeNumber(int episodeNumber) {
        this.episodeNumber = episodeNumber;
    }

    /**
     * Retourne la série à laquelle appartient l'épisode.
     *
     * @return la série
     */
    public Series getSeries() {
        return series;
    }

    /**
     * Définit la série à laquelle appartient l'épisode.
     *
     * @param series la série à définir
     */
    public void setSeries(Series series) {
        this.series = series;
    }
}
