/*
 * Name: Ahmet Mujanovic
 * Course: CS-320
 * Date: 12-04-2022
 * Description: Project One Task
 */
package task;

public class Task {
	
	// Declaring fields
	private String Name;
	private String Description;
	private final String Id;	  // Final keyword for ID because it cannot be modified after initialization
	
	// Constructor with illegal argument checks
	public Task(String Name, String Description, String Id) {
		
		// Conditional statements to check if field are out of bounds or illegal
		if (Name == null || Name.length() > 20) {
			throw new IllegalArgumentException("Invalid name");
		}
		if (Description == null || Description.length() > 50) {
			throw new IllegalArgumentException("Invalid description");
		}
		if (Id == null || Id.length() > 10) {
			throw new IllegalArgumentException("Invalid Id");
		}
		
		// Setting values for constructor
		this.Name = Name;
		this.Description = Description;
		this.Id = Id;
	}
	
	// Accessors for Task class
	public String getName() {
		return Name;
	}
	
	public String getDescription() {
		return Description;
	}
	
	public String getId() {
		return Id;
	}
	
	// Mutators for Task class
	public void setName(String Name) {
		this.Name = Name;
	}
	
	public void setDescription(String Description) {
		this.Description = Description;
	}
}
