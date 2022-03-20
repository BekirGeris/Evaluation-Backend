package com.example.evaluation.business.abstracts.evaluated;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example.evaluation.core.utillities.result.DataResult;
import com.example.evaluation.core.utillities.result.Result;
import com.example.evaluation.entities.concoretes.evaluated.Topic;

@Service
public interface TopicService {

	DataResult<List<Topic>> getByEvaluationId(int evaluationId);
	
	Result addTopic(Topic topic);
}
