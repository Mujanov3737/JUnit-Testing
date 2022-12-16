/*
 * Name: Ahmet Mujanovic
 * Course: CS-320
 * Date: 12-04-2022
 * Description: Project One Contact Service Test
 */
package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import contact.Contact;
import contact.ContactService;

class ContactServiceTest {
	
	private ContactService contactService;
	
	@BeforeAll
	public static void setupAll() {
		System.out.println("Test class running ok");
	}
	
	@BeforeEach
	public void startup( ) {
		System.out.println("Creating service object");
		contactService = new ContactService();
	}
	
	@Test
	@DisplayName("Create a contact and sucessfully add into the list")
	void testContactServiceAddContactSucessfully() {
		Contact contact = new Contact("John", "Smith", "8005551111", "123 Main St", "1001");
		contactService.addContact(contact);
		assertFalse(contactService.contacts.isEmpty());
		assertEquals(1, contactService.contacts.size());
	}
	
	@Test
	@DisplayName("Throw error if 2 identical ID's are added")
	void testContactServiceAddContactCollision() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact contact = new Contact("John", "Smith", "8005551111", "123 Main St", "1001");
			contactService.addContact(contact);
			Contact contact1 = new Contact("John", "Smith", "8005551111", "123 Main St", "1001");
			contactService.addContact(contact1);
		});     }
	
	@Test
	@DisplayName("Create a contact, add into the list, and remove sucessfully")
	void testContactServiceRemoveContact() {
		Contact contact = new Contact("John", "Smith", "8005551111", "123 Main St", "1001");
		contactService.addContact(contact);
		contactService.removeContact(contact.getId());
		assertTrue(contactService.contacts.isEmpty());
		}
	
	@Test
	@DisplayName("Throw exception if removing contact with ID that does not exist")
	void testContactServiceRemoveContactDoesNotExist() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact contact = new Contact("John", "Smith", "8005551111", "123 Main St", "1001");
			contactService.addContact(contact);
			assertFalse(contactService.contacts.isEmpty());
			contactService.removeContact("1002");
		});     }
	
	@Test
	@DisplayName("First name object does not exist")
	void testContactServiceModifyFirstNameIdDoesNotExist() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact contact = new Contact("John", "Smith", "8005551111", "123 Main St", "1001");
			contactService.addContact(contact);
			String update = "Mary";
			contactService.modifyContactFirstName("1002", update);
		});     }

	@Test
	@DisplayName("Update contact first name")
	void testContactServiceModifyFirstName() {
		Contact contact = new Contact("John", "Smith", "8005551111", "123 Main St", "1001");
		contactService.addContact(contact);
		String update = "Mary";
		contactService.modifyContactFirstName("1001", update);
		assertEquals(update, contact.getFirstName());
		}
	
	@Test
	@DisplayName("Last name object does not exist")
	void testContactServiceModifyLastNameIdDoesNotExist() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact contact = new Contact("John", "Smith", "8005551111", "123 Main St", "1001");
			contactService.addContact(contact);
			String update = "Baker";
			contactService.modifyContactLastName("1002", update);
		});     }

	@Test
	@DisplayName("Update contact last name")
	void testContactServiceModifyLastName() {
		Contact contact = new Contact("John", "Smith", "8005551111", "123 Main St", "1001");
		contactService.addContact(contact);
		String update = "Baker";
		contactService.modifyContactLastName("1001", update);
		assertEquals(update, contact.getLastName());
		}
	
	@Test
	@DisplayName("Number object does not exist")
	void testContactServiceModifyNumberIdDoesNotExist() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact contact = new Contact("John", "Smith", "8005551111", "123 Main St", "1001");
			contactService.addContact(contact);
			String update = "8005551110";
			contactService.modifyContactNumber("1002", update);
		});     }

	@Test
	@DisplayName("Update contact number")
	void testContactServiceModifyNumber() {
		Contact contact = new Contact("John", "Smith", "8005551111", "123 Main St", "1001");
		contactService.addContact(contact);
		String update = "8005551110";
		contactService.modifyContactNumber("1001", update);
		assertEquals(update, contact.getNumber());
		}
	
	@Test
	@DisplayName("Address object does not exist")
	void testContactServiceModifyAddressIdDoesNotExist() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact contact = new Contact("John", "Smith", "8005551111", "123 Main St", "1001");
			contactService.addContact(contact);
			String update = "123 Sunset St";
			contactService.modifyContactAddress("1002", update);
		});     }

	@Test
	@DisplayName("Update contact address")
	void testContactServiceModifyAddress() {
		Contact contact = new Contact("John", "Smith", "8005551111", "123 Main St", "1001");
		contactService.addContact(contact);
		String update = "123 Sunset St";
		contactService.modifyContactAddress("1001", update);
		assertEquals(update, contact.getAddress());
		}

}
