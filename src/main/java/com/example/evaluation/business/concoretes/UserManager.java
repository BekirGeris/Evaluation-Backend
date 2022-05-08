package com.example.evaluation.business.concoretes;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.evaluation.business.abstracts.SessionService;
import com.example.evaluation.business.abstracts.UserService;
import com.example.evaluation.core.utillities.result.DataResult;
import com.example.evaluation.core.utillities.result.ErrorDataResult;
import com.example.evaluation.core.utillities.result.ErrorResult;
import com.example.evaluation.core.utillities.result.Result;
import com.example.evaluation.core.utillities.result.SuccessDataResult;
import com.example.evaluation.core.utillities.result.SuccessResult;
import com.example.evaluation.dataAccess.abstracts.SessionDao;
import com.example.evaluation.dataAccess.abstracts.UserDao;
import com.example.evaluation.entities.concoretes.Session;
import com.example.evaluation.entities.concoretes.User;

@Service
public class UserManager implements UserService, SessionService{

	private UserDao userDao;
	private SessionDao sessionDao;

	@Autowired
	public UserManager(UserDao userDao, SessionDao sessionDao) {
		super();
		this.userDao = userDao;
		this.sessionDao = sessionDao;
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

	@Override
	public DataResult<Session> getBySessionUUID(String sessionUUID) {
		return new SuccessDataResult<Session>(sessionDao.getBySessionUUID(sessionUUID), "Session Getirildi.");
	}

	@Override
	public DataResult<Session> addrandomUUID(int userId) {
		Session session = new Session(userId, UUID.randomUUID().toString());
		sessionDao.save(session);
		if (session.equals(sessionDao.findTopByOrderBySessionIdDesc())) {
			return new SuccessDataResult<Session>(session, "Session Eklendi.");
		}
		return new ErrorDataResult<Session>("Session Eklenemedi.");
	}

	@Override
	public DataResult<User> getUserBySessionUUID(String sessionUUID) {
		Session session = sessionDao.getBySessionUUID(sessionUUID);
		if (session != null) {
			User user = userDao.getByUserId(session.getUserId());
			if (user != null) {
				return new SuccessDataResult<User>(user, "User Getirildi.");
			}
			return new ErrorDataResult<User>("Bu session ile user bulunamadı.");
		}
		return new ErrorDataResult<User>("Bu session ait veri bulunamadı.");
	}

	@Override
	public Result deleteSession(String sessionUUID) {
		Session session = sessionDao.getBySessionUUID(sessionUUID);
		if (session != null) {
			sessionDao.delete(session);
		} else {
			return new ErrorResult("Session Bulunamadı.");
		}
		
		if (sessionDao.getBySessionUUID(sessionUUID) == null) {
			return new SuccessResult("Session Silindi.");
		}
		return new ErrorResult("Session Silinemedi.");
	}
}
