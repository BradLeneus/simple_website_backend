package com.example.labo1.Controller;


import com.example.labo1.Model.Person;
import com.example.labo1.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@CrossOrigin()
@RequestMapping("/person")
public class PersonController {

    @Autowired
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
    @PostMapping("/newPerson")
    public boolean createPerson(@RequestBody Person p){


        return personService.createPerson(p);
    }




}
