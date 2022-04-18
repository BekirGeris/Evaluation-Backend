package com.example.evaluation.entities.concoretes.dto.evaluationModels;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.example.evaluation.entities.concoretes.evaluationnModels.EvaluationModel;
import com.example.evaluation.entities.concoretes.evaluationnModels.QuestionModel;
import com.example.evaluation.entities.concoretes.evaluationnModels.TopicModel;

import lombok.Data;

@Data
public class EvaluationModelDto {

    private int userId;
    
    private int evaluationModelId;
	
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
