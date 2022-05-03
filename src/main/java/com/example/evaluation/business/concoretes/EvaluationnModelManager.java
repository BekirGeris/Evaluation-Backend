package com.example.evaluation.business.concoretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.evaluation.business.abstracts.evaluationnModels.EvaluationModelService;
import com.example.evaluation.business.abstracts.evaluationnModels.ParameterModelService;
import com.example.evaluation.business.abstracts.evaluationnModels.QuestionModelService;
import com.example.evaluation.business.abstracts.evaluationnModels.TopicModelService;
import com.example.evaluation.core.utillities.result.DataResult;
import com.example.evaluation.core.utillities.result.ErrorResult;
import com.example.evaluation.core.utillities.result.Result;
import com.example.evaluation.core.utillities.result.SuccessDataResult;
import com.example.evaluation.core.utillities.result.SuccessResult;
import com.example.evaluation.dataAccess.abstracts.evaluationnModels.EvaluationModelDao;
import com.example.evaluation.dataAccess.abstracts.evaluationnModels.ParameterModelDao;
import com.example.evaluation.dataAccess.abstracts.evaluationnModels.QuestionModelDao;
import com.example.evaluation.dataAccess.abstracts.evaluationnModels.TopicModelDao;
import com.example.evaluation.entities.concoretes.dto.evaluationModels.EvaluationModelDto;
import com.example.evaluation.entities.concoretes.dto.evaluationModels.QuestionModelDto;
import com.example.evaluation.entities.concoretes.dto.evaluationModels.TopicModelDto;
import com.example.evaluation.entities.concoretes.evaluationnModels.EvaluationModel;
import com.example.evaluation.entities.concoretes.evaluationnModels.ParameterModel;
import com.example.evaluation.entities.concoretes.evaluationnModels.QuestionModel;
import com.example.evaluation.entities.concoretes.evaluationnModels.TopicModel;

@Service
public class EvaluationnModelManager implements EvaluationModelService, ParameterModelService, TopicModelService, QuestionModelService{

	private EvaluationModelDao evaluationModelDao;
	private ParameterModelDao parameterModelDao;
	private TopicModelDao topicModelDao;
	private QuestionModelDao questionModelDao;
	
	@Autowired
	public EvaluationnModelManager(EvaluationModelDao evaluationModelDao, ParameterModelDao parameterModelDao,
			TopicModelDao topicModelDao, QuestionModelDao questionModelDao) {
		super();
		this.evaluationModelDao = evaluationModelDao;
		this.parameterModelDao = parameterModelDao;
		this.topicModelDao = topicModelDao;
		this.questionModelDao = questionModelDao;
	}

	@Override
	public DataResult<List<EvaluationModel>> getByUserId(int userId) {
		return new SuccessDataResult<List<EvaluationModel>>(evaluationModelDao.getByUserId(userId), "Değerlendirme Modelleri Getirildi.");
	}

	@Override
	public DataResult<ParameterModel> getByParameterModelId(int parameterModelId) {
		return new SuccessDataResult<ParameterModel>(parameterModelDao.getByParameterModelId(parameterModelId), "Parametreler Getirildi.");
	}

	@Override
	public DataResult<List<QuestionModel>> getByTopicId(int topicId) {
		return new SuccessDataResult<List<QuestionModel>>(questionModelDao.getByTopicId(topicId), "Ana dala ait sorular getirildi.");
	}

	@Override
	public DataResult<EvaluationModelDto> getEvaluationWithEvaluationModelId(int evaluationModelId) {
		EvaluationModelDto evaluationModelDto = new EvaluationModelDto(evaluationModelDao.getByEvaluationModelId(evaluationModelId));

		for (TopicModel topicModel : topicModelDao.getByEvaluationModelId(evaluationModelId)) {
			List<QuestionModel> questionModels = questionModelDao.getByTopicId(topicModel.getTopicId());
			evaluationModelDto.getTopicModelDtos().add(new TopicModelDto(topicModel, questionModels));
		}

		return new SuccessDataResult<EvaluationModelDto>(evaluationModelDto, "Değerlendirme Modeli Getirildi.");
	}

	@Override
	public DataResult<List<TopicModel>> getByEvaluationModelId(int evaluationModelId) {
		return new SuccessDataResult<List<TopicModel>>(topicModelDao.getByEvaluationModelId(evaluationModelId), "Değerlendirilmeye Ait sorular Getirildi.");
	}

	@Override
	public DataResult<List<ParameterModel>> getAll() {
		return new SuccessDataResult<List<ParameterModel>>(parameterModelDao.findAll(), "Değerlendirilmeye Ait sorular Getirildi.");
	}
	
	@Override
	public DataResult<List<ParameterModel>> getByParameterModelsUserId(int userId) {
		return new SuccessDataResult<List<ParameterModel>>(parameterModelDao.getByUserId(userId), "Parameter modeller getirildi.");
	}
	
	@Override
	public Result addParameterModel(ParameterModel parameterModel) {
		if(parameterModelDao.getByParameterModelNameAndUserId(parameterModel.getParameterModelName(), parameterModel.getUserId()) != null) {
			return new ErrorResult("Bu ada sahip bir parametre modeli zaten var.");
		}
		
		parameterModelDao.save(parameterModel);
		return new SuccessResult("Parametreler Eklendi.");
	}

	@Override
	public Result addEvaluationModel(EvaluationModelDto evaluationModelDto) {
		
		if(evaluationModelDao.getByUserIdAndEvaluationModelName(evaluationModelDto.getUserId(), evaluationModelDto.getEvaluationModelName()) != null) {
			return new ErrorResult("Bu isme sahip bir değerlendirme modeli zaten var");
		}
		
		EvaluationModel evaluationModel = new EvaluationModel(0, evaluationModelDto.getUserId(), evaluationModelDto.getEvaluationModelName(), evaluationModelDto.getDecs(), evaluationModelDto.getParameterModelId());
		evaluationModelDao.save(evaluationModel);
		evaluationModel = evaluationModelDao.findTopByOrderByEvaluationModelIdDesc();
		
		for (TopicModelDto topicModelDto : evaluationModelDto.getTopicModelDtos()) {
			TopicModel topicModel = new TopicModel(0, evaluationModel.getEvaluationModelId(), topicModelDto.getTopicName(), topicModelDto.getWeight());
			topicModelDao.save(topicModel);
			topicModel = topicModelDao.findTopByOrderByTopicIdDesc();			
			
			for (QuestionModelDto questionModelDto : topicModelDto.getQuestionModelDtos()) {
				QuestionModel questionModel = new QuestionModel(0, topicModel.getTopicId(), questionModelDto.getWeight(), questionModelDto.getQuestion());
				questionModelDao.save(questionModel);
			}
		}
		
		return new SuccessResult("Değerlendirme Modeli Eklendi.");
	}

}
