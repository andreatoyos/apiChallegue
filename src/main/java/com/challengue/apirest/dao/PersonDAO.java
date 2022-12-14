package com.challengue.apirest.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.challengue.apirest.entity.Person;

@Repository
public interface PersonDAO extends JpaRepository<Person, Integer>{
	public List<Person> findByNameAndLastname(String name, String lastname);
	
	public Person findByDniAndDniTypeAndCountry(Integer dni, String dniType, String country);

}
