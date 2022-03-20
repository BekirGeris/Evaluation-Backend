package com.example.evaluation.business.concoretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.evaluation.business.abstracts.UserService;
import com.example.evaluation.core.utillities.result.DataResult;
import com.example.evaluation.core.utillities.result.ErrorDataResult;
import com.example.evaluation.core.utillities.result.ErrorResult;
import com.example.evaluation.core.utillities.result.Result;
import com.example.evaluation.core.utillities.result.SuccessDataResult;
import com.example.evaluation.core.utillities.result.SuccessResult;
import com.example.evaluation.dataAccess.abstracts.UserDao;
import com.example.evaluation.entities.concoretes.User;

@Service
public class UserManager implements UserService{

	private UserDao userDao;

	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public DataResult<User> getByUserId(int userId) {
		User user = userDao.getByUserId(userId);
		if(user != null) {
			return new SuccessDataResult<User>(user, "Kullanıcı getirildi");
		}
		return new ErrorDataResult<User>(null, "Kullanıcı Bulunamadı.");
	}

	@Override
	public DataResult<User> getByUserNameAndPassword(String userName, String password) {
		User user = userDao.getByUserNameAndPassword(userName, password);
		if(user != null) {
			return new SuccessDataResult<User>(user, "Kullanıcı getirildi");
		}
		return new ErrorDataResult<User>(null, "Kullanıcı Bulunamadı.");
	}
	
	@Override
	public Result addUser(User user) {
		User existingUser = userDao.getByUserNameAndPassword(user.getUserName(), user.getPassword());
		if(existingUser != null) {
			return new ErrorResult("Kullanıcı zaten mevcut.");
		}
		userDao.save(user);
		return new SuccessResult("Kullanıcı eklendi.");
	}
}
