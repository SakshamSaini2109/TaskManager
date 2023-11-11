package com.example.taskManager1.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.taskManager1.Service.TaskService;

@RestController
@RequestMapping("/api/tasks")
public class TaskPrioritizationController {

	@Autowired
    private TaskService taskService;

    @PutMapping("/{id}/priority")
    public ResponseEntity<String> updateTaskPriority(@PathVariable Long id, @RequestParam int priority) {
        taskService.updateTaskPriority(id, priority);
        return ResponseEntity.ok("Task priority updated successfully");
    }
}
