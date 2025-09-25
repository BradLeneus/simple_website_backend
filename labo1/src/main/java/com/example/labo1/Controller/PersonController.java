package com.example.labo1.Controller;


import com.example.labo1.Model.Person;
import com.example.labo1.Model.PersonDTO;
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
    public Person filterPersonByName(@PathVariable String name){


        return personService.getAllByName(name);
    }


    @GetMapping("/getAll")
    public List<Person> getAllPerson(){


        return personService.getAllPerson();
    }

    @GetMapping("/getById/{id}")
    public Person getPersonById(@PathVariable int id){


        return personService.getByid(id);
    }


    @DeleteMapping("/deleteById/{id}")
    public boolean deleteById(@PathVariable int id){


        return personService.deleteById(id);
    }
    @PostMapping("/signUp")
    public boolean createPerson(@RequestBody Person p){


        return personService.createPerson(p);
    }
    @GetMapping("/login/{email}/{password}")
    public PersonDTO login(@PathVariable String email, @PathVariable String password){


        return personService.findCustomerByNameAndPassword(email,password);
    }


    @PutMapping("/modifyName/{id}/{name}")
    public boolean updateName(@PathVariable String name, @PathVariable int id) {

        personService.updatePersonName(id, name);
        return true;
    }
    @PutMapping("/modifyLastName/{id}/{lastname}")
    public boolean updateLastName(@PathVariable String lastname, @PathVariable int id) {

        personService.updatePersonLastName(id, lastname);
        return true;
    }
    @PutMapping("/modifyGender/{id}/{gender}")
    public boolean updateGender(@PathVariable String gender, @PathVariable int id) {

        personService.updatePersonGender(id, gender);
        return true;
    }
    @PutMapping("/modifyEmail/{id}/{email}")
    public boolean updateEmail(@PathVariable String email, @PathVariable int id) {

        personService.updatePersonEmail(id, email);
        return true;
    }



}
