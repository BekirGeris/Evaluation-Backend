package com.example.evaluation.entities.concoretes.evaluationnModels;

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
@Table(name = "QuestionModels")
public class QuestionModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int questionId;
    
    private int raterId;
	
	private float weight;
	
	private String question;
}
