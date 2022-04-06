package com.example.evaluation.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.evaluation.business.abstracts.evaluationnModels.EvaluationModelService;
import com.example.evaluation.business.abstracts.evaluationnModels.ParameterModelService;
import com.example.evaluation.business.abstracts.evaluationnModels.QuestionModelService;
import com.example.evaluation.business.abstracts.evaluationnModels.TopicModelService;
import com.example.evaluation.core.utillities.result.DataResult;
import com.example.evaluation.core.utillities.result.Result;
import com.example.evaluation.entities.concoretes.dto.evaluationModels.EvaluationModelDto;
import com.example.evaluation.entities.concoretes.evaluationnModels.EvaluationModel;
import com.example.evaluation.entities.concoretes.evaluationnModels.ParameterModel;
import com.example.evaluation.entities.concoretes.evaluationnModels.QuestionModel;
import com.example.evaluation.entities.concoretes.evaluationnModels.TopicModel;

@CrossOrigin
@RestController
@RequestMapping("/api/evaluationnmodels")
public class EvaluationnModelController {

	private EvaluationModelService evaluationModelService;
	private TopicModelService topicModelService;
	private QuestionModelService questionModelService;
	private ParameterModelService parameterModelService;

	@Autowired
	public EvaluationnModelController(EvaluationModelService evaluationModelService,
			TopicModelService topicModelService, QuestionModelService questionModelService,
			ParameterModelService parameterModelService) {
		super();
		this.evaluationModelService = evaluationModelService;
		this.topicModelService = topicModelService;
		this.questionModelService = questionModelService;
		this.parameterModelService = parameterModelService;
	}

	@GetMapping("/getEvaluationModelsByUserId")
	public DataResult<List<EvaluationModel>> getEvaluationModelsByUserId(int userId) {
		return evaluationModelService.getByUserId(userId);
	}

	@GetMapping("/getParameterModelByParameterModelId")
	public DataResult<ParameterModel> getParameterModelByParameterModelId(int parameterModelId) {
		return parameterModelService.getByParameterModelId(parameterModelId);
	}
	
	@GetMapping("/getAllParameterModel")
	public DataResult<List<ParameterModel>> getAll() {
		return parameterModelService.getAll();
	}

	@GetMapping("/getQuestionModelsByTopicId")
	public DataResult<List<QuestionModel>> getQuestionModelsByTopicId(int topicId) {
		return questionModelService.getByTopicId(topicId);
	}

	@GetMapping("/getEvaluationModelByEvaluationModelId")
	public DataResult<EvaluationModel> getEvaluationModelByEvaluationModelId(int evaluationModelId) {
		return evaluationModelService.getEvaluationWithEvaluationModelId(evaluationModelId);
	}

	@GetMapping("/getTopicModelsByEvaluationModelId")
	public DataResult<List<TopicModel>> getTopicModelsByEvaluationModelId(int evaluationModelId) {
		return topicModelService.getByEvaluationModelId(evaluationModelId);
	}

	@PostMapping("/addParameterModel")
	public Result addParameterModel(@RequestBody ParameterModel parameterModel) {
		return parameterModelService.addParameterModel(parameterModel);
	}

	@PostMapping("/addEvaluationModel")
	public Result addEvaluationModel(@RequestBody EvaluationModelDto evaluationModelDto) {
		return evaluationModelService.addEvaluationModel(evaluationModelDto);
	}
}
