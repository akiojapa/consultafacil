package com.consultafacil.consultafacil.entitities.enums;

public enum AppointmentStatus {

	WAITING_CONFIRMATION(1),
	CONFIRMED(2),
	CONSULTED(3),
	FINISHED(4),
	LATE(5);
	
	private int code;
	
	private AppointmentStatus(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}
	
	public static AppointmentStatus valueOf(int code) {
		for (AppointmentStatus value : AppointmentStatus.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid Appointment status code");
	}
}
