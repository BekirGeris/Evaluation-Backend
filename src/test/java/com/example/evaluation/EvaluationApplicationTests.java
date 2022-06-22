package com.example.evaluation;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.evaluation.core.utillities.fuzzyLogic.EvaluationFuzzyModel;

@SpringBootTest
class EvaluationApplicationTests {

	@Test
	void contextLoads() {
	}

	
	@Test 
	void calculateTest() {
		float inputCal = 0;
		for (int i = 100;inputCal <= 5;i++) {
			inputCal += i * 0.001;
			try {
				EvaluationFuzzyModel evaluationFuzzyModel = new EvaluationFuzzyModel(null);
				System.out.println("Input " + inputCal + " caled : " + evaluationFuzzyModel.evaluate(inputCal));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
