package com.consultafacil.consultafacil.entitities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "tb_doctors")
public class Doctor implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String spec;
	
	@OneToOne
	@MapsId
	private User userD;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "doctors")
	private Set<Ubs> ubss = new HashSet<>();
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "docSchedule")
	private List<Schedule> schedule = new ArrayList<>();
	
	
	public Doctor() {
		
	}


	public Doctor(Long id, String name, String spec, User userD) {
		super();
		this.id = id;
		this.name = name;
		this.spec = spec;
		this.userD = userD;
	}


	public Long getId() {
		return id;
	}


	public String getName() {
		return name;
	}


	public String getSpec() {
		return spec;
	}


	public User getUser() {
		return userD;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setSpec(String spec) {
		this.spec = spec;
	}


	public void setUser(User userD) {
		this.userD = userD;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id, name, spec, userD);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Doctor other = (Doctor) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name) && Objects.equals(spec, other.spec)
				&& Objects.equals(userD, other.userD);
	}


	public Set<Ubs> getUbss() {
		return ubss;
	}
	
	
	
	
}
