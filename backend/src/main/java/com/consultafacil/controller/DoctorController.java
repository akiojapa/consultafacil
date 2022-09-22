package com.consultafacil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.consultafacil.entitities.Doctor;
import com.consultafacil.services.DoctorService;

@RestController
@RequestMapping(value="/doctors")
public class DoctorController {

	@Autowired
	private DoctorService service;
	
	@GetMapping
	public ResponseEntity<List<Doctor>> findAll() {
		List<Doctor> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Doctor> findById(@PathVariable Long id){
		Doctor obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}


