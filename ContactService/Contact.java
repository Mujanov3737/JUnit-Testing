/*
 * Name: Ahmet Mujanovic
 * Course: CS-320
 * Date: 12-04-2022
 * Description: Project One Contact
 */
package contact;

public class Contact {
	
	// Declaring fields
	private String firstName;
	private String lastName;
	private String Number;
	private String Address;
	private final String Id;	  // Final keyword for ID because it cannot be modified after initialization
	
	// Constructor with illegal argument checks
	public Contact(String firstName, String lastName, String Number,  String Address, String Id) {
		
		// Conditional statements to check if field are out of bounds or illegal
		if (firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("Invalid first name");
		}
		if (lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid last name");
		}
		if (Number == null || Number.length() != 10) {
			throw new IllegalArgumentException("Invalid number");
		}
		if (Address == null || Address.length() > 30) {
			throw new IllegalArgumentException("Invalid Address");
		}
		if (Id == null || Id.length() > 10) {
			throw new IllegalArgumentException("Invalid Id");
		}
		
		// Setting values for constructor
		this.firstName = firstName;
		this.lastName = lastName;
		this.Number = Number;
		this.Address = Address;
		this.Id = Id;
	}
	
	// Accessors for Contact class
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getNumber() {
		return Number;
	}
	
	public String getAddress() {
		return Address;
	}
	
	public String getId() {
		return Id;
	}
	
	// Mutators for Contact class
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setNumber(String Number) {
		this.Number = Number;
	}
	
	public void setAddress(String Address) {
		this.Address = Address;
	}
}
