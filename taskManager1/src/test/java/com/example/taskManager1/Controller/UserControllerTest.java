package com.example.taskManager1.Controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.taskManager1.Entity.User;
import com.example.taskManager1.Service.UserService;

@SpringBootTest
public class UserControllerTest {

	@Autowired
	UserService userService;
	
	@Autowired
	UserController userController;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Test
	public void testGetUsers() throws Exception{
		
		List<User> expectedUsers= Arrays.asList(
				new User(1L,"Soldier","soldier@231","User"),
				new User(2L,"Sam","sam@123","Admin"));
		
		List<User> actualUsers= userController.getAllUsers();
		
		for (int i = 0; i < expectedUsers.size(); i++) {
            User expectedUser = expectedUsers.get(i);
            User actualUser = actualUsers.get(i);

            assertEquals(expectedUser.getId(), actualUser.getId());
            assertEquals(expectedUser.getUsername(),actualUser.getUsername());
            assertEquals(expectedUser.getRole(), actualUser.getRole());
        }
	}
	
	@Test
	public void testGetUserById() throws Exception{
		
		User expectedUsers = new User(1L,"Soldier","soldier@231","User");
		
		User actualUsers= userController.getUserById(1L);
		
		assertEquals(expectedUsers.getId(), actualUsers.getId());
        assertEquals(expectedUsers.getUsername(),actualUsers.getUsername());
        assertEquals(expectedUsers.getRole(), actualUsers.getRole());
	}
	
	@Test
	public void testCreateUser() throws Exception{
		
		User expectedUsers = new User(4L,"Harry","harry@234","Admin");
		
		User requestedUser = new User(null,"Harry","harry@234","Admin");
		
		User actualUsers= userController.createUser(requestedUser);
		
        assertEquals(expectedUsers.getUsername(),actualUsers.getUsername());
        assertEquals(expectedUsers.getRole(), actualUsers.getRole());
		
	}
	
	@Test
	public void testUpdateTask() throws Exception{
		User expectedUsers = new User(7L,"Hardik","hardik@567","User");
		
		User requestedUser= new User(7L,"Hardik","hardik@567","User");
		
		User actualUsers= userController.updateUser(7l, requestedUser);
		
		assertEquals(expectedUsers.getId(), actualUsers.getId());
        assertEquals(expectedUsers.getUsername(),actualUsers.getUsername());
        assertEquals(expectedUsers.getRole(), actualUsers.getRole());
		
	}
}
