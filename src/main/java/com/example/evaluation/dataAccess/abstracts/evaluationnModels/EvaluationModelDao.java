package com.example.evaluation.dataAccess.abstracts.evaluationnModels;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.evaluation.entities.concoretes.evaluationnModels.EvaluationModel;

@Repository
public interface EvaluationModelDao extends JpaRepository<EvaluationModel, Integer> {

	List<EvaluationModel> getByUserId(int userId);
	
	EvaluationModel getByEvaluationModelId(int evaluationModelId);

}
