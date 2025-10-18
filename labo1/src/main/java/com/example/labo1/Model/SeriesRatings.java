package com.example.labo1.Model;

import jakarta.persistence.*;

/**
 * Représente une évaluation (rating) d'une série par un utilisateur (Person).
 * Contient la note attribuée ainsi que les références à l'utilisateur et à la série.
 */
@Entity
public class SeriesRatings {

    /**
     * Identifiant unique de l'évaluation.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * Note attribuée à la série par l'utilisateur.
     */
    private double rating;

    /**
     * Utilisateur ayant donné cette note.
     */
    @ManyToOne
    private Person person;

    /**
     * Série évaluée.
     */
    @ManyToOne
    private Series series;

    // --- Getters et Setters ---

    /**
     * Récupère l'identifiant de l'évaluation.
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Définit l'identifiant de l'évaluation.
     * @param id identifiant
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Récupère la note attribuée.
     * @return note
     */
    public double getRating() {
        return rating;
    }

    /**
     * Définit la note attribuée.
     * @param rating note
     */
    public void setRating(double rating) {
        this.rating = rating;
    }

    /**
     * Récupère l'utilisateur ayant fait l'évaluation.
     * @return utilisateur
     */
    public Person getPerson() {
        return person;
    }

    /**
     * Définit l'utilisateur ayant fait l'évaluation.
     * @param person utilisateur
     */
    public void setPerson(Person person) {
        this.person = person;
    }

    /**
     * Récupère la série évaluée.
     * @return série
     */
    public Series getSeries() {
        return series;
    }

    /**
     * Définit la série évaluée.
     * @param series série
     */
    public void setSeries(Series series) {
        this.series = series;
    }
}
