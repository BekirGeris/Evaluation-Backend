package com.example.evaluation.business.concoretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.evaluation.business.abstracts.evaluated.EvaluatedService;
import com.example.evaluation.business.abstracts.evaluated.QuestionService;
import com.example.evaluation.business.abstracts.evaluated.TopicService;
import com.example.evaluation.core.utillities.result.DataResult;
import com.example.evaluation.core.utillities.result.ErrorDataResult;
import com.example.evaluation.core.utillities.result.ErrorResult;
import com.example.evaluation.core.utillities.result.Result;
import com.example.evaluation.core.utillities.result.SuccessDataResult;
import com.example.evaluation.core.utillities.result.SuccessResult;
import com.example.evaluation.dataAccess.abstracts.evaluated.EvaluatedDao;
import com.example.evaluation.dataAccess.abstracts.evaluated.QuestionDao;
import com.example.evaluation.dataAccess.abstracts.evaluated.TopicDao;
import com.example.evaluation.entities.concoretes.dto.evaluated.EvaluatedDto;
import com.example.evaluation.entities.concoretes.dto.evaluated.QuestionDto;
import com.example.evaluation.entities.concoretes.dto.evaluated.TopicDto;
import com.example.evaluation.entities.concoretes.dto.evaluationModels.EvaluationModelDto;
import com.example.evaluation.entities.concoretes.dto.evaluationModels.TopicModelDto;
import com.example.evaluation.entities.concoretes.evaluated.CalculateResult;
import com.example.evaluation.entities.concoretes.evaluated.Evaluated;
import com.example.evaluation.entities.concoretes.evaluated.Question;
import com.example.evaluation.entities.concoretes.evaluated.Topic;

@Service
public class EvaluatedManager implements EvaluatedService, TopicService, QuestionService{

	private EvaluatedDao evaluatedDao;
	private TopicDao topicDao;
	private QuestionDao questionDao;
	private EvaluationnModelManager evaluationnModelManager;
	
	@Autowired
	public EvaluatedManager(EvaluatedDao evaluatedDao, TopicDao topicDao, QuestionDao questionDao, EvaluationnModelManager evaluationnModelManager) {
		super();
		this.evaluatedDao = evaluatedDao;
		this.topicDao = topicDao;
		this.questionDao = questionDao;
		this.evaluationnModelManager = evaluationnModelManager;
	}

	@Override
	public DataResult<List<Question>> getByTopicId(int topicId) {
		return new SuccessDataResult<List<Question>>(questionDao.getByTopicId(topicId), "Sorular getirildi.");
	}

	@Override
	public DataResult<List<Topic>> getByEvaluationId(int evaluationId) {
		return new SuccessDataResult<List<Topic>>(topicDao.getByEvaluationId(evaluationId), "Konular getirildi.");
	}

	@Override
	public DataResult<List<Evaluated>> getEvaluatedWithEvaluationId(int evaluationId) {
		if (evaluationId == 0) {
			return new ErrorDataResult<List<Evaluated>>(null, "Evaluation id hatalı");
		}
		return new SuccessDataResult<List<Evaluated>>(evaluatedDao.getByEvaluationId(evaluationId), "Değerlendirilenler  getirildi.");
	}
	
	@Override
	public Result addEvaluatedDto(EvaluatedDto evaluatedDto) {
		if (evaluatedDao.getByEvaluatedNumber(evaluatedDto.getEvaluatedNumber()) == null) {
			
			evaluatedDto.setEvaluatedPoint(evaluationCalculate(evaluatedDto).getData().getEvaluatedPoint());
			evaluatedDao.save(new Evaluated(evaluatedDto));
			Evaluated evaluated = evaluatedDao.findTopByOrderByEvaluatedIdDesc();
			
			for (TopicDto topicDto : evaluatedDto.getTopicDtos()) {
				Topic topic = new Topic(topicDto);
				topic.setEvaluatedId(evaluated.getEvaluatedId());
				topicDao.save(topic);
				topic = topicDao.findTopByOrderByTopicIdDesc();
				for (QuestionDto questionDto : topicDto.getQuestionDtos()) {
					Question question = new Question(questionDto);
					question.setTopicId(topic.getTopicId());
					questionDao.save(question);
				}
			}
		} else {
			return new ErrorResult("Farklı bir numara ile tekrar deneyiniz.");
		}
		return new SuccessResult("Değerlendirme Eklendi.");
	}
	
	@Override
	public DataResult<CalculateResult> evaluationCalculate(EvaluatedDto evaluatedDto) {
		System.out.print(evaluatedDto.toString());
		
		float cal = 0;
		float questionAnsver = 0;
		
		for (TopicDto topicDto : evaluatedDto.getTopicDtos()) {
			for (QuestionDto questionDto : topicDto.getQuestionDtos()) {
				 questionAnsver += questionDto.getWeight() + questionDto.getAnswer();
			}
			cal += topicDto.getWeight() * questionAnsver;
		}
		
		return new SuccessDataResult<CalculateResult>(new CalculateResult(cal), "Hesaplama yapıldı.");
	}

	@Override
	public DataResult<EvaluatedDto> getEvaluatedDtoRequest(int evaluationId) {
		EvaluationModelDto evaluationModelDto = evaluationnModelManager.getEvaluationWithEvaluationModelId(evaluationId).getData();
		
		EvaluatedDto evaluatedDto = new EvaluatedDto(); 
		evaluatedDto.setTopicDtos(new ArrayList<>());
		
		for (TopicModelDto topicModelDto : evaluationModelDto.getTopicModelDtos()) {
			evaluatedDto.getTopicDtos().add(new TopicDto(topicModelDto, topicModelDto.getQuestionModelDtos()));
		}
		return new SuccessDataResult<EvaluatedDto>(evaluatedDto, "EvaluatedDto Request getirildi.");
	}
}
