package com.challengue.apirest.controller;

import java.util.List;
import java.util.Optional;

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
import com.challengue.apirest.entity.Relationship;
import com.challengue.apirest.entity.RelationshipPK;
import com.challengue.apirest.service.PersonService;
import com.challengue.apirest.service.RelationshipService;


@RestController
@RequestMapping("/apiRest")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.PUT,RequestMethod.POST})

public class PersonRestController {

    @Autowired
    private PersonService personService;
    @Autowired
    private RelationshipService relationshipService;

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
    
    /*http://127.0.0.1:8080/apiRest/persons/:id1/relacion/:id2  */
    @PostMapping("/persons/{id1}/{relation}/{id2}")
    public Relationship addPersonRelationship(@PathVariable Integer id1, @PathVariable String relation, @PathVariable Integer id2) {
    	Relationship relationship = new Relationship(new RelationshipPK(relation, personService.findById(id1), personService.findById(id2)));
    	relationshipService.save(relationship);
    	return relationship;
    }

    /* http://127.0.0.1:8080/apiRest/relationships/ */
    @GetMapping("/relationships/{id1}/{id2}")
    public List<Relationship> getRelationships(@PathVariable Integer id1, @PathVariable Integer id2){
    	List<Relationship> relations = relationshipService.findByPerson1AndPerson2(personService.findById(id1) ,personService.findById(id2));
    	if (relations.isEmpty())
    		throw new RuntimeException("No existe relacion entre personas "+id1+" y "+id2);
    	else
    		return relations;
    }

}