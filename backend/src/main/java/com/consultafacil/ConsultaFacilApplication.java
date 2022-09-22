package com.consultafacil;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.consultafacil.entitities.AccessLevel;
import com.consultafacil.repositories.AccessLevelRepository;

@SpringBootApplication
public class ConsultaFacilApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsultaFacilApplication.class, args);
		

	}

}
