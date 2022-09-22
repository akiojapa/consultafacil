package com.consultafacil.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consultafacil.entitities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
