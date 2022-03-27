package com.example.evaluation.business.abstracts.evaluationnModels;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example.evaluation.core.utillities.result.DataResult;
import com.example.evaluation.core.utillities.result.Result;
import com.example.evaluation.entities.concoretes.dto.EvaluationModelDto;
import com.example.evaluation.entities.concoretes.evaluationnModels.EvaluationModel;

@Service
public interface EvaluationModelService {

	DataResult<List<EvaluationModel>> getByUserId(int userId);
	
	DataResult<EvaluationModel> getEvaluationWithEvaluationModelId(int evaluationModelId);

	Result addEvaluationModel(EvaluationModelDto evaluationModelDto);
}
