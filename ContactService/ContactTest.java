/*
 * Name: Ahmet Mujanovic
 * Course: CS-320
 * Date: 12-04-2022
 * Description: Project One Contact Test
 */
package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import contact.Contact;

class ContactTest {
	
	@BeforeAll
	public static void setupAll() {
		System.out.println("Test class running ok");
	}
	
	@Test
	void testContact() {
		// Initializing contact object with arguments
		Contact contact = new Contact("John", "Smith", "8005551111", "123 Main St", "1001");
		
		// Checking arguments with asserts to see if object is created successfully and accurately
		assertTrue(contact.getFirstName().equals("John"));
		assertTrue(contact.getLastName().equals("Smith"));
		assertTrue(contact.getNumber().equals("8005551111"));
		assertTrue(contact.getAddress().equals("123 Main St"));
		assertTrue(contact.getId().equals("1001"));
	}
	
	
	@Test
	void testContactFirstNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, "Smith", "8005551111", "123 Main St", "1001");
		});     }
	
	@Test
	void testContactFirstNameLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("JohnJohnJohn", "Smith", "8005551111", "123 Main St", "1001");
		});     }
	
	@Test
	void testContactLastNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("John", null, "18005551111", "123 Main St", "1001");
		});     }
	
	@Test
	void testContactLastNameLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("John", "SmithSmithSmith", "8005551111", "123 Main St", "1001");
		});     }
	
	@Test
	void testContactNumberNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("John", "Smith", null, "123 Main St", "1001");
		});     }
	
	@Test
	void testContactNumberLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("John", "Smith", "11118005551111", "123 Main St", "1001");
		});     }
	
	@Test
	void testContactNumberShort() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("John", "Smith", "555", "123 Main St", "1001");
		});     }
	
	@Test
	void testContactAddressNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("John", "Smith", "8005551111", null, "1001");
		});     }
	
	@Test
	void testContactAddressLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("John", "Smith", "8005551111", "123 MainMainMainMainMainMainMainMainMainMain St", "1001");
		});     }
	
	@Test
	void testContactIdNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("John", "Smith", "8005551111", "123 Main St", null);
		});     }
	
	@Test
	void testContactIdLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("John", "Smith", "8005551111", "123 Main St", "100110011001");
		});     }

}
