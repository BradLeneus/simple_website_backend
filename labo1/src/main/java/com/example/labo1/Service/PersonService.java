package com.example.labo1.Service;

import com.example.labo1.Model.History;
import com.example.labo1.Model.Person;
import com.example.labo1.Model.PersonDTO;
import com.example.labo1.Repositories.RepositoryHistory;
import com.example.labo1.Repositories.RepositoryPerson;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


@Service
public class PersonService {

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    private final RepositoryPerson repositoryPerson;

    private final RepositoryHistory repositoryHistory;

    public PersonService(RepositoryPerson repositoryPerson, RepositoryHistory repositoryHistory) {
        this.repositoryPerson = repositoryPerson;
        this.repositoryHistory = repositoryHistory;
    }




    public List<Person> getAllPerson(){
        return repositoryPerson.findAll();
    }


    public Person getAllByName(String name){
        return repositoryPerson.getAllByName(name);

    }
    public Person getByid(int id){
        return repositoryPerson.getPersonById(id);

    }






    public boolean deleteById(int id){
        List<History> list = repositoryHistory.findHistoriesByPerson_Id(id);
        repositoryHistory.deleteAll(list);
        repositoryPerson.deleteById(id);
        return true;
    }
    public boolean createPerson(Person p){
        if(repositoryPerson.getAllByName(p.getEmail()) == null){
            p.setPassword(passwordEncoder.encode(p.getPassword()));
            repositoryPerson.save(p);
            return true;
        }
        return false;
    }


    public PersonDTO findCustomerByNameAndPassword(String email, String password){
        Person c = repositoryPerson.getPersonByEmail(email);


        if (passwordEncoder.matches(password, c.getPassword())){
            PersonDTO personDTO = new PersonDTO();
            personDTO.setEmail(c.getEmail());
            personDTO.setId(c.getId());
            personDTO.setGender(c.getGender());
            personDTO.setName(c.getName());

            return personDTO;
        }



        return null;
    }
    public boolean updatePersonName(int i, String name){
       Person findP =  repositoryPerson.getPersonById(i);
       findP.setName(name);
       repositoryPerson.save(findP);
        return true;
    }

    public boolean updatePersonLastName(int i, String lastName){
        Person findP =  repositoryPerson.getPersonById(i);
        findP.setLastName(lastName);
        repositoryPerson.save(findP);
        return true;
    }

    public boolean updatePersonEmail(int i, String email){
        Person findP =  repositoryPerson.getPersonById(i);
        findP.setEmail(email);
        repositoryPerson.save(findP);
        return true;
    }
    public boolean updatePersonGender(int i, String gender){
        Person findP =  repositoryPerson.getPersonById(i);
        findP.setGender(gender);
        repositoryPerson.save(findP);
        return true;
    }



}

