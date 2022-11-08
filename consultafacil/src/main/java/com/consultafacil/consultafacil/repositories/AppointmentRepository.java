package com.consultafacil.consultafacil.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consultafacil.consultafacil.entitities.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    List<Appointment> findAllById(Long id);
    
    
}
