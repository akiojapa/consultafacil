package com.consultafacil.consultafacil.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consultafacil.consultafacil.entitities.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

}
