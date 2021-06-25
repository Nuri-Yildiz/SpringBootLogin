package com.loginapp.springjwt.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loginapp.springjwt.models.Role;
import com.loginapp.springjwt.models.User;
import com.loginapp.springjwt.repository.RoleRepository;
import com.loginapp.springjwt.repository.UserRepository;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/admin")
public class AdminController {

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;
	
	@GetMapping("/users")
	 public List<User> users() {
		List<User> listUsers = userRepository.findAll();
		return listUsers;	
	}
	
	@GetMapping("/roles")
	 public List<Role> roles() {
		List<Role> listRoles = roleRepository.findAll();
		return listRoles;	
	}
	@PutMapping("/updateRole")
	public User updateUser(@RequestBody User updatedUser) {
		User user = userRepository.findByUsername(updatedUser.getUsername()).get();
		user.setRoles(updatedUser.getRoles());
		//user.setDescription(updatedUser.getDescription());
		userRepository.save(user);
		return user;
	}
}
