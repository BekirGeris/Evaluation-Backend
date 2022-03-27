package com.example.evaluation.dataAccess.abstracts.evaluationnModels;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.evaluation.entities.concoretes.evaluationnModels.QuestionModel;

@Repository
public interface QuestionModelDao extends JpaRepository<QuestionModel, Integer>{

	List<QuestionModel> getByTopicId(int topicId);
	
	QuestionModel findTopByOrderByQuestionIdDesc();
}
