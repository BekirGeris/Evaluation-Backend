package com.example.evaluation.entities.concoretes.dto.evaluationModels;

import java.util.ArrayList;
import java.util.List;

import com.example.evaluation.entities.concoretes.evaluationnModels.EvaluationModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EvaluationModelDto {

	private int evaluationModelId;
	
    private int userId;
	
	private String evaluationModelName;
	
	private String decs;
	
	private int parameterModelId;
	
	private List<TopicModelDto> topicModelDtos;
	
	public EvaluationModelDto(EvaluationModel evaluationModel) {
		this.userId = evaluationModel.getUserId();
		this.evaluationModelId = evaluationModel.getEvaluationModelId();
		this.evaluationModelName = evaluationModel.getEvaluationModelName();
		this.decs = evaluationModel.getDecs();
		this.parameterModelId = evaluationModel.getParameterModelId();
		topicModelDtos = new ArrayList<TopicModelDto>();
	}
}
