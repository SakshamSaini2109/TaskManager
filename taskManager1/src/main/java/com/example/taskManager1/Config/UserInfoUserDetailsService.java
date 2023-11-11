package com.example.taskManager1.Config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.taskManager1.Entity.User;
import com.example.taskManager1.Repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;

@Component
public class UserInfoUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<User> user=userRepository.findByUsername(username);
		
		return user.map(UserInfoUserDetails::new).orElseThrow(()->new EntityNotFoundException("user not found"+username));

	}

}
