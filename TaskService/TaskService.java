/*
 * Name: Ahmet Mujanovic
 * Course: CS-320
 * Date: 12-04-2022
 * Description: Project One Task Service
 */
package task;

import java.util.ArrayList;
import java.util.List;

public class TaskService {
	
	// Creating list to hold tasks
	public List<Task> tasks = new ArrayList<Task>();
	
	// Finding task by ID
	public Task findTask(String Id) {
		for (Task task : tasks) {
			if (task.getId() == Id) {
				return task;
			}
		}
		throw new IllegalArgumentException("No object with that ID exists");
	}
	
	// Checking if task exists
	public void taskExistsCheck(Task p_task) {
		for(Task task : tasks) {
			if (task.getId() == p_task.getId()) {
				throw new IllegalArgumentException("ID already exists");
			}
		}
	}
	
	public void addTask(Task p_task) {
		taskExistsCheck(p_task);
		tasks.add(p_task);
	}
	
	public void removeTask(String Id) {
		tasks.remove(findTask(Id));
	}
	
	public void modifyTaskName(String Id, String Name) {
		if (findTask(Id).getName() != Name) {
			findTask(Id).setName(Name);
		}
	}
	
	public void modifyTaskDescription(String Id, String Description) {
		if (findTask(Id).getDescription() != Description) {
			findTask(Id).setDescription(Description);
		}
	}
}
