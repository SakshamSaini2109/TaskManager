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
public class TaskAssignmentControllerTest {

	@Mock
    private TaskService taskService;

    @InjectMocks
    private TaskAssignmentController taskAssignmentController;

    @Test
    public void testAssignTaskToUser() {
        Long taskId = 7L;
        Long userId =2L;

        ResponseEntity<String> responseEntity = taskAssignmentController.assignTaskToUser(taskId, userId);

        assertEquals(ResponseEntity.ok("Task assigned to the user successfully"), responseEntity);

        verify(taskService, times(1)).assignTaskToUser(taskId, userId);
    }
}
