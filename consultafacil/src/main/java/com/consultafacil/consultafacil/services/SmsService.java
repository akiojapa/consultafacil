package com.consultafacil.consultafacil.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.consultafacil.consultafacil.entitities.Appointment;
import com.consultafacil.consultafacil.repositories.AppointmentRepository;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class SmsService {

	@Value("${twilio.sid}")
	private String twilioSid;

	@Value("${twilio.key}")
	private String twilioKey;

	@Value("${twilio.phone.from}")
	private String twilioPhoneFrom;

	@Value("${twilio.phone.to}")
	private String twilioPhoneTo;

	@Autowired
	private AppointmentRepository appointmentRepository;

	public void sendSms(Long appointmentId) {

		
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		
		Appointment appointment = appointmentRepository.findById(appointmentId).get();
		
		String msg = "Olá " + appointment.getPacient().getName() + "! Não esqueça da sua consulta marcada em: " + dateFormat.format(appointment.getSchedule().getday_schedule());

		twilioPhoneTo = appointment.getPacient().getCel();
		
		Twilio.init(twilioSid, twilioKey);

		PhoneNumber to = new PhoneNumber(twilioPhoneTo);
	
		PhoneNumber from = new PhoneNumber(twilioPhoneFrom);

		Message message = Message.creator(to, from, msg).create();

		System.out.println(message.getSid());
	}
}
