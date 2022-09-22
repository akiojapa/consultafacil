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

import com.consultafacil.entitities.Ubs;
import com.consultafacil.entitities.Ubs;
import com.consultafacil.services.UbsService;

@RestController
@RequestMapping(value="/ubs")
public class UbsController {

	@Autowired
	private UbsService service;
	
	@GetMapping
	public ResponseEntity<List<Ubs>> findAll() {
		List<Ubs> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Ubs> findById(@PathVariable Long id){
		Ubs obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Ubs> insert(@RequestBody Ubs obj){
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
	public ResponseEntity<Ubs> update(@PathVariable Long id, @RequestBody Ubs obj){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	
}


