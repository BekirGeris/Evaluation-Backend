package com.example.evaluation.business.abstracts.evaluationnModels;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example.evaluation.core.utillities.result.DataResult;
import com.example.evaluation.core.utillities.result.Result;
import com.example.evaluation.entities.concoretes.evaluationnModels.TopicModel;

@Service
public interface TopicModelService {

	DataResult<List<TopicModel>> getByEvaluationModelId(int evaluationModelId);
	
	Result addTopicModel(TopicModel topicModel);
}
