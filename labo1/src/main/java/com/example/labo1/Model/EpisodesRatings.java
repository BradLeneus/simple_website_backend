package com.example.labo1.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

/**
 * Représente la note attribuée par un utilisateur à un épisode.
 */
@Entity
public class EpisodesRatings {

    /**
     * Identifiant unique de la note.
     */
    @Id
    private int id;

    /**
     * Valeur de la note attribuée à l'épisode.
     */
    private double rating;

    /**
     * Utilisateur ayant attribué la note.
     */
    @ManyToOne
    private Person person;

    /**
     * Épisode qui a été noté.
     */
    @ManyToOne
    private Episode episode;

    /**
     * Retourne l'identifiant de la note.
     *
     * @return l'id de la note
     */
    public int getId() {
        return id;
    }

    /**
     * Définit l'identifiant de la note.
     *
     * @param id l'identifiant à définir
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retourne la valeur de la note.
     *
     * @return la note attribuée
     */
    public double getRating() {
        return rating;
    }

    /**
     * Définit la valeur de la note.
     *
     * @param rating la note à définir
     */
    public void setRating(double rating) {
        this.rating = rating;
    }

    /**
     * Retourne l'utilisateur ayant attribué la note.
     *
     * @return l'utilisateur
     */
    public Person getPerson() {
        return person;
    }

    /**
     * Définit l'utilisateur ayant attribué la note.
     *
     * @param person l'utilisateur à définir
     */
    public void setPerson(Person person) {
        this.person = person;
    }

    /**
     * Retourne l'épisode noté.
     *
     * @return l'épisode
     */
    public Episode getEpisode() {
        return episode;
    }

    /**
     * Définit l'épisode noté.
     *
     * @param episode l'épisode à définir
     */
    public void setEpisode(Episode episode) {
        this.episode = episode;
    }
}
