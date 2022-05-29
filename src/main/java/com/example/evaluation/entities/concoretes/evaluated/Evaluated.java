package com.example.evaluation.entities.concoretes.evaluated;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.evaluation.entities.concoretes.dto.evaluated.EvaluatedDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Evaluateds")
public class Evaluated {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int evaluatedId;
	
    private int evaluationId;
    
    private int userId;
	
    private String evaluatedFirstName;

    private String evaluatedLastName;
	
    private String evaluatedNumber;
	
    private float evaluatedPoint;
    
    private String evaluatedStatus;

	public Evaluated(EvaluatedDto evaluatedDto) {
		super();
		this.evaluationId = evaluatedDto.getEvaluationId();
		this.userId = evaluatedDto.getUserId();
		this.evaluatedFirstName = evaluatedDto.getEvaluatedFirstName();
		this.evaluatedLastName = evaluatedDto.getEvaluatedLastName();
		this.evaluatedNumber = evaluatedDto.getEvaluatedNumber();
		this.evaluatedPoint = evaluatedDto.getEvaluatedPoint();
		this.evaluatedStatus = evaluatedDto.getEvaluatedStatus();
	}
}
