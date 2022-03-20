package com.example.evaluation.dataAccess.abstracts.evaluated;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.evaluation.entities.concoretes.evaluated.Question;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer>{

	List<Question> getByTopicId(int topicId);
}
