package com.example.evaluation.entities.concoretes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="sessions")
public class Session {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sessionId;
	
	private int userId;
	
	private String sessionUUID;

	public Session(int userId, String sessionUUID) {
		super();
		this.userId = userId;
		this.sessionUUID = sessionUUID;
	}
}
