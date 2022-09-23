package com.consultafacil.consultafacil.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.consultafacil.consultafacil.entitities.AccessLevel;
import com.consultafacil.consultafacil.repositories.AccessLevelRepository;



@Service
public class AccessLevelService {
	
	@Autowired
	private AccessLevelRepository repository;
	
	
	public List<AccessLevel> findAll(){
		return repository.findAll();
	}
	
	public AccessLevel findById(Long id) {
		Optional<AccessLevel> obj = repository.findById(id);
		return obj.get();
	}
	
	public AccessLevel insert(AccessLevel obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public AccessLevel update(Long id, AccessLevel obj) {
		AccessLevel entity = repository.getOne(id);
		updateData(entity,obj);
		return repository.save(entity);
	}

	private void updateData(AccessLevel entity, AccessLevel obj) {
		entity.setNameaccess(obj.getNameaccess());
		entity.setOrderlevel(obj.getOrderlevel());
		
	}
	
	
}
