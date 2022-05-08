package com.example.evaluation.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.evaluation.entities.concoretes.Session;

@Repository
public interface SessionDao extends JpaRepository<Session, Integer>{

	Session getBySessionUUID(String sessionUUID);
	
	Session findTopByOrderBySessionIdDesc();
}
