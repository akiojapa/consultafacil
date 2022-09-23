package com.consultafacil.consultafacil.entitities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
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
@Table(name = "tb_pacients")
public class Pacient implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String cel;
	
	private String email;
	
	@JsonIgnore
	@OneToOne
	@MapsId
	private User userP;

	@OneToOne(mappedBy = "pacient", cascade = CascadeType.ALL)
	private Appointment appointment;
//	@JsonIgnore
//	@ManyToMany(mappedBy = "pacients")
//	private Set<Appointment> appointment = new HashSet<>();
	
	public Pacient() {
		
	}

	public Pacient(Long id, String name, String cel, String email, User userP) {
		super();
		this.id = id;
		this.name = name;
		this.cel = cel;
		this.email = email;
		this.userP = userP;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getCel() {
		return cel;
	}

	public String getEmail() {
		return email;
	}

	public User getUser() {
		return userP;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCel(String cel) {
		this.cel = cel;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setUser(User userP) {
		this.userP = userP;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cel, email, id, name, userP);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pacient other = (Pacient) obj;
		return Objects.equals(cel, other.cel) && Objects.equals(email, other.email) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name) && Objects.equals(userP, other.userP);
	}
	
	

}
