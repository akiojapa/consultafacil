package com.consultafacil.consultafacil.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.consultafacil.consultafacil.entitities.Appointment;
import com.consultafacil.consultafacil.services.AppointmentService;
import com.consultafacil.consultafacil.services.SmsService;


@RestController
@RequestMapping(value="/appointment")
public class AppointmentController {

	@Autowired
	private AppointmentService service;
	
	@Autowired
	private SmsService smsService;
	
	@GetMapping
	public ResponseEntity<List<Appointment>> findAll() {
		List<Appointment> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Appointment> findById(@PathVariable Long id){
		Appointment obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Appointment> insert(@RequestBody Appointment obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
			service.delete(id);
			return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Appointment> update(@PathVariable Long id, @RequestBody Appointment obj){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping("/{id}/notification")
		public void notifySms(@PathVariable Long id) {
		smsService.sendSms(id);
	}
}
