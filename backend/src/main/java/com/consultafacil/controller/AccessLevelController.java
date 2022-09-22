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

import com.consultafacil.entitities.AccessLevel;
import com.consultafacil.services.AccessLevelService;

@RestController
@RequestMapping(value="/accessLevel")
public class AccessLevelController {

	@Autowired
	private AccessLevelService service;
	
	@GetMapping
	public ResponseEntity<List<AccessLevel>> findAll() {
		List<AccessLevel> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<AccessLevel> findById(@PathVariable Long id){
		AccessLevel obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<AccessLevel> insert(@RequestBody AccessLevel obj){
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
	public ResponseEntity<AccessLevel> update(@PathVariable Long id, @RequestBody AccessLevel obj){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	
	
}
