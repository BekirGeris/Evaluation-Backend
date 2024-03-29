package com.example.evaluation.entities.concoretes.dto.evaluated;

import java.util.ArrayList;
import java.util.List;

import com.example.evaluation.entities.concoretes.dto.evaluationModels.QuestionModelDto;
import com.example.evaluation.entities.concoretes.dto.evaluationModels.TopicModelDto;
import com.example.evaluation.entities.concoretes.evaluated.Question;
import com.example.evaluation.entities.concoretes.evaluated.Topic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TopicDto {

	private int topicId;
	
	private int evaluationId;
	
	private String topicName;
	
	private float weight;
	
	private List<QuestionDto> questionDtos;
	
	public TopicDto(Topic topic, List<Question> questions) {
		this.topicId = topic.getTopicId();
		this.evaluationId = topic.getEvaluationId();
		this.topicName = topic.getTopicName();
		this.weight = topic.getWeight();
		questionDtos = new ArrayList<QuestionDto>();
		for (Question question : questions) {
			questionDtos.add(new QuestionDto(question));
		}
	}
	
	public TopicDto(TopicModelDto topicModelDto, List<QuestionModelDto> questionModelDtos) {
		this.topicId = topicModelDto.getTopicId();
		this.evaluationId = topicModelDto.getEvaluationId();
		this.topicName = topicModelDto.getTopicName();
		this.weight = topicModelDto.getWeight();
		questionDtos = new ArrayList<QuestionDto>();
		for (QuestionModelDto questionModelDto : questionModelDtos) {
			questionDtos.add(new QuestionDto(questionModelDto));
		}
	}
}
