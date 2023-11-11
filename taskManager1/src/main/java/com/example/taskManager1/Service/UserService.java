package com.example.taskManager1.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.taskManager1.Entity.User;
import com.example.taskManager1.Repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	public User getUserById(Long id) {
		return userRepository.findUserById(id);
	}
	
	public User createUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}
	
	public User updateUser(Long id, User updatedUser) {
		User existingUser= getUserById(id);
		
		existingUser.setUsername(updatedUser.getUsername());
		existingUser.setPassword(updatedUser.getPassword());
		existingUser.setRole(updatedUser.getRole());
		
		return userRepository.save(existingUser);
		
	}
	
	public void deleteUser(Long id) {
		User existingUser= getUserById(id);
		userRepository.delete(existingUser);
	}
}
