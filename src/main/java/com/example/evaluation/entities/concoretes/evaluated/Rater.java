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
@Table(name = "Raters")
public class Rater {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int raterId;
	
    private int evaluatedId;
	
	private float raterName;
	
	private float weight;
	
}
