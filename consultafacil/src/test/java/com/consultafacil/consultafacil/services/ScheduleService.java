package com.consultafacil.consultafacil.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.consultafacil.entitities.Schedule;
import com.consultafacil.entitities.Schedule;
import com.consultafacil.repositories.ScheduleRepository;



@Service
public class ScheduleService {
	
	@Autowired
	private ScheduleRepository repository;
	
	
	public List<Schedule> findAll(){
		return repository.findAll();
	}
	
	public Schedule findById(Long id) {
		Optional<Schedule> obj = repository.findById(id);
		return obj.get();
	}
	
	public Schedule insert(Schedule obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public Schedule update(Long id, Schedule obj) {
		Schedule entity = repository.getOne(id);
		updateData(entity,obj);
		return repository.save(entity);
	}

	private void updateData(Schedule entity, Schedule obj) {
		entity.setcondition(obj.getcondition());
		entity.setday_schedule(obj.getday_schedule());
		entity.setHr_ini(obj.getHr_ini());
		entity.setHr_end(obj.getHr_end());
		entity.setdocSchedule(obj.getdocSchedule());
		
	}
}
