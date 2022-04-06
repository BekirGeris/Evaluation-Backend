package com.example.evaluation.entities.concoretes.dto.evaluationModels;

import java.util.List;

import lombok.Data;

@Data
public class EvaluationModelDto {

    private int userId;
	
	private String evaluationModelName;
	
	private String decs;
	
	private int parameterModelId;
	
	private List<TopicModelDto> topicModelDaos;
}
