package com.example.evaluation.business.abstracts.evaluated;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example.evaluation.core.utillities.result.DataResult;
import com.example.evaluation.core.utillities.result.Result;
import com.example.evaluation.entities.concoretes.evaluated.Evaluation;

@Service
public interface EvaluationService {

	DataResult<List<Evaluation>> getByUserId(int userId);
	
	Result addEvaluation(Evaluation evaluation);
}
