package com.example.labo1.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Data Transfer Object pour la classe Person.
 * Sert à exposer uniquement certaines informations d'un utilisateur
 * sans inclure le mot de passe ou d'autres informations sensibles.
 */
@Entity
public class PersonDTO {

    /**
     * Identifiant unique de l'utilisateur.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * Prénom de l'utilisateur.
     */
    private String name;

    /**
     * Nom de famille de l'utilisateur.
     */
    private String lastName;

    /**
     * Adresse email de l'utilisateur.
     */
    private String email;

    /**
     * Genre de l'utilisateur.
     */
    private String gender;

    // --- Getters et Setters ---

    /**
     * Récupère le prénom de l'utilisateur.
     * @return prénom
     */
    public String getName() {
        return name;
    }

    /**
     * Définit le prénom de l'utilisateur.
     * @param name prénom
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Récupère l'identifiant de l'utilisateur.
     * @return identifiant
     */
    public int getId() {
        return id;
    }

    /**
     * Définit l'identifiant de l'utilisateur.
     * @param id identifiant
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Récupère le nom de famille de l'utilisateur.
     * @return nom de famille
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Définit le nom de famille de l'utilisateur.
     * @param lastName nom de famille
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Récupère l'adresse email de l'utilisateur.
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Définit l'adresse email de l'utilisateur.
     * @param email email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Récupère le genre de l'utilisateur.
     * @return genre
     */
    public String getGender() {
        return gender;
    }

    /**
     * Définit le genre de l'utilisateur.
     * @param gender genre
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Retourne une représentation textuelle de l'utilisateur.
     * @return chaîne représentant l'utilisateur
     */
    @Override
    public String toString() {
        return "PersonDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
