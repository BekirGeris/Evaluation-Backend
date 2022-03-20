package com.example.evaluation.dataAccess.abstracts.evaluated;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.evaluation.entities.concoretes.evaluated.Evaluated;

@Repository
public interface EvaluatedDao extends JpaRepository<Evaluated, Integer>{

	List<Evaluated> getByEvaluationId(int evaluationId);
}
