package com.challengue.apirest.service;

import java.util.List;

import com.challengue.apirest.entity.Person;
import com.challengue.apirest.entity.Relationship;


public interface RelationshipService {

    public List<Relationship> findAll();

    public void save(Relationship relationship);
    
    public List<Relationship> findByPerson1AndPerson2(Person p1, Person p2);
}