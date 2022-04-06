package com.example.evaluation.entities.concoretes.dto.evaluated;

import java.util.List;
import lombok.Data;

@Data
public class EvaluatedDto {

    private int evaluationId;
    
    private int userId;
	
    private String evaluatedFirstName;

    private String evaluatedLastName;
	
    private String evaluatedNumber;
	
    private float evaluatedPoint;
    
    private List<TopicDto> topicDtos;
}
