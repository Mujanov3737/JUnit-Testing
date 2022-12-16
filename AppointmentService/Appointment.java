/*
 * Name: Ahmet Mujanovic
 * Course: CS-320
 * Date: 12-04-2022
 * Description: Project One Appointment
 */
package appointment;

import java.util.Date;

public class Appointment {
	
	// Declaring fields
	private Date Date;
	private String Description;
	private final String Id;	  // Final keyword for ID because it cannot be modified after initialization
	
	// Constructor with illegal argument checks
	public Appointment(Date Date, String Description, String Id) {
		
		// Conditional statements to check if field are out of bounds or illegal
		if (Date == null || Date.before(new Date())) {
			throw new IllegalArgumentException("Invalid date");
		}
		if (Description == null || Description.length() > 50) {
			throw new IllegalArgumentException("Invalid description");
		}
		if (Id == null || Id.length() > 10) {
			throw new IllegalArgumentException("Invalid Id");
		}
		
		// Setting values for constructor
		this.Date = Date;
		this.Description = Description;
		this.Id = Id;
	}
	
	// Accessors for Appointment class
	public Date getDate() {
		return Date;
	}
	
	public String getDescription() {
		return Description;
	}
	
	public String getId() {
		return Id;
	}
	
	// Mutators for Appointment class
	public void setDate(Date Date) {
		this.Date = Date;
	}
	
	public void setDescription(String Description) {
		this.Description = Description;
	}
}

