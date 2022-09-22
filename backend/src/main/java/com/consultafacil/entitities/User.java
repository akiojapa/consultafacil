package com.consultafacil.entitities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_User")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String cpf;
	
	private String password;
	
	@JsonIgnore
	@OneToOne(mappedBy = "userP", cascade = CascadeType.ALL)
	private Pacient pacient;
	
	@JsonIgnore
	@OneToOne(mappedBy = "userD", cascade = CascadeType.ALL)
	private Doctor doctor;

	@JsonIgnore
	@OneToOne(mappedBy = "userR", cascade = CascadeType.ALL)
	private Receptionist receptionist;
	
	
	@ManyToOne
	@JoinColumn(name = "access_level")
	private AccessLevel accessLevel;

	
	public User() {
		
	}


	public User(Long id, String cpf, String password, AccessLevel accessLevel) {
		super();
		this.id = id;
		this.cpf = cpf;
		this.password = password;
		this.accessLevel = accessLevel;
	}


	public Long getId() {
		return id;
	}


	public String getCpf() {
		return cpf;
	}


	public String getPassword() {
		return password;
	}


	public AccessLevel getAccessLevel() {
		return accessLevel;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public void setAccessLevel(AccessLevel accessLevel) {
		this.accessLevel = accessLevel;
	}




	@Override
	public int hashCode() {
		return Objects.hash(accessLevel, cpf, id, password);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(accessLevel, other.accessLevel) && Objects.equals(cpf, other.cpf)
				&& Objects.equals(id, other.id) && Objects.equals(password, other.password);
	}
	
	
	
	
	
}
