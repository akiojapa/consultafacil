package com.consultafacil.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.consultafacil.entitities.Receptionist;
import com.consultafacil.entitities.Receptionist;
import com.consultafacil.repositories.ReceptionistRepository;



@Service
public class ReceptionistService {
	
	@Autowired
	private ReceptionistRepository repository;
	
	
	public List<Receptionist> findAll(){
		return repository.findAll();
	}
	
	public Receptionist findById(Long id) {
		Optional<Receptionist> obj = repository.findById(id);
		return obj.get();
	}
	
	public Receptionist insert(Receptionist obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public Receptionist update(Long id, Receptionist obj) {
		Receptionist entity = repository.getOne(id);
		updateData(entity,obj);
		return repository.save(entity);
	}

	private void updateData(Receptionist entity, Receptionist obj) {
		entity.setName(obj.getName());
		entity.setUser(obj.getUser());
	
	}
}
