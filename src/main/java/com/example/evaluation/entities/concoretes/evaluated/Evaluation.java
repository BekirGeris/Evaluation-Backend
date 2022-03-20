package com.example.evaluation.entities.concoretes.evaluated;

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
@Table(name = "Evaluations")
public class Evaluation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int evaluationId;

    private int userId;
	
	private String evaluationName;
	
	private int parameterModelId;
}
