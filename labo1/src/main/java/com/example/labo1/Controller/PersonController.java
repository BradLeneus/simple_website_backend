package com.example.labo1.Controller;


import com.example.labo1.Model.Person;
import com.example.labo1.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@CrossOrigin()
@RequestMapping("/person")
public class PersonController {

    @Autowired
    @Qualifier("personService")
    PersonService personService;


    @GetMapping("/search/{name}")
    public List<Person> filterPersonByName(@PathVariable String name){


        return personService.filterByName(name);
    }


    @GetMapping("/getAll")
    public List<Person> getAllPerson(){


        return personService.listPerson;
    }

    @GetMapping("/getById/{id}")
    public Person getPersonById(@PathVariable int id){


        return personService.filterById(id);
    }


    @DeleteMapping("/deleteById/{id}")
    public boolean deleteById(@PathVariable int id){


        return personService.deleteById(id);
    }

    @PostMapping("/newPerson/{name}/{lastname}/{email}/{gender}")
    // le @RequestBody regle le bug des données
    public boolean createCustomer(@PathVariable String name, @PathVariable String lastname, @PathVariable String email, @PathVariable String gender){
        Person tempoPerson = new Person();
        tempoPerson.setId(personService.getTheBiggestIdPlus1());
        tempoPerson.setName(name);
        tempoPerson.setLastName(lastname);
        tempoPerson.setEmail(email);
        tempoPerson.setGender(gender);
        personService.createOnePerson(tempoPerson);
        return true;
    }
}
