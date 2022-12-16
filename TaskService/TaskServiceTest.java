/*
 * Name: Ahmet Mujanovic
 * Course: CS-320
 * Date: 12-04-2022
 * Description: Project One Task Service Test
 */
package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import task.Task;
import task.TaskService;

class TaskServiceTest {
	
	private TaskService taskService;
	
	@BeforeAll
	public static void setupAll() {
		System.out.println("Test class running ok");
	}
	
	@BeforeEach
	public void startup( ) {
		System.out.println("Creating service object");
		taskService = new TaskService();
	}
	
	@Test
	@DisplayName("Create a task and sucessfully add into the list")
	void testTaskServiceAddTaskSucessfully() {
		Task task = new Task("Clean", "Please clean your room", "1001");
		taskService.addTask(task);
		assertFalse(taskService.tasks.isEmpty());
		assertEquals(1, taskService.tasks.size());
	}
	
	@Test
	@DisplayName("Throw error if 2 identical ID's are added")
	void testTaskServiceAddTaskCollision() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Task task = new Task("Clean", "Please clean your room", "1001");
			taskService.addTask(task);
			Task task1 = new Task("Clean", "Please clean your room", "1001");
			taskService.addTask(task1);
		});     }
	
	@Test
	@DisplayName("Create a task, add into the list, and remove sucessfully")
	void testTaskServiceRemoveTask() {
		Task task = new Task("Clean", "Please clean your room", "1001");
		taskService.addTask(task);
		taskService.removeTask(task.getId());
		assertTrue(taskService.tasks.isEmpty());
		}
	
	@Test
	@DisplayName("Throw exception if removing task with ID that does not exist")
	void testTaskServiceRemoveTaskDoesNotExist() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Task task = new Task("Clean", "Please clean your room", "1001");
			taskService.addTask(task);
			assertFalse(taskService.tasks.isEmpty());
			taskService.removeTask("1002");
		});     }
	
	@Test
	@DisplayName("Name object does not exist")
	void testTaskServiceModifyNameIdDoesNotExist() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Task task = new Task("Clean", "Please clean your room", "1001");
			taskService.addTask(task);
			String update = "Sweep";
			taskService.modifyTaskName("1002", update);
		});     }

	@Test
	@DisplayName("Update task name")
	void testTaskServiceModifyName() {
		Task task = new Task("Clean", "Please clean your room", "1001");
		taskService.addTask(task);
		String update = "Sweep";
		taskService.modifyTaskName("1001", update);
		assertEquals(update, task.getName());
		}
	
	@Test
	@DisplayName("Description object does not exist")
	void testTaskServiceModifyDescriptionIdDoesNotExist() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Task task = new Task("Clean", "Please clean your room", "1001");
			taskService.addTask(task);
			String update = "Please sweep the floors";
			taskService.modifyTaskDescription("1002", update);
		});     }

	@Test
	@DisplayName("Update task description")
	void testTaskServiceModifyDescription() {
		Task task = new Task("Clean", "Please clean your room", "1001");
		taskService.addTask(task);
		String update = "Please sweep the floors";
		taskService.modifyTaskDescription("1001", update);
		assertEquals(update, task.getDescription());
		}
}
