package com.challengue.apirest.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class RelationshipPK implements Serializable{

	private static final long serialVersionUID = 1L;

	@Column(name = "relationship", nullable = false)
	private String relationship;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="person1", nullable=false)
	private Person person1;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="person2", nullable=false)
	private Person person2;
	

	public RelationshipPK() {
	}


	public RelationshipPK(String relationship, Person person1, Person person2) {
		this.relationship = relationship;
		this.person1 = person1;
		this.person2 = person2;
	}



	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public Person getPerson1() {
		return person1;
	}

	public void setPerson1(Person person) {
		this.person1 = person;
	}
	
	public Person getPerson2() {
		return person2;
	}

	public void setPerson2(Person person) {
		this.person2 = person;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((person1 == null) ? 0 : person1.hashCode());
		result = prime * result + ((person2 == null) ? 0 : person2.hashCode());
		result = prime * result + ((relationship == null) ? 0 : relationship.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RelationshipPK other = (RelationshipPK) obj;
		if (person1 == null) {
			if (other.person1 != null)
				return false;
		} else if (!person1.equals(other.person1))
			return false;
		if (person2 == null) {
			if (other.person2 != null)
				return false;
		} else if (!person2.equals(other.person2))
			return false;
		if (relationship == null) {
			if (other.relationship != null)
				return false;
		} else if (!relationship.equals(other.relationship))
			return false;
		return true;
	}

	
	
}
