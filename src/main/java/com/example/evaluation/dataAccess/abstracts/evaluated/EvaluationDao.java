package com.example.evaluation.dataAccess.abstracts.evaluated;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.evaluation.entities.concoretes.evaluated.Evaluation;

@Repository
public interface EvaluationDao extends JpaRepository<Evaluation, Integer>{

	List<Evaluation> getByUserId(int userId);
}
