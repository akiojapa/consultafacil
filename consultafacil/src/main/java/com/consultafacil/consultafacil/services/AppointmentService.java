package com.consultafacil.consultafacil.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.consultafacil.consultafacil.entitities.Appointment;
import com.consultafacil.consultafacil.repositories.AppointmentRepository;



@Service
public class AppointmentService {
	
	@Autowired
	private AppointmentRepository repository;
	
	
	public List<Appointment> findAll(){
		return repository.findAll();
	}
	
	public Appointment findById(Long id) throws Exception {
		Optional<Appointment> obj = repository.findById(id);
		if(obj.isEmpty()) {
		    throw new Exception("Id não encontrado!");
		}
		return obj.get();
	}
	
	public Appointment insert(Appointment obj) {
		return repository.save(obj);
	}
	
	public void delete(Appointment obj) {
	    repository.delete(obj);
	}
	
	public void deletarTeste(Long id) throws Exception {
	    findById(id);
	    repository.deleteById(id);
	}
	
	
	public Appointment update(Long id, Appointment obj) {
		Appointment entity = repository.getOne(id);
		updateData(entity,obj);
		return repository.save(entity);
	}

	private void updateData(Appointment entity, Appointment obj) {
		entity.setAppointmentStatus(obj.getAppointmentStatus());
		
		
	}
}
