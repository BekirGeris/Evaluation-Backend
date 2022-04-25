package com.example.evaluation.entities.concoretes.dto.evaluated;

import com.example.evaluation.entities.concoretes.evaluated.Question;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionDto {
	
	private int questionId;
	
	private int topicId;
	
	private float weight;
	
	private String question;
	
    private int answer;
    
	public QuestionDto(Question question) {
		this.questionId = question.getQuestionId();
		this.weight = question.getWeight();
		this.question = question.getQuestion();
		this.answer = question.getAnswer();
	}
}
