package com.example.evaluation.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.evaluation.business.abstracts.UserService;
import com.example.evaluation.core.utillities.result.DataResult;
import com.example.evaluation.core.utillities.result.Result;
import com.example.evaluation.entities.concoretes.User;

@CrossOrigin
@RestController
@RequestMapping("/api/users")
public class UserController {

	private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@GetMapping("/getByUserId")
	public DataResult<User> getByUserId(int userId) {
		return userService.getByUserId(userId);
	}

	@GetMapping("/getByUserWithUserNameAndPassword")
	public DataResult<User> getByEmailAndPassword(String userName, String password) {
		return userService.getByUserNameAndPassword(userName, password);
	}	
	
	@PostMapping("/addUser")
	public Result addUser(@RequestBody User user) {
		return userService.addUser(user);
	}
}
