/*
 * Name: Ahmet Mujanovic
 * Course: CS-320
 * Date: 12-04-2022
 * Description: Project One Appointment Test
 */
package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import appointment.Appointment;

class AppointmentTest {
	
	@BeforeAll
	public static void setupAll() {
		System.out.println("Test class running ok");
	}
	
	@Test
	void testAppointment() {
		// Creating Date object to pass into appointment constructor
		Date appointmentDate = new Date(2025, 5, 5, 5, 5, 5);
		
		// Initializing appointment object with arguments
		Appointment appointment = new Appointment(appointmentDate, "Meet with Sarah", "1001");
		
		// Checking arguments with asserts to see if object is created successfully and accurately
		assertTrue(appointment.getDate().equals(appointmentDate));
		assertTrue(appointment.getDescription().equals("Meet with Sarah"));
		assertTrue(appointment.getId().equals("1001"));
	}
	
	
	@Test
	void testAppointmentNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(null, "Meet with Sarah", "1001");
		});     }
	
	@Test
	void testAppointmentInPast() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Date appointmentDate = new Date(5, 5, 5, 5, 5, 5);
			new Appointment(appointmentDate, "Meet with Sarah", "1001");
		});     }
	
	@Test
	void testAppointmentDescriptionNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Date appointmentDate = new Date(2025, 5, 5, 5, 5, 5);
			new Appointment(appointmentDate, null, "1001");
		});     }
	
	@Test
	void testAppointmentDescriptionLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Date appointmentDate = new Date(2025, 5, 5, 5, 5, 5);
			new Appointment(appointmentDate, "Meet with Sarah!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!", "1001");
		});     }
	
	@Test
	void testAppointmentIdNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Date appointmentDate = new Date(2025, 5, 5, 5, 5, 5);
			new Appointment(appointmentDate, "Meet with Sarah", null);
		});     }
	
	@Test
	void testAppointmentIdLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Date appointmentDate = new Date(2025, 5, 5, 5, 5, 5);
			new Appointment(appointmentDate, "Meet with Sarah", "100100000000000000");
		});     }

}
