package com.example.evaluation.entities.concoretes.dto.evaluationModels;

import com.example.evaluation.entities.concoretes.evaluationnModels.QuestionModel;

import lombok.Data;

@Data
public class QuestionModelDto {
	
	private int questionId;
	
	private float weight;
	
	private String question;
	
	public QuestionModelDto(QuestionModel questionModel) {
		this.questionId = questionModel.getQuestionId();
		this.weight = questionModel.getWeight();
		this.question = questionModel.getQuestion();
	}
}
