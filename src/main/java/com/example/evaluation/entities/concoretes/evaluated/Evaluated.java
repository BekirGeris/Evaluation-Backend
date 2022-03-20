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
@Table(name = "Evaluateds")
public class Evaluated {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int evaluatedId;
	
    private int evaluationId;
	
    private String evaluatedFirstName;

    private String evaluatedLastName;
	
    private String evaluatedNumber;
	
    private float evaluatedPoint;
}
