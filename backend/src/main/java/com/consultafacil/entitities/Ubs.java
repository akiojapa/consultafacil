package com.consultafacil.entitities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "tb_ubs")
public class Ubs implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String loc;
	
	
	@ManyToMany
	@JoinTable(name = "tb_doctor_ubs", 
	joinColumns = @JoinColumn(name = "ubs_id"),
	inverseJoinColumns = @JoinColumn(name = "doctor_id"))
	private Set<Doctor> doctors = new HashSet<>();
	
	
	
	@ManyToMany
	@JoinTable(name = "tb_receptionist_ubs", 
	joinColumns = @JoinColumn(name = "ubs_id"),
	inverseJoinColumns = @JoinColumn(name = "receptionist_id"))
	private Set<Receptionist> receptionists = new HashSet<>();

	
	@OneToOne(mappedBy = "ubs", cascade = CascadeType.ALL)
	private Appointment appointment;
//	@JsonIgnore
//	@ManyToMany(mappedBy = "ubss")
//	private Set<Appointment> appointment = new HashSet<>();
	

	
	public Ubs() {
		
	}



	public Ubs(Long id, String name, String loc) {
		super();
		this.id = id;
		this.name = name;
		this.loc = loc;
	}



	public Long getId() {
		return id;
	}



	public String getName() {
		return name;
	}



	public String getLoc() {
		return loc;
	}





	public void setId(Long id) {
		this.id = id;
	}



	public void setName(String name) {
		this.name = name;
	}



	public void setLoc(String loc) {
		this.loc = loc;
	}




	@Override
	public int hashCode() {
		return Objects.hash(id, loc, name);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ubs other = (Ubs) obj;
		return Objects.equals(id, other.id) && Objects.equals(loc, other.loc) && Objects.equals(name, other.name);
	}



	public Set<Receptionist> getReceptionists() {
		return receptionists;
	}



	public Set<Doctor> getDoctors() {
		return doctors;
	}



//	public Set<Appointment> getAppointment() {
//		return appointment;
//	}


	
}
