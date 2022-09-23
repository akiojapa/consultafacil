package com.consultafacil.consultafacil.entitities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "tb_AccessLevel")
public class AccessLevel implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nameaccess;
	private Long orderlevel;
	
	public AccessLevel() {
		
	}

	public AccessLevel(Long id, String nameaccess, Long orderlevel) {
		super();
		this.id = id;
		this.nameaccess = nameaccess;
		this.orderlevel = orderlevel;
	}
	
	@JsonIgnore
	@OneToMany(mappedBy = "accessLevel")
	private List<User> users = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long idLong) {
		this.id = idLong;
	}

	public String getNameaccess() {
		return nameaccess;
	}

	public void setNameaccess(String nameaccess) {
		this.nameaccess = nameaccess;
	}

	public Long getOrderlevel() {
		return orderlevel;
	}

	public void setOrderlevel(Long orderlevel) {
		this.orderlevel = orderlevel;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nameaccess, orderlevel);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AccessLevel other = (AccessLevel) obj;
		return Objects.equals(id, other.id) && Objects.equals(nameaccess, other.nameaccess)
				&& Objects.equals(orderlevel, other.orderlevel);
	}
	
	
	
	
	
}
