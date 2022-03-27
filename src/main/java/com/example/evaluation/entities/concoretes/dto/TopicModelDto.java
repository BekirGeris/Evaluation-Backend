package com.example.evaluation.entities.concoretes.dto;

import java.util.List;

import lombok.Data;

@Data
public class TopicModelDto {

    private int evaluationModelId;
	
	private String topicName;
	
	private float weight;
	
	private List<QuestionModelDto> questionModelDtos;
}
