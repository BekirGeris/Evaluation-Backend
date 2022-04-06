package com.example.evaluation.entities.concoretes.dto.evaluated;

import java.util.List;

import lombok.Data;

@Data
public class TopicDto {

	private String topicName;
	
	private float weight;
	
	private List<QuestionDto> questionDtos;
}
