package com.consultafacil.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consultafacil.entitities.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

}
