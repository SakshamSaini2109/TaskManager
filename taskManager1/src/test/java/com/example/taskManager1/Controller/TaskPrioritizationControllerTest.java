package com.example.taskManager1.Controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.example.taskManager1.Service.TaskService;

@SpringBootTest
public class TaskPrioritizationControllerTest {

	@Mock
    private TaskService taskService;

    @InjectMocks
    private TaskPrioritizationController taskPrioritization;

    @Test
    public void testUpdateTaskPriority() {
        // Specify the task ID and priority
        Long taskId = 7L;
        int updatedPriority = 3;

        ResponseEntity<String> responseEntity = taskPrioritization.updateTaskPriority(taskId, updatedPriority);

        assertEquals(ResponseEntity.ok("Task priority updated successfully"), responseEntity);

        verify(taskService, times(1)).updateTaskPriority(taskId, updatedPriority);
    }
}
