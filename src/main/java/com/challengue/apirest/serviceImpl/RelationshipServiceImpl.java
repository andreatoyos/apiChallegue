package com.challengue.apirest.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challengue.apirest.dao.RelationshipDAO;
import com.challengue.apirest.entity.Person;
import com.challengue.apirest.entity.Relationship;
import com.challengue.apirest.service.RelationshipService;



@Service
public class RelationshipServiceImpl implements RelationshipService {

    @Autowired
    private RelationshipDAO relationshipDAO;

    @Override
    public List<Relationship> findAll() {
        List<Relationship> listRelationship= relationshipDAO.findAll();
        return listRelationship;
    }


    @Override
    public void save(Relationship relationship) {
    	relationshipDAO.save(relationship);

    }


	@Override
	public List<Relationship> findByPerson1AndPerson2(Person p1, Person p2) {
		return relationshipDAO.findByRelationshipPKPerson1AndRelationshipPKPerson2(p1, p2);
	}

	
}
