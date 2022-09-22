package com.consultafacil.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consultafacil.entitities.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

}
