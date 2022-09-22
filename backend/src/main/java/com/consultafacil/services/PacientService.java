package com.consultafacil.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.consultafacil.entitities.Pacient;
import com.consultafacil.entitities.Pacient;
import com.consultafacil.repositories.PacientRepository;



@Service
public class PacientService {
	
	@Autowired
	private PacientRepository repository;
	
	
	public List<Pacient> findAll(){
		return repository.findAll();
	}
	
	public Pacient findById(Long id) {
		Optional<Pacient> obj = repository.findById(id);
		return obj.get();
	}
	
	public Pacient insert(Pacient obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public Pacient update(Long id, Pacient obj) {
		Pacient entity = repository.getOne(id);
		updateData(entity,obj);
		return repository.save(entity);
	}

	private void updateData(Pacient entity, Pacient obj) {
		entity.setCel(obj.getCel());
		entity.setEmail(obj.getEmail());
		entity.setName(obj.getName());
		entity.setUser(obj.getUser());
		
	}
}
