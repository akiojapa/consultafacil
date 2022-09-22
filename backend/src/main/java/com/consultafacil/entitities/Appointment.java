package com.consultafacil.entitities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.consultafacil.entitities.enums.AppointmentStatus;

@Entity
@Table(name = "tb_appointment")
public class Appointment implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Integer appointmentStatus;

	@OneToOne
	@MapsId
	private Pacient pacient;
	
	@OneToOne
	@MapsId
	private Schedule schedule;
	
	@OneToOne
	@MapsId
	private Ubs ubs;
	
//	@ManyToMany
//	@JoinTable(name = "tb_appointment_ubs", 
//	joinColumns = @JoinColumn(name = "appointment_id"),
//	inverseJoinColumns = @JoinColumn(name = "ubs_id"))
//	private Set<Ubs> ubss = new HashSet<>();
//	
//	@ManyToMany
//	@JoinTable(name = "tb_appointment_pacient", 
//	joinColumns = @JoinColumn(name = "appointment_id"),
//	inverseJoinColumns = @JoinColumn(name = "pacient_id"))
//	private Set<Pacient> pacients = new HashSet<>();
//	
//	@ManyToMany
//	@JoinTable(name = "tb_appointment_schedule", 
//	joinColumns = @JoinColumn(name = "appointment_id"),
//	inverseJoinColumns = @JoinColumn(name = "schedule_id"))
//	private Set<Schedule> schedules = new HashSet<>();
	
	public Appointment() {
	}


	public Appointment(Long id, AppointmentStatus appointmentStatus, Pacient pacient, Schedule schedule, Ubs ubs) {
		super();
		this.id = id;
		setAppointmentStatus(appointmentStatus);
		this.setPacient(pacient);
		this.setSchedule(schedule);
		this.setUbs(ubs);
	}

	public Long getId() {
		return id;
	}

	public AppointmentStatus getAppointmentStatus() {
		return AppointmentStatus.valueOf(appointmentStatus);
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setAppointmentStatus(AppointmentStatus appointmentStatus) {
		this.appointmentStatus = appointmentStatus.getCode();
	}

	@Override
	public int hashCode() {
		return Objects.hash(appointmentStatus, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Appointment other = (Appointment) obj;
		return appointmentStatus == other.appointmentStatus && Objects.equals(id, other.id);
	}


	public Pacient getPacient() {
		return pacient;
	}


	public void setPacient(Pacient pacient) {
		this.pacient = pacient;
	}


	public Schedule getSchedule() {
		return schedule;
	}


	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}


	public Ubs getUbs() {
		return ubs;
	}


	public void setUbs(Ubs ubs) {
		this.ubs = ubs;
	}

//	public Set<Schedule> getSchedules() {
//		return schedules;
//	}
//
//	public Set<Pacient> getPacients() {
//		return pacients;
//	}
//
//	public Set<Ubs> getUbss() {
//		return ubss;
//	}


	
	

}
