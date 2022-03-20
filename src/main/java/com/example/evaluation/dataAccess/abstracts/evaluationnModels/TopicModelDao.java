package com.example.evaluation.dataAccess.abstracts.evaluationnModels;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.evaluation.entities.concoretes.evaluationnModels.TopicModel;

@Repository
public interface TopicModelDao extends JpaRepository<TopicModel, Integer>{

	List<TopicModel> getByEvaluationModelId(int evaluationModelId);
}
