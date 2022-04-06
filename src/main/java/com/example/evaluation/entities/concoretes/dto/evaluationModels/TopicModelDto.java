package com.example.evaluation.entities.concoretes.dto.evaluationModels;

import java.util.List;

import lombok.Data;

@Data
public class TopicModelDto {
	
	private String topicName;
	
	private float weight;
	
	private List<QuestionModelDto> questionModelDtos;
}
