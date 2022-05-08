package com.example.evaluation.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.evaluation.business.abstracts.SessionService;
import com.example.evaluation.business.abstracts.UserService;
import com.example.evaluation.core.utillities.result.DataResult;
import com.example.evaluation.core.utillities.result.ErrorDataResult;
import com.example.evaluation.core.utillities.result.ErrorResult;
import com.example.evaluation.core.utillities.result.Result;
import com.example.evaluation.core.utillities.result.SuccessDataResult;
import com.example.evaluation.core.utillities.result.SuccessResult;
import com.example.evaluation.entities.concoretes.Session;
import com.example.evaluation.entities.concoretes.User;

@CrossOrigin
@RestController
@RequestMapping("/api/users")
public class UserController {

	private UserService userService;
	private SessionService sessionService;

	@Autowired
	public UserController(UserService userService, SessionService sessionService) {
		super();
		this.userService = userService;
		this.sessionService = sessionService;
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
	
	@GetMapping("/getBySessionUUID")
	public DataResult<Session> getBySessionUUID(String sessionUUID) {
		return sessionService.getBySessionUUID(sessionUUID);
	}

	@PostMapping("/addSession")
	public Result addrandomUUID(int userId) {
		return sessionService.addrandomUUID(userId);
	}
	
	@GetMapping("/getUserBySessionUUID")
	public DataResult<User> getUserBySessionUUID(String sessionUUID) {
		return userService.getUserBySessionUUID(sessionUUID);
	}
	
	@PostMapping("/deleteSession")
	public Result deleteSession(String sessionUUID) {
		return sessionService.deleteSession(sessionUUID);
	}
}
