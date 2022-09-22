package com.consultafacil.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consultafacil.entitities.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

}
