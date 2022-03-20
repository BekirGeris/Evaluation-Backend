package com.example.evaluation.business.abstracts.evaluationnModels;

import org.springframework.stereotype.Service;

import com.example.evaluation.core.utillities.result.DataResult;
import com.example.evaluation.core.utillities.result.Result;
import com.example.evaluation.entities.concoretes.evaluationnModels.ParameterModel;

@Service
public interface ParameterModelService {

	DataResult<ParameterModel> getByParameterModelId(int parameterModelId);
	
	Result addParameterModel(ParameterModel parameterModel);
}
