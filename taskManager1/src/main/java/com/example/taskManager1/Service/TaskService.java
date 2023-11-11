package com.example.taskManager1.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.taskManager1.Entity.Task;
import com.example.taskManager1.Entity.User;
import com.example.taskManager1.Repository.TaskRepository;
import com.example.taskManager1.Repository.UserRepository;

@Service
public class TaskService {

	@Autowired
    private TaskRepository taskRepository;
	
	@Autowired
	private UserRepository userRepository;

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }
    
    @Cacheable(value="taskCache", key="'TaskCache'+#id")
    public Task getTaskById(Long id) {
        return taskRepository.findTaskById(id);
               // .orElseThrow(() -> new TaskNotFoundException("Task not found with id: " + id));
    }
 
    public Task createTask(Task task) {
        // You can add validation logic here, e.g., checking due date or priority
        return taskRepository.save(task);
    }

    public Task updateTask(Long id, Task updatedTask) {
        Task existingTask = getTaskById(id);

        existingTask.setTitle(updatedTask.getTitle());
        existingTask.setDescription(updatedTask.getDescription());
        existingTask.setDueDate(updatedTask.getDueDate());
        existingTask.setPriority(updatedTask.getPriority());
        
        

        return taskRepository.save(existingTask);
    }

    public void deleteTask(Long id) {
        Task existingTask = getTaskById(id);
        taskRepository.delete(existingTask);
    }
    
    public void updateTaskPriority(Long taskId, int priority) {
        Task task = taskRepository.findTaskById(taskId);
        		//.orElseThrow(() -> new TaskNotFoundException("Task not found with id: " + taskId));
        task.setPriority(priority);
        taskRepository.save(task);
    }

	public void assignTaskToUser(Long id, Long userId) {
		
		Task task = taskRepository.findTaskById(id);
//      //.orElseThrow(() -> new TaskNotFoundException("Task not found with id: " + taskId));
      User user = userRepository.findUserById(userId);
      //.orElseThrow(() -> new UserNotFoundException("User not found with id: " + userId));
      task.setAssignedUser(user);
      taskRepository.save(task);
		
	}
}
