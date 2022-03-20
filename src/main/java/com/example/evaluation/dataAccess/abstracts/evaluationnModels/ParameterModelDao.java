package com.example.evaluation.dataAccess.abstracts.evaluationnModels;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.evaluation.entities.concoretes.evaluationnModels.ParameterModel;

@Repository
public interface ParameterModelDao extends JpaRepository<ParameterModel, Integer>{

	ParameterModel getByParameterModelId(int parameterModelId);
}
