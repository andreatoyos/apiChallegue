package com.challengue.apirest.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="relationships")
public class Relationship {
	
	@EmbeddedId
	RelationshipPK relationshipPK;
	
	
	public Relationship(RelationshipPK relationshipPK) {
		this.relationshipPK = relationshipPK;
	}

	public Relationship() {}

	public RelationshipPK getRelationshipPK() {
		return relationshipPK;
	}

	public void setRelationshipPK(RelationshipPK relationshipPK) {
		this.relationshipPK = relationshipPK;
	}
	
	

}
