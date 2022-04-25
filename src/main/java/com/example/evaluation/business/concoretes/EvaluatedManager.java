package com.example.evaluation.business.concoretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.evaluation.business.abstracts.evaluated.EvaluatedService;
import com.example.evaluation.business.abstracts.evaluated.QuestionService;
import com.example.evaluation.business.abstracts.evaluated.TopicService;
import com.example.evaluation.core.utillities.result.DataResult;
import com.example.evaluation.core.utillities.result.Result;
import com.example.evaluation.core.utillities.result.SuccessDataResult;
import com.example.evaluation.core.utillities.result.SuccessResult;
import com.example.evaluation.dataAccess.abstracts.evaluated.EvaluatedDao;
import com.example.evaluation.dataAccess.abstracts.evaluated.QuestionDao;
import com.example.evaluation.dataAccess.abstracts.evaluated.TopicDao;
import com.example.evaluation.entities.concoretes.dto.evaluated.EvaluatedDto;
import com.example.evaluation.entities.concoretes.evaluated.Evaluated;
import com.example.evaluation.entities.concoretes.evaluated.Question;
import com.example.evaluation.entities.concoretes.evaluated.Topic;

@Service
public class EvaluatedManager implements EvaluatedService, TopicService, QuestionService{

	private EvaluatedDao evaluatedDao;
	private TopicDao topicDao;
	private QuestionDao questionDao;
	
	@Autowired
	public EvaluatedManager(EvaluatedDao evaluatedDao, TopicDao topicDao, QuestionDao questionDao) {
		super();
		this.evaluatedDao = evaluatedDao;
		this.topicDao = topicDao;
		this.questionDao = questionDao;
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
		return new SuccessDataResult<List<Evaluated>>(evaluatedDao.getByEvaluationId(evaluationId), "Değerlendirilenler  getirildi.");
	}
	
	@Override
	public Result addEvaluatedDto(EvaluatedDto evaluatedDto) {
		
	
		return new SuccessResult("Değerlendirme Modeli Eklendi.");
	}

}
