/*
 * Name: Ahmet Mujanovic
 * Course: CS-320
 * Date: 12-04-2022
 * Description: Project One Appointment Service
 */
package appointment;

import java.util.ArrayList;
import java.util.List;

public class AppointmentService {
	
	// Creating list to hold appointments
	public List<Appointment> appointments = new ArrayList<Appointment>();
	
	// Finding appointment by ID
	public Appointment findAppointment(String Id) {
		for (Appointment appointment : appointments) {
			if (appointment.getId() == Id) {
				return appointment;
			}
		}
		throw new IllegalArgumentException("No object with that ID exists");
	}
	
	// Checking if appointment exists
	public void appointmentExistsCheck(Appointment p_appointment) {
		for(Appointment appointment : appointments) {
			if (appointment.getId() == p_appointment.getId()) {
				throw new IllegalArgumentException("ID already exists");
			}
		}
	}
	
	public void addAppointment(Appointment p_appointment) {
		appointmentExistsCheck(p_appointment);
		appointments.add(p_appointment);
	}
	
	public void removeAppointment(String Id) {
		appointments.remove(findAppointment(Id));
	}
}
