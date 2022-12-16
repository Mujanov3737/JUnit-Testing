/*
 * Name: Ahmet Mujanovic
 * Course: CS-320
 * Date: 12-04-2022
 * Description: Project One Task Test
 */
package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
/*
 * Name: Ahmet Mujanovic
 * Course: CS-320
 * Date: 11-20-2022
 * Description: Milestone Four Task Tests
 */
import org.junit.jupiter.api.Test;

import task.Task;

class TaskTest {
	
	@BeforeAll
	public static void setupAll() {
		System.out.println("Test class running ok");
	}
	
	@Test
	void testTask() {
		// Initializing task object with arguments
		Task task = new Task("Clean", "Please clean your room", "1001");
		
		// Checking arguments with asserts to see if object is created successfully and accurately
		assertTrue(task.getName().equals("Clean"));
		assertTrue(task.getDescription().equals("Please clean your room"));
		assertTrue(task.getId().equals("1001"));
	}
	
	
	@Test
	void testTaskNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task(null, "Please clean your room", "1001");
		});     }
	
	@Test
	void testTaskNameLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("ThisTaskNameIsMoreThanTwentyCharacters", "Please clean your room", "1001");
		});     }
	
	@Test
	void testTaskDescriptionNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("Clean", null, "1001");
		});     }
	
	@Test
	void testTaskDescriptionLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("Clean", "Please clean your room!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!", "1001");
		});     }
	
	@Test
	void testTaskIdNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("Clean", "Please clean your room", null);
		});     }
	
	@Test
	void testTaskIdLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("Clean", "Please clean your room", "10010000000");
		});     }

}
