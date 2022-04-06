package com.example.evaluation.business.abstracts.evaluated;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example.evaluation.core.utillities.result.DataResult;
import com.example.evaluation.entities.concoretes.evaluated.Question;

@Service
public interface QuestionService {

	DataResult<List<Question>> getByTopicId(int topicId);
}
