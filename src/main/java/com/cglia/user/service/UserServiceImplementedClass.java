
package com.cglia.user.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cglia.user.model.User;
import com.cglia.user.repository.UserRepo;

@Service
public class UserServiceImplementedClass implements UserService {
	@Autowired
	private UserRepo repo;

	@Override
	public User createUser(User u) {
		u.setCreatedBy("rahul");
		LocalDate currentDate = LocalDate.now();

		u.setCreatedDate(currentDate.toString());
		u.setCreatedDate(currentDate.toString());
		u.setModifiedBy("none");
		u.setModifiedDate("none");
		u.setStatus(1);
		return repo.save(u);
	}

	@Override
	public User retriveUser(Integer userId) {
		User user = repo.findById(userId).get();
		if (user.getStatus() == 1) {
			return user;
		} else {
			return null;
		}
	}

	@Override
	public User updateUser(User u, Integer userId) {
		User oldUser = repo.findById(userId).get();
		if (oldUser.getStatus() == 1) {
			if (u.getUserName() != null) {
				oldUser.setUserName(u.getUserName());
			}
			if (u.getMobileNumber() != null) {
				oldUser.setMobileNumber(u.getMobileNumber());
			}
			if (u.getEmail() != null) {
				oldUser.setEmail(u.getEmail());
			}
			if (u.getPassword() != null) {
				oldUser.setPassword(u.getPassword());
			}
			if (u.getAddress() != null) {
				oldUser.setAddress(u.getAddress());
			}
			oldUser.setModifiedBy("raju");
			LocalDate currentDate = LocalDate.now();
			oldUser.setModifiedDate(currentDate.toString());
			return repo.save(oldUser);
		} else {
			return null;
		}
	}

	@Override
	public User deleteUser(Integer userId) {
		User oldUser = repo.findById(userId).get();
		if (oldUser.getStatus() == 1) {
			oldUser.setStatus(0);

			return repo.save(oldUser);
		} else {
			return null;
		}
	}

	@Override
	public List<User> getAllUsers() {

		List<User> li = repo.findAll();
		List<User> users = new ArrayList<>();
		for (User user : li) {
			if (user.getStatus() == 1) {
				users.add(user);
			}
		}

		return users;
	}

	@Override
	public List<User> retriveUserByName(String userName) {
	
		
			return repo.findByUserName(userName);
		}
	}


