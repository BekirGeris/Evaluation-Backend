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
@Table(name = "ParameterModels")
public class ParameterModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int parameterModelId;
	
	private String parameterModelName;
	
	private int poor1;
	
	private int poor2;
	
	private int poor3;
	
	private int poor4;
	
	private int unsatisfactory1;
	
	private int unsatisfactory2;
	
	private int unsatisfactory3;
	
	private int unsatisfactory4;
	
	private int average1;
	
	private int average2;
	
	private int average3;
	
	private int average4;
	
	private int good1;
	
	private int good12;
	
	private int good13;
	
	private int good14;
	
	private int excellent1;
	
	private int excellent2;
	
	private int excellent3;
	
	private int excellent4;
	
}
