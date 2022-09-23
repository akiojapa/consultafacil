package com.consultafacil.consultafacil.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.consultafacil.entitities.Doctor;
import com.consultafacil.entitities.Doctor;
import com.consultafacil.repositories.DoctorRepository;



@Service
public class DoctorService {
	
	@Autowired
	private DoctorRepository repository;
	
	
	public List<Doctor> findAll(){
		return repository.findAll();
	}
	
	public Doctor findById(Long id) {
		Optional<Doctor> obj = repository.findById(id);
		return obj.get();
	}
	
	public Doctor insert(Doctor obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public Doctor update(Long id, Doctor obj) {
		Doctor entity = repository.getOne(id);
		updateData(entity,obj);
		return repository.save(entity);
	}

	private void updateData(Doctor entity, Doctor obj) {
		entity.setName(obj.getName());
		entity.setSpec(obj.getSpec());
		entity.setUser(obj.getUser());
		
	}
}
