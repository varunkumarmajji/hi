
package com.cglia.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cglia.user.model.User;
import com.cglia.user.service.UserService;

@RestController
@RequestMapping("/com/cglia/user")
public class UserController {
	@Autowired
	private UserService service;

	@PostMapping("/save")
	public String addUser(@RequestBody User u) {
		User user = service.createUser(u);
		String msg = null;
		if (user != null) {
			msg = "new user created successfully";
		} else {
			msg = "user creation failed";
		}

		return msg;

	}

	@GetMapping("/get/{userId}")
	public User getOneUser(@PathVariable Integer userId) {
	
		return service.retriveUser(userId);

	}

	@PutMapping("/update/{userId}")
	public String updateUser(@RequestBody User u, @PathVariable Integer userId) {
		User user = service.updateUser(u, userId);
		String msg = null;
		if (user != null) {
			msg = "user details modified successfully";
		} else {
			msg = "user modification failed";
		}

		return msg;

	}

	@GetMapping("/getall")
	public List<User> getAllUsers() {
		return service.getAllUsers();

	}

	@DeleteMapping("/delete/{userId}")
	public String deleteUser(@PathVariable Integer userId) {
		User user = service.deleteUser(userId);
		String msg = null;
		if (user != null) {
			msg = "user deleted successfully";
		} else {
			msg = "user deletion failed";
		}

		return msg;
	}
	@GetMapping("/getbyname/{userName}")
	public List<User> getOneUserByName(@PathVariable String userName) {
	
		return service.retriveUserByName(userName);

	}

}
