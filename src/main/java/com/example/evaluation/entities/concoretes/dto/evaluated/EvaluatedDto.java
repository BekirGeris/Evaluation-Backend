package com.example.evaluation.entities.concoretes.dto.evaluated;

import java.util.ArrayList;
import java.util.List;
import com.example.evaluation.entities.concoretes.evaluated.Evaluated;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EvaluatedDto {

    private int evaluationId;
    
    private int userId;
	
    private String evaluatedFirstName;

    private String evaluatedLastName;
	
    private String evaluatedNumber;
	
    private float evaluatedPoint;
    
    private String evaluatedStatus;
    
    private List<TopicDto> topicDtos;
    
	public EvaluatedDto(Evaluated evaluated) {
		this.evaluationId = evaluated.getEvaluatedId();
		this.userId = evaluated.getUserId();
		this.evaluatedFirstName = evaluated.getEvaluatedFirstName();
		this.evaluatedLastName = evaluated.getEvaluatedLastName();
		this.evaluatedNumber = evaluated.getEvaluatedNumber();
		this.evaluatedPoint = evaluated.getEvaluatedPoint();
		this.evaluatedStatus = evaluated.getEvaluatedStatus();
		topicDtos = new ArrayList<TopicDto>();
	}

}
