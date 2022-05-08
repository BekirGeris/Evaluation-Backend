package com.example.evaluation.business.abstracts;

import org.springframework.stereotype.Service;

import com.example.evaluation.core.utillities.result.DataResult;
import com.example.evaluation.core.utillities.result.Result;
import com.example.evaluation.entities.concoretes.Session;

@Service
public interface SessionService {

	DataResult<Session> getBySessionUUID(String sessionUUID);
	
	DataResult<Session> addrandomUUID(int userId);
	
	Result deleteSession(String sessionUUID);
}
