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
@Table(name = "EvaluationModels")
public class EvaluationModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int evaluationModelId;
	
    private int userId;
	
	private String evaluationModelName;
	
	private String decs;
	
	private int parameterModelId;
}
