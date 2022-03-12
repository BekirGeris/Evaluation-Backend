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
@Table(name = "RaterModels")
public class RaterModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int raterId;
    
    private int evaluationModelId;
	
	private float raterName;
	
	private float weight;
	
}
