package com.example.taskManager1.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.taskManager1.Service.TaskService;
import com.example.taskManager1.Service.UserService;

@RestController
@RequestMapping("/api/tasks")
public class TaskAssignmentController {

	@Autowired
    private TaskService taskService;
    @Autowired
    private UserService userService; 

    @PutMapping("/{id}/assign")
    public ResponseEntity<String> assignTaskToUser(@PathVariable Long id, @RequestParam Long userId) {
    	taskService.assignTaskToUser(id, userId);
        return ResponseEntity.ok("Task assigned to the user successfully");
    }
}
