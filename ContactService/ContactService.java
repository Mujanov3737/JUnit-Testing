/*
 * Name: Ahmet Mujanovic
 * Course: CS-320
 * Date: 12-04-2022
 * Description: Project One Contact Service
 */
package contact;

import java.util.ArrayList;
import java.util.List;

public class ContactService {
	
	// Creating list to hold contacts
	public List<Contact> contacts = new ArrayList<Contact>();
	
	// Finding contact by ID
	public Contact findContact(String Id) {
		for (Contact contact : contacts) {
			if (contact.getId() == Id) {
				return contact;
			}
		}
		throw new IllegalArgumentException("No object with that ID exists");
	}
	
	// Checking if contact exists
	public void contactExistsCheck(Contact p_contact) {
		for(Contact contact : contacts) {
			if (contact.getId() == p_contact.getId()) {
				throw new IllegalArgumentException("ID already exists");
			}
		}
	}
	
	public void addContact(Contact p_contact) {
		contactExistsCheck(p_contact);
		contacts.add(p_contact);
	}
	
	public void removeContact(String Id) {
		contacts.remove(findContact(Id));
	}
	
	public void modifyContactFirstName(String Id, String firstName) {
		if (findContact(Id).getFirstName() != firstName) {
			findContact(Id).setFirstName(firstName);
		}
	}
	
	public void modifyContactLastName(String Id, String lastName) {
		if (findContact(Id).getFirstName() != lastName) {
			findContact(Id).setLastName(lastName);
		}
	}
	
	public void modifyContactNumber(String Id, String Number) {
		if (findContact(Id).getNumber() != Number) {
			findContact(Id).setNumber(Number);
		}
	}
	
	public void modifyContactAddress(String Id, String Address) {
		if (findContact(Id).getAddress() != Address) {
			findContact(Id).setAddress(Address);
		}
	}
}
