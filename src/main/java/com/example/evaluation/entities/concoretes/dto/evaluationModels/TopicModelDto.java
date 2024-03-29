package com.example.evaluation.entities.concoretes.dto.evaluationModels;

import java.util.ArrayList;
import java.util.List;

import com.example.evaluation.entities.concoretes.evaluationnModels.QuestionModel;
import com.example.evaluation.entities.concoretes.evaluationnModels.TopicModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TopicModelDto {
	
	private int topicId;
	
	private int evaluationId;
	
	private String topicName;
	
	private float weight;
	
	private List<QuestionModelDto> questionModelDtos;
	
	public TopicModelDto(TopicModel topicModel, List<QuestionModel> questionModels) {
		this.topicId = topicModel.getTopicId();
		this.evaluationId = topicModel.getEvaluationModelId();
		this.topicName = topicModel.getTopicName();
		this.weight = topicModel.getWeight();
		questionModelDtos = new ArrayList<QuestionModelDto>();
		for (QuestionModel questionModel : questionModels) {
			questionModelDtos.add(new QuestionModelDto(questionModel));
		}
	}
}
