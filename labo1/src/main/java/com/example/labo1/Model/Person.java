package com.example.labo1.Model;

import io.swagger.v3.oas.annotations.info.Contact;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

/**
 * Représente un utilisateur du système.
 * Contient les informations personnelles et d'authentification.
 */
@Setter
@Getter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Person {

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

    /**
     * Mot de passe haché de l'utilisateur.
     */
    private String password;

    /**
     * Retourne une représentation textuelle de l'utilisateur,
     * sans inclure le mot de passe pour des raisons de sécurité.
     *
     * @return chaîne représentant l'utilisateur
     */
    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
