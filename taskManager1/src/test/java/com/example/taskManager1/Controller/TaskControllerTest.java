package com.example.taskManager1.Controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.taskManager1.Entity.Task;
import com.example.taskManager1.Entity.User;
import com.example.taskManager1.Service.TaskService;

@SpringBootTest
public class TaskControllerTest {

	@Autowired
	TaskService taskService;
	
	@Autowired
	TaskController taskController;
	

	@Test
	public void testGetTask() throws Exception {
		
		User user= new User(1L,"Sachin","sachin123","User");

		 List<Task> expectedTasks = Arrays.asList(
	                new Task(1L, "Maths Project", "This task defines the implementation of Algebra", LocalDate.of(2023, 12, 21) ,4, user),
	                new Task(2L, "Chemistry Project", "This task defines the implementation of Periodic Table", LocalDate.of(2023, 12, 8) ,2, user)
	        );

		 List<Task> actualTasks = taskController.getAllTasks();


	        for (int i = 0; i < expectedTasks.size(); i++) {
	            Task expectedTask = expectedTasks.get(i);
	            Task actualTask = actualTasks.get(i);

	            assertEquals(expectedTask.getId(), actualTask.getId());
	            assertEquals(expectedTask.getTitle(),actualTask.getTitle());
	            assertEquals(expectedTask.getDescription(), actualTask.getDescription());
	            assertEquals(expectedTask.getPriority(), actualTask.getPriority());
	            assertEquals(expectedTask.getDueDate(), actualTask.getDueDate());
	        }
			}
	
	@Test
	public void testGetTaskById() throws Exception{
		User user= new User(1L,"Charlie","charlie@123","Admin");

		 Task expectedTasks =  new Task(1L, "Maths Project", "This task defines the implementation of Algebra", LocalDate.of(2023, 12, 21) ,4, user);

	     Task actualTasks = taskController.getTaskById(1L);
	        
	            assertEquals(expectedTasks.getId(), actualTasks.getId());
	            assertEquals(expectedTasks.getTitle(),actualTasks.getTitle());
	            assertEquals(expectedTasks.getDescription(), actualTasks.getDescription());
	            assertEquals(expectedTasks.getPriority(), actualTasks.getPriority());
	            assertEquals(expectedTasks.getDueDate(), actualTasks.getDueDate());
	        }
	
	@Test
	public void testCreateTask() throws Exception{
		
		User user= new User(1L,"Charlie","charlie@123","Admin");
		Task expectedTasks =  new Task(1L, "Chemistry Project", "This task defines the implementation of Periodic Table", LocalDate.of(2023, 12, 8) ,2, user);
		
		Task requestTask = new Task(null,"Chemistry Project", "This task defines the implementation of Periodic Table", LocalDate.of(2023, 12, 8) ,2, user);
		
		Task actualTask = taskController.createTask(requestTask);
		
        assertEquals(expectedTasks.getTitle(),actualTask.getTitle());
        assertEquals(expectedTasks.getDescription(), actualTask.getDescription());
        assertEquals(expectedTasks.getPriority(), actualTask.getPriority());
        assertEquals(expectedTasks.getDueDate(), actualTask.getDueDate());
	}
	
	@Test
	public void testUpdateTask() throws Exception{
		User user= new User(2L,"Sachin","sachin@789","User");
		
		Task updatedTask = new Task(4L, "Physics Project", "Detailed Physics Project", LocalDate.of(2023, 12, 21), 3, user);
		
		Task requestTask = new Task(4L, "Physics Project", "Detailed Physics Project", LocalDate.of(2023, 12, 21), 3, user);
		
		Task actualTask = taskController.updateTask(4L, requestTask);
		
		assertEquals(updatedTask.getId(),actualTask.getId());
		assertEquals(updatedTask.getTitle(),actualTask.getTitle());
        assertEquals(updatedTask.getDescription(), actualTask.getDescription());
        assertEquals(updatedTask.getPriority(), actualTask.getPriority());
        assertEquals(updatedTask.getDueDate(), actualTask.getDueDate());
	}
}
