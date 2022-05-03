package com.example.evaluation.entities.concoretes.dto.evaluationModels;

import com.example.evaluation.entities.concoretes.evaluationnModels.QuestionModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionModelDto {
	
	private int questionId;
	
	private int topicId;
	
	private float weight;
	
	private String question;
	
	public QuestionModelDto(QuestionModel questionModel) {
		this.topicId = questionModel.getTopicId();
		this.questionId = questionModel.getQuestionId();
		this.weight = questionModel.getWeight();
		this.question = questionModel.getQuestion();
	}
}
