package com.example.evaluation.business.abstracts.evaluationnModels;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example.evaluation.core.utillities.result.DataResult;
import com.example.evaluation.entities.concoretes.evaluationnModels.QuestionModel;

@Service
public interface QuestionModelService {

	DataResult<List<QuestionModel>> getByTopicId(int topicId);

}
