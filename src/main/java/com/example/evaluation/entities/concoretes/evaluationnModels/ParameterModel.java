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
	
	private int userId;
	
	private String parameterModelName;
	
	private float poor1;
	
	private float poor2;
	
	private float poor3;
	
	private float poor4;
	
	private float unsatisfactory1;
	
	private float unsatisfactory2;
	
	private float unsatisfactory3;
	
	private float unsatisfactory4;
	
	private float average1;
	
	private float average2;
	
	private float average3;
	
	private float average4;
	
	private float good1;
	
	private float good2;
	
	private float good3;
	
	private float good4;
	
	private float excellent1;
	
	private float excellent2;
	
	private float excellent3;
	
	private float excellent4;
	
	public void changeFormat() {
		this.poor1 /= 20;
		this.poor2 /= 20;
		this.poor3 /= 20;
		this.poor4 /= 20;
		this.unsatisfactory1 /= 20;
		this.unsatisfactory2 /= 20;
		this.unsatisfactory3 /= 20;
		this.unsatisfactory4 /= 20;
		this.average1 /= 20;
		this.average2 /= 20;
		this.average3 /= 20;
		this.average4 /= 20;
		this.good1 /= 20;
		this.good2 /= 20;
		this.good3 /= 20;
		this.good4 /= 20;
		this.excellent1 /= 20;
		this.excellent2 /= 20;
		this.excellent3 /= 20;
		this.excellent4 /= 20;
	}
	
}
