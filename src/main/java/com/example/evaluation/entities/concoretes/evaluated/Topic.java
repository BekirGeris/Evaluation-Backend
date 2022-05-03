package com.example.evaluation.entities.concoretes.evaluated;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.evaluation.entities.concoretes.dto.evaluated.TopicDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Topics")
public class Topic {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int topicId;
	
	private int evaluatedId;
	
	private int evaluationId;
	
	private String topicName;
	
	private float weight;

	public Topic(TopicDto topicDto) {
		super();
		this.evaluationId = topicDto.getEvaluationId();
		this.topicName = topicDto.getTopicName();
		this.weight = topicDto.getWeight();
	}
}
