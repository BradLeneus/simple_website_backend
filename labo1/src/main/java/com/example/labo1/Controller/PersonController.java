package com.example.labo1.Controller;

import com.example.labo1.Model.Person;
import com.example.labo1.Model.PersonDTO;
import com.example.labo1.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Contrôleur pour gérer les opérations liées aux utilisateurs (Person).
 * Permet de créer, modifier, supprimer, récupérer et filtrer des utilisateurs.
 */
@RestController
@CrossOrigin()
@RequestMapping("/person")
public class PersonController {

    /**
     * Service pour gérer la logique métier des utilisateurs.
     */
    @Autowired
    @Qualifier("personService")
    PersonService personService;

    /**
     * Recherche un utilisateur par son nom.
     *
     * @param name Le nom de l'utilisateur à rechercher.
     * @return L'objet Person correspondant au nom fourni.
     */
    @GetMapping("/search/{name}")
    public Person filterPersonByName(@PathVariable String name){
        return personService.getAllByName(name);
    }

    /**
     * Récupère tous les utilisateurs.
     *
     * @return Liste de tous les utilisateurs.
     */
    @GetMapping("/getAll")
    public List<Person> getAllPerson(){
        return personService.getAllPerson();
    }

    /**
     * Récupère un utilisateur par son identifiant.
     *
     * @param id L'identifiant de l'utilisateur.
     * @return L'objet Person correspondant à l'identifiant.
     */
    @GetMapping("/getById/{id}")
    public Person getPersonById(@PathVariable int id){
        return personService.getByid(id);
    }

    /**
     * Supprime un utilisateur par son identifiant.
     *
     * @param id L'identifiant de l'utilisateur à supprimer.
     * @return true si la suppression a réussi, false sinon.
     */
    @DeleteMapping("/deleteById/{id}")
    public boolean deleteById(@PathVariable int id){
        return personService.deleteById(id);
    }

    /**
     * Crée un nouvel utilisateur.
     *
     * @param p L'objet Person à créer.
     * @return true si la création a réussi, false sinon.
     */
    @PostMapping("/signUp")
    public boolean createPerson(@RequestBody Person p){
        return personService.createPerson(p);
    }

    /**
     * Authentifie un utilisateur avec son email et son mot de passe.
     *
     * @param email    L'email de l'utilisateur.
     * @param password Le mot de passe de l'utilisateur.
     * @return Un objet PersonDTO si l'authentification est réussie.
     */
    @GetMapping("/login/{email}/{password}")
    public PersonDTO login(@PathVariable String email, @PathVariable String password){
        return personService.findCustomerByNameAndPassword(email,password);
    }

    /**
     * Met à jour le prénom d'un utilisateur.
     *
     * @param name Le nouveau prénom.
     * @param id   L'identifiant de l'utilisateur.
     * @return true si la mise à jour a réussi.
     */
    @PutMapping("/modifyName/{id}/{name}")
    public boolean updateName(@PathVariable String name, @PathVariable int id) {
        personService.updatePersonName(id, name);
        return true;
    }

    /**
     * Met à jour le nom de famille d'un utilisateur.
     *
     * @param lastname Le nouveau nom de famille.
     * @param id       L'identifiant de l'utilisateur.
     * @return true si la mise à jour a réussi.
     */
    @PutMapping("/modifyLastName/{id}/{lastname}")
    public boolean updateLastName(@PathVariable String lastname, @PathVariable int id) {
        personService.updatePersonLastName(id, lastname);
        return true;
    }

    /**
     * Met à jour le genre d'un utilisateur.
     *
     * @param gender Le nouveau genre.
     * @param id     L'identifiant de l'utilisateur.
     * @return true si la mise à jour a réussi.
     */
    @PutMapping("/modifyGender/{id}/{gender}")
    public boolean updateGender(@PathVariable String gender, @PathVariable int id) {
        personService.updatePersonGender(id, gender);
        return true;
    }

    /**
     * Met à jour l'email d'un utilisateur.
     *
     * @param email Le nouvel email.
     * @param id    L'identifiant de l'utilisateur.
     * @return true si la mise à jour a réussi.
     */
    @PutMapping("/modifyEmail/{id}/{email}")
    public boolean updateEmail(@PathVariable String email, @PathVariable int id) {
        personService.updatePersonEmail(id, email);
        return true;
    }
}
