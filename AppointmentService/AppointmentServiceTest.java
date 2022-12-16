/*
 * Name: Ahmet Mujanovic
 * Course: CS-320
 * Date: 12-04-2022
 * Description: Project One Appointment Service Test
 */
package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import appointment.Appointment;
import appointment.AppointmentService;

class AppointmentServiceTest {
	
	private AppointmentService appointmentService;
	
	@BeforeAll
	public static void setupAll() {
		System.out.println("Test class running ok");
	}
	
	@BeforeEach
	public void startup( ) {
		System.out.println("Creating service object");
		appointmentService = new AppointmentService();
	}
	
	@Test
	@DisplayName("Create an appointment and sucessfully add into the list")
	void testAppointmentServiceAddAppointmentSucessfully() {
		Date appointmentDate = new Date(2025, 5, 5, 5, 5, 5);
		Appointment appointment = new Appointment(appointmentDate, "Meet with Sarah", "1001");
		appointmentService.addAppointment(appointment);
		assertFalse(appointmentService.appointments.isEmpty());
		assertEquals(1, appointmentService.appointments.size());
	}
	
	@Test
	@DisplayName("Throw error if 2 identical ID's are added")
	void testAppointmentServiceAddAppointmentCollision() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Date appointmentDate = new Date(2025, 5, 5, 5, 5, 5);
			Appointment appointment = new Appointment(appointmentDate, "Meet with Sarah", "1001");
			appointmentService.addAppointment(appointment);
			Appointment appointment2 = new Appointment(appointmentDate, "Meet with Sarah", "1001");
			appointmentService.addAppointment(appointment2);
		});     }
	
	@Test
	@DisplayName("Create an appointment, add into the list, and remove sucessfully")
	void testAppointmentServiceRemoveAppointment() {
		Date appointmentDate = new Date(2025, 5, 5, 5, 5, 5);
		Appointment appointment = new Appointment(appointmentDate, "Meet with Sarah", "1001");
		appointmentService.addAppointment(appointment);
		appointmentService.removeAppointment(appointment.getId());
		assertTrue(appointmentService.appointments.isEmpty());
		}
	
	@Test
	@DisplayName("Throw exception if removing appointment with ID that does not exist")
	void testAppointmentServiceRemoveAppointmentDoesNotExist() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Date appointmentDate = new Date(2025, 5, 5, 5, 5, 5);
			Appointment appointment = new Appointment(appointmentDate, "Meet with Sarah", "1001");
			appointmentService.addAppointment(appointment);
			assertFalse(appointmentService.appointments.isEmpty());
			appointmentService.removeAppointment("1002");
		});     }
}
