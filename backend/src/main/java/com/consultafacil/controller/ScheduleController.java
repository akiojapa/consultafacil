package com.consultafacil.controller;

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

import com.consultafacil.entitities.Schedule;
import com.consultafacil.entitities.Schedule;
import com.consultafacil.services.ScheduleService;

@RestController
@RequestMapping(value="/schedule")
public class ScheduleController {

	@Autowired
	private ScheduleService service;
	
	@GetMapping
	public ResponseEntity<List<Schedule>> findAll() {
		List<Schedule> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Schedule> findById(@PathVariable Long id){
		Schedule obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Schedule> insert(@RequestBody Schedule obj){
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
	public ResponseEntity<Schedule> update(@PathVariable Long id, @RequestBody Schedule obj){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	
}
