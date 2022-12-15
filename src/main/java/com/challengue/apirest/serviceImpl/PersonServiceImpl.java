package com.challengue.apirest.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challengue.apirest.dao.PersonDAO;
import com.challengue.apirest.entity.Person;
import com.challengue.apirest.service.PersonService;



@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonDAO personDAO;

    @Override
    public List<Person> findAll() {
        List<Person> listPersons= personDAO.findAll();
        return listPersons;
    }

    @Override
    public List<Person> findByNameLastname(String name, String lastname) {
        List<Person> persons = personDAO.findByNameAndLastname(name, lastname);
        return persons;
    }
    
    @Override
    public Person findById(Integer id) {
        return personDAO.findById(id).orElse(null);
    }

    @Override
    public void save(Person person) {
    	personDAO.save(person);

    }

	@Override
	public boolean exists(Person person) {	
		return personDAO.findByDniAndDniTypeAndCountry(person.getDni(), person.getDniType(), person.getCountry()) != null;
	}
	
}
