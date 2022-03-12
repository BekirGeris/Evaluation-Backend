package com.example.evaluation.business.abstracts;

import org.springframework.stereotype.Service;

import com.example.evaluation.core.utillities.result.DataResult;
import com.example.evaluation.core.utillities.result.Result;
import com.example.evaluation.entities.concoretes.User;

@Service
public interface UserService {
	
	DataResult<User> getByUserId(int userId);
	
	DataResult<User> getByUserNameAndPassword(String userName, String password);

	Result add(User user);
}
