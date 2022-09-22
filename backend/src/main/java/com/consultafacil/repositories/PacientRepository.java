package com.consultafacil.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consultafacil.entitities.Pacient;

public interface PacientRepository extends JpaRepository<Pacient, Long> {

}
