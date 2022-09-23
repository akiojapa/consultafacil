package com.consultafacil.consultafacil.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consultafacil.consultafacil.entitities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
