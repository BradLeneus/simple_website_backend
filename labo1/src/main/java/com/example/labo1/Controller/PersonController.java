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
    public List<Person> filterPersonByName(@PathVariable String name){


        return personService.filterByName(name);
    }
}
