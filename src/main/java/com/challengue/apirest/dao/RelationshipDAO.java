package com.challengue.apirest.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.challengue.apirest.entity.Person;
import com.challengue.apirest.entity.Relationship;
import com.challengue.apirest.entity.RelationshipPK;

@Repository
public interface RelationshipDAO extends JpaRepository<Relationship, RelationshipPK>{

	public List<Relationship> findByRelationshipPKPerson1AndRelationshipPKPerson2(Person p1, Person p2);
}
