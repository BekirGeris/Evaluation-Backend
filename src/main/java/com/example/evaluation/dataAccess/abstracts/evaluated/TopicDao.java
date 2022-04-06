package com.example.evaluation.dataAccess.abstracts.evaluated;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.evaluation.entities.concoretes.evaluated.Topic;

@Repository
public interface TopicDao extends JpaRepository<Topic, Integer>{

	List<Topic> getByEvaluationId(int evaluationId);
	
	Topic findTopByOrderByTopicIdDesc();
}
