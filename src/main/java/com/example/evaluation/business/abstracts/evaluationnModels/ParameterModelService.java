package com.example.evaluation.business.abstracts.evaluationnModels;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.evaluation.core.utillities.result.DataResult;
import com.example.evaluation.core.utillities.result.Result;
import com.example.evaluation.entities.concoretes.evaluationnModels.ParameterModel;

@Service
public interface ParameterModelService {
	
	DataResult<List<ParameterModel>> getAll();

	DataResult<ParameterModel> getByParameterModelId(int parameterModelId);
	
	Result addParameterModel(ParameterModel parameterModel);
	
	DataResult<List<ParameterModel>> getByParameterModelsUserId(int userId);
}
