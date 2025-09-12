package com.example.labo1.Service;

import com.example.labo1.Model.Person;
import com.example.labo1.Repositories.RepositoryPerson;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


@Service
public class PersonService {
    private final RepositoryPerson repositoryPerson;

    public PersonService(RepositoryPerson repositoryPerson){
        this.repositoryPerson = repositoryPerson;
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

        repositoryPerson.deleteById(id);
        return true;
    }
    public boolean createPerson(Person p){
        if(repositoryPerson.getAllByName(p.getName()) == null){
            repositoryPerson.save(p);
            return true;
        }
        return false;
    }



}
