package com.example.labo1.Repositories;


import com.example.labo1.Model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "person", path = "oui")
public interface RepositoryPerson extends JpaRepository<Person, Integer> {
    Person getAllByName(String name);
    Person getPersonById(int id);
    Person getPersonByEmail(String email);

}
