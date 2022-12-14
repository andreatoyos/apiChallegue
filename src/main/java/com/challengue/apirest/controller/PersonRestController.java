package com.challengue.apirest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.challengue.apirest.entity.Person;
import com.challengue.apirest.service.PersonService;


@RestController
@RequestMapping("/apiRest")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.PUT,RequestMethod.POST})

public class PersonRestController {

    @Autowired
    private PersonService personService;

    /*http://127.0.0.1:8080/apiRest/persons*/
    @GetMapping("/persons")
    public List<Person> findAll(){
        return personService.findAll();
    }

   /* http://127.0.0.1:8080/apiRest/persons/ */
    @GetMapping("/persons/{name}/{lastname}")
    public List<Person> getPerson(@PathVariable String name, @PathVariable String lastname){
        List<Person> persons = personService.findByNameLastname(name, lastname);
        if(persons.isEmpty()) {
            throw new RuntimeException("No hay personas con el nombre: "+name+" "+lastname);
        }
        return persons;
    }

    /*http://127.0.0.1:8080/apiRest/persons/  */
    @PostMapping("/persons")
    public Person addPerson(@RequestBody Person person) {
    	if (!personService.exists(person))
    		personService.save(person);
    	else
    		throw new RuntimeException("Ya existe una persona con el dni: "+person.getDniType()+" "+person.getDni()+" y pais "+person.getCountry());
        return person;

    }
    /*http://127.0.0.1:8080/apiRest/persons/  */
    @PutMapping("/persons")
    public Person updatePerson(@RequestBody Person person) {
        personService.save(person);
        return person;
    }


}