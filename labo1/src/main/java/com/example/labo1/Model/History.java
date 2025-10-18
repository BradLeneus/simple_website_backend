package com.example.labo1.Model;

import jakarta.persistence.*;

/**
 * Représente l'historique de visionnage d'un utilisateur pour une série.
 */
@Entity
public class History {

    /**
     * Identifiant unique de l'entrée dans l'historique.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * Utilisateur qui a regardé la série.
     */
    @ManyToOne
    private Person person;

    /**
     * Série regardée par l'utilisateur.
     */
    @ManyToOne
    private Series series;

    /**
     * Retourne l'identifiant de l'entrée d'historique.
     *
     * @return l'id de l'historique
     */
    public int getId() {
        return id;
    }

    /**
     * Définit l'identifiant de l'entrée d'historique.
     *
     * @param id l'identifiant à définir
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retourne l'utilisateur associé à cet historique.
     *
     * @return l'utilisateur
     */
    public Person getPerson() {
        return person;
    }

    /**
     * Définit l'utilisateur associé à cet historique.
     *
     * @param person l'utilisateur à définir
     */
    public void setPerson(Person person) {
        this.person = person;
    }

    /**
     * Retourne la série associée à cet historique.
     *
     * @return la série regardée
     */
    public Series getSeries() {
        return series;
    }

    /**
     * Définit la série associée à cet historique.
     *
     * @param series la série à définir
     */
    public void setSeries(Series series) {
        this.series = series;
    }
}
