package com.challengue.apirest.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
@Table(name="persons")
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "dni", nullable = false)
	private Integer dni;
	
	@Column(name = "dniType", length = 3, nullable = false)
	private String dniType;
	
	@Column(name = "country", length = 20, nullable = false)
    private String country;
    
	@Size(min=2, max=30, message = "El Nombre de tener entre 2 y 30 caracteres")
	@Column(name = "name", length = 30, nullable = false)
    private String name;
    
	@Size(min=2, max=50, message = "El Apellido de tener entre 2 y 50 caracteres")
	@Column(name = "lastname", length = 50, nullable = false)
    private String lastname;
    
	@Min(value=18, message = "La edad debe ser mayor a 18 años")
	@Column(name = "age", nullable = false)
    private int age;
    
    @Column(name="email", length = 100, nullable = false)
    @Email
    private String email;
   	
	public Person() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public String getDniType() {
		return dniType;
	}

	public void setDniType(String dniType) {
		this.dniType = dniType;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
    
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
    
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
    
    
	