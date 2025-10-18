package com.example.labo1.Service;

import com.example.labo1.Model.History;
import com.example.labo1.Model.Person;
import com.example.labo1.Model.PersonDTO;
import com.example.labo1.Repositories.RepositoryHistory;
import com.example.labo1.Repositories.RepositoryPerson;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service pour gérer les opérations liées aux utilisateurs (Person).
 * Inclut la gestion des données utilisateurs, authentification et mise à jour.
 */
@Service
public class PersonService {

    /**
     * Encodeur de mot de passe BCrypt.
     */
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    /**
     * Repository pour accéder aux entités Person.
     */
    private final RepositoryPerson repositoryPerson;

    /**
     * Repository pour accéder aux historiques des utilisateurs.
     */
    private final RepositoryHistory repositoryHistory;

    /**
     * Constructeur principal pour l'injection des repositories.
     *
     * @param repositoryPerson  Repository pour les utilisateurs.
     * @param repositoryHistory Repository pour l'historique.
     */
    public PersonService(RepositoryPerson repositoryPerson, RepositoryHistory repositoryHistory) {
        this.repositoryPerson = repositoryPerson;
        this.repositoryHistory = repositoryHistory;
    }

    /**
     * Récupère tous les utilisateurs.
     *
     * @return Liste de toutes les entités Person.
     */
    public List<Person> getAllPerson() {
        return repositoryPerson.findAll();
    }

    /**
     * Récupère un utilisateur par son nom.
     *
     * @param name Nom de l'utilisateur.
     * @return La Person correspondante ou null si introuvable.
     */
    public Person getAllByName(String name) {
        return repositoryPerson.getAllByName(name);
    }

    /**
     * Récupère un utilisateur par son identifiant.
     *
     * @param id Identifiant de l'utilisateur.
     * @return La Person correspondante ou null si introuvable.
     */
    public Person getByid(int id) {
        return repositoryPerson.getPersonById(id);
    }

    /**
     * Supprime un utilisateur et son historique.
     *
     * @param id Identifiant de l'utilisateur à supprimer.
     * @return true si la suppression a réussi.
     */
    public boolean deleteById(int id) {
        List<History> list = repositoryHistory.findHistoriesByPerson_Id(id);
        repositoryHistory.deleteAll(list);
        repositoryPerson.deleteById(id);
        return true;
    }

    /**
     * Crée un nouvel utilisateur si l'email n'existe pas déjà.
     * Le mot de passe est automatiquement encodé avec BCrypt.
     *
     * @param p Person à créer.
     * @return true si l'utilisateur a été créé avec succès, false si email déjà utilisé.
     */
    public boolean createPerson(Person p) {
        if (repositoryPerson.getAllByName(p.getEmail()) == null) {
            p.setPassword(passwordEncoder.encode(p.getPassword()));
            repositoryPerson.save(p);
            return true;
        }
        return false;
    }

    /**
     * Authentifie un utilisateur par email et mot de passe.
     *
     * @param email    Email de l'utilisateur.
     * @param password Mot de passe en clair.
     * @return Un PersonDTO si les informations sont correctes, null sinon.
     */
    public PersonDTO findCustomerByNameAndPassword(String email, String password) {
        Person c = repositoryPerson.getPersonByEmail(email);

        if (passwordEncoder.matches(password, c.getPassword())) {
            PersonDTO personDTO = new PersonDTO();
            personDTO.setEmail(c.getEmail());
            personDTO.setId(c.getId());
            personDTO.setGender(c.getGender());
            personDTO.setName(c.getName());
            return personDTO;
        }
        return null;
    }

    /**
     * Met à jour le nom d'un utilisateur.
     *
     * @param id   Identifiant de l'utilisateur.
     * @param name Nouveau nom.
     * @return true si la mise à jour a réussi.
     */
    public boolean updatePersonName(int id, String name) {
        Person findP = repositoryPerson.getPersonById(id);
        findP.setName(name);
        repositoryPerson.save(findP);
        return true;
    }

    /**
     * Met à jour le prénom d'un utilisateur.
     *
     * @param id       Identifiant de l'utilisateur.
     * @param lastName Nouveau prénom.
     * @return true si la mise à jour a réussi.
     */
    public boolean updatePersonLastName(int id, String lastName) {
        Person findP = repositoryPerson.getPersonById(id);
        findP.setLastName(lastName);
        repositoryPerson.save(findP);
        return true;
    }

    /**
     * Met à jour l'email d'un utilisateur.
     *
     * @param id    Identifiant de l'utilisateur.
     * @param email Nouvel email.
     * @return true si la mise à jour a réussi.
     */
    public boolean updatePersonEmail(int id, String email) {
        Person findP = repositoryPerson.getPersonById(id);
        findP.setEmail(email);
        repositoryPerson.save(findP);
        return true;
    }

    /**
     * Met à jour le genre d'un utilisateur.
     *
     * @param id     Identifiant de l'utilisateur.
     * @param gender Nouveau genre.
     * @return true si la mise à jour a réussi.
     */
    public boolean updatePersonGender(int id, String gender) {
        Person findP = repositoryPerson.getPersonById(id);
        findP.setGender(gender);
        repositoryPerson.save(findP);
        return true;
    }
}
