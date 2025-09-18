package com.example.labo1.Repositories;


import com.example.labo1.Model.History;
import com.example.labo1.Model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "person", path = "oui")
public interface RepositoryHistory extends JpaRepository<History, Integer> {
    public List<History> findHistoriesByPerson_Id(int id);

}
