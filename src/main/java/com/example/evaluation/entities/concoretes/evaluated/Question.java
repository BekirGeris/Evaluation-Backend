package com.example.evaluation.entities.concoretes.evaluated;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.evaluation.entities.concoretes.dto.evaluated.QuestionDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Questions")
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int questionId;
    
    private int topicId;
	
	private float weight;
	
	private String question;
	
    private int answer;

	public Question(QuestionDto questionDto) {
		super();
		this.topicId = questionDto.getTopicId();
		this.weight = questionDto.getWeight();
		this.question = questionDto.getQuestion();
		this.answer = questionDto.getAnswer();
	}
}
