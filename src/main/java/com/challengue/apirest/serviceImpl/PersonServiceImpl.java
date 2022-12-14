package com.challengue.apirest.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challengue.apirest.dao.PersonDAO;
import com.challengue.apirest.entity.Person;
import com.challengue.apirest.service.PersonService;



@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonDAO PersonDAO;

    @Override
    public List<Person> findAll() {
        List<Person> listPersons= PersonDAO.findAll();
        return listPersons;
    }

    @Override
    public List<Person> findByNameLastname(String name, String lastname) {
        List<Person> persons = PersonDAO.findByNameAndLastname(name, lastname);
        return persons;
    }

    @Override
    public void save(Person person) {
        PersonDAO.save(person);

    }

	@Override
	public boolean exists(Person person) {	
		return PersonDAO.findByDniAndDniTypeAndCountry(person.getDni(), person.getDniType(), person.getCountry()) != null;
	}
}
