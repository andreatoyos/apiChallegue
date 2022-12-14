package com.challengue.apirest.service;

import java.util.List;

import com.challengue.apirest.entity.Person;


public interface PersonService {

    public List<Person> findAll();
    
    public List<Person> findByNameLastname(String name, String lastname);

    public void save(Person user);
    
    public boolean exists(Person person);
}