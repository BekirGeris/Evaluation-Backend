package com.example.evaluation.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.evaluation.business.abstracts.evaluated.EvaluatedService;
import com.example.evaluation.business.abstracts.evaluated.QuestionService;
import com.example.evaluation.business.abstracts.evaluated.TopicService;
import com.example.evaluation.core.utillities.result.DataResult;
import com.example.evaluation.core.utillities.result.Result;
import com.example.evaluation.entities.concoretes.dto.evaluated.EvaluatedDto;
import com.example.evaluation.entities.concoretes.evaluated.Evaluated;
import com.example.evaluation.entities.concoretes.evaluated.Question;
import com.example.evaluation.entities.concoretes.evaluated.Topic;

@CrossOrigin
@RestController
@RequestMapping("/api/evaluated")
public class EvaluatedController {

	private EvaluatedService evaluatedService;
	private TopicService topicService;
	private QuestionService questionService;
	
	@Autowired
	public EvaluatedController(EvaluatedService evaluatedService, TopicService topicService,
			QuestionService questionService) {
		super();
		this.evaluatedService = evaluatedService;
		this.topicService = topicService;
		this.questionService = questionService;
	}
	
	@GetMapping("/getByTopicId")
	public DataResult<List<Question>> getByTopicId(int topicId) {
		return questionService.getByTopicId(topicId);
	}

	@GetMapping("/getByEvaluationId")
	public DataResult<List<Topic>> getByEvaluationId(int evaluationId) {
		return topicService.getByEvaluationId(evaluationId);
	}

	@GetMapping("/getEvaluatedWithEvaluationId")
	public DataResult<List<Evaluated>> getEvaluatedWithEvaluationId(int evaluationId) {
		return evaluatedService.getEvaluatedWithEvaluationId(evaluationId);
	}
	
	@PostMapping("/addEvaluatedDto")
	public Result addEvaluatedDto(@RequestBody EvaluatedDto evaluatedDto) {
		return evaluatedService.addEvaluatedDto(evaluatedDto);
	}
	
}
