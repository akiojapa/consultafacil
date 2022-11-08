package com.consultafacil.consultafacil.entitities;

import java.io.Serializable;
import 	java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_schedule")
public class Schedule implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Date day_schedule;
	
	private Date hr_ini;
	
	private Date hr_end;
	
	private String condition;

	@OneToOne(mappedBy = "schedule", fetch=FetchType.LAZY)
	private Appointment appointment;
	
//	@JsonIgnore
//	@ManyToMany(mappedBy = "schedules")
//	private Set<Appointment> appointment = new HashSet<>();

	@ManyToOne
	@JoinColumn(name = "docSchedule")
	private Doctor docSchedule;
	

	
	public Schedule () {
		
	}
	
	
	public Schedule(Long id, Date day_schedule, Date hr_ini, Date hr_end, String condition, Doctor docSchedule) {
		super();
		this.id = id;
		this.day_schedule = day_schedule;
		this.hr_ini = hr_ini;
		this.hr_end = hr_end;
		this.condition = condition;
		this.docSchedule = docSchedule;
	}


	
	public Long getId() {
		return id;
	}

	public Date getday_schedule() {
		return day_schedule;
	}

	public Date getHr_ini() {
		return hr_ini;
	}

	public Date getHr_end() {
		return hr_end;
	}

	public String getcondition() {
		return condition;
	}

	public Doctor getdocSchedule() {
		return docSchedule;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setday_schedule(Date day_schedule) {
		this.day_schedule = day_schedule;
	}

	public void setHr_ini(Date hr_ini) {
		this.hr_ini = hr_ini;
	}

	public void setHr_end(Date hr_end) {
		this.hr_end = hr_end;
	}

	public void setcondition(String condition) {
		this.condition = condition;
	}

	public void setdocSchedule(Doctor docSchedule) {
		this.docSchedule = docSchedule;
	}

	@Override
	public int hashCode() {
		return Objects.hash(day_schedule, docSchedule, hr_end, hr_ini, id, condition);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Schedule other = (Schedule) obj;
		return Objects.equals(day_schedule, other.day_schedule) && Objects.equals(docSchedule, other.docSchedule)
				&& Objects.equals(hr_end, other.hr_end) && Objects.equals(hr_ini, other.hr_ini)
				&& Objects.equals(id, other.id) && Objects.equals(condition, other.condition);
	}

//	public Set<Appointment> getAppointment() {
//		return appointment;
//	}
	
	

	
	
	
	
}
