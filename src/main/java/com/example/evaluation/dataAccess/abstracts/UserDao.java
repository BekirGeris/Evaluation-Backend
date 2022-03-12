package com.example.evaluation.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.evaluation.entities.concoretes.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer>{
	
	User getByUserId(int userId);
	
	User getByUserNameAndPassword(String userName, String password);
}
