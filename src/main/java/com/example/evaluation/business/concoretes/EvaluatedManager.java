package com.example.evaluation.business.concoretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.evaluation.business.abstracts.evaluated.EvaluatedService;
import com.example.evaluation.business.abstracts.evaluated.EvaluationService;
import com.example.evaluation.business.abstracts.evaluated.QuestionService;
import com.example.evaluation.business.abstracts.evaluated.TopicService;
import com.example.evaluation.core.utillities.result.DataResult;
import com.example.evaluation.core.utillities.result.Result;
import com.example.evaluation.dataAccess.abstracts.evaluated.EvaluatedDao;
import com.example.evaluation.dataAccess.abstracts.evaluated.EvaluationDao;
import com.example.evaluation.dataAccess.abstracts.evaluated.QuestionDao;
import com.example.evaluation.dataAccess.abstracts.evaluated.TopicDao;
import com.example.evaluation.entities.concoretes.evaluated.Evaluated;
import com.example.evaluation.entities.concoretes.evaluated.Evaluation;
import com.example.evaluation.entities.concoretes.evaluated.Question;
import com.example.evaluation.entities.concoretes.evaluated.Topic;

@Service
public class EvaluatedManager implements EvaluationService, EvaluatedService, TopicService, QuestionService{

	private EvaluationDao evaluationDao;
	private EvaluatedDao evaluatedDao;
	private TopicDao topicDao;
	private QuestionDao questionDao;
	
	@Autowired
	public EvaluatedManager(EvaluationDao evaluationDao, EvaluatedDao evaluatedDao, TopicDao topicDao,
			QuestionDao questionDao) {
		super();
		this.evaluationDao = evaluationDao;
		this.evaluatedDao = evaluatedDao;
		this.topicDao = topicDao;
		this.questionDao = questionDao;
	}

	@Override
	public DataResult<List<Question>> getByTopicId(int topicId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result addQuestion(Question question) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result addTopic(Topic topic) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result addEvaluated(Evaluated evaluated) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<Evaluation>> getByUserId(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result addEvaluation(Evaluation evaluation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<Topic>> getByEvaluationId(int evaluationId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<Evaluated>> getEvaluatedWithEvaluationId(int evaluationId) {
		// TODO Auto-generated method stub
		return null;
	}

}
