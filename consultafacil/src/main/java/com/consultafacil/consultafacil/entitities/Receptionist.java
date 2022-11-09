package com.consultafacil.consultafacil.entitities;

import java.io.Serializable;

import java.util.HashSet;

import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_receptionists")
public class Receptionist implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	
	@JsonIgnore
	@OneToOne
	private User userR;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "receptionists")
	private Set<Ubs> ubss = new HashSet<>();
	
	public Receptionist() {
		
	}

	public Receptionist(Long id, String name, User userR) {
		super();
		this.id = id;
		this.name = name;
		this.userR = userR;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public User getUser() {
		return userR;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUser(User userR) {
		this.userR = userR;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, userR);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Receptionist other = (Receptionist) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name) && Objects.equals(userR, other.userR);
	}

	public Set<Ubs> getUbss() {
		return ubss;
	}
	
	
	
	
}
