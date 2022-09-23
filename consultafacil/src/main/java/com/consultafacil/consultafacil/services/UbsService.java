package com.consultafacil.consultafacil.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.consultafacil.consultafacil.entitities.Ubs;
import com.consultafacil.consultafacil.repositories.UbsRepository;



@Service
public class UbsService {
	
	@Autowired
	private UbsRepository repository;
	
	
	public List<Ubs> findAll(){
		return repository.findAll();
	}
	
	public Ubs findById(Long id) {
		Optional<Ubs> obj = repository.findById(id);
		return obj.get();
	}
	
	public Ubs insert(Ubs obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public Ubs update(Long id, Ubs obj) {
		Ubs entity = repository.getOne(id);
		updateData(entity,obj);
		return repository.save(entity);
	}

	private void updateData(Ubs entity, Ubs obj) {
		entity.setName(obj.getName());
		entity.setLoc(obj.getLoc());
		
	}
}
