package com.example.evaluation.business.abstracts.evaluated;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example.evaluation.core.utillities.result.DataResult;
import com.example.evaluation.core.utillities.result.Result;
import com.example.evaluation.entities.concoretes.dto.evaluated.EvaluatedDto;
import com.example.evaluation.entities.concoretes.evaluated.CalculateResult;
import com.example.evaluation.entities.concoretes.evaluated.Evaluated;

@Service
public interface EvaluatedService{

	DataResult<List<Evaluated>> getEvaluatedWithEvaluationId(int evaluationId);
	
	Result addEvaluatedDto(EvaluatedDto evaluatedDto);
	
	DataResult<CalculateResult> evaluationCalculate(EvaluatedDto evaluatedDto);
	
	DataResult<EvaluatedDto> getEvaluatedDtoRequest(int evaluationId);
}
