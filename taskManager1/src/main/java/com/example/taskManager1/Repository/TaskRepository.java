package com.example.taskManager1.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.taskManager1.Entity.Task;
import com.example.taskManager1.Entity.User;

public interface TaskRepository extends JpaRepository<Task, Long>{

	 List<Task> findByAssignedUser(User user);
		
	 Task findTaskById(Long id);
}
