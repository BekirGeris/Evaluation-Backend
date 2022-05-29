package com.example.evaluation.core.utillities.fuzzyLogic;


import org.antlr.runtime.RecognitionException;

import com.example.evaluation.entities.concoretes.evaluationnModels.ParameterModel;

import net.sourceforge.jFuzzyLogic.FIS;

public class EvaluationFuzzyModel {
	
	private FIS fis;
	private float point;
	private float score;
	private String fuzzyFile;
	private String status;
	
	public EvaluationFuzzyModel(ParameterModel parameterModel) throws RecognitionException{
		super();
		//parameterModel.changeFormat();
		fuzzyFile = "FUNCTION_BLOCK fuzzyfile			// Block definition (there may be more than one block per file)\r\n"
						+ "\r\n"
						+ "VAR_INPUT					// Define input variables\r\n"
						+ "	point : REAL;\r\n"
						+ "END_VAR\r\n"
						+ "\r\n"
						+ "VAR_OUTPUT					// Define output variable\r\n"
						+ "	tip : REAL;\r\n"
						+ "END_VAR\r\n"
						+ "\r\n"
						+ "FUZZIFY point				// Fuzzify input variable 'point': {'poor', 'good' , 'excellent'}\r\n"
						+ "	TERM poor := trape " + parameterModel.getPoor1() + " " + parameterModel.getPoor2() + " " + parameterModel.getPoor3() + " " + parameterModel.getPoor4() + ";\r\n"
						+ "	TERM unsatisfactory := trape " + parameterModel.getUnsatisfactory1() + " " + parameterModel.getUnsatisfactory2() + " " + parameterModel.getUnsatisfactory3() + " " + parameterModel.getUnsatisfactory4() + ";\r\n"
						+ "	TERM average := trape " + parameterModel.getAverage1() + " " + parameterModel.getAverage2() + " " + parameterModel.getAverage3() + " " + parameterModel.getAverage4() + ";\r\n"
						+ "	TERM good := trape " + parameterModel.getGood1() + " " + parameterModel.getGood2() + " " + parameterModel.getGood3() + " " + parameterModel.getGood4() + ";\r\n"
						+ "	TERM excellent := trape " + parameterModel.getExcellent1() + " " + parameterModel.getExcellent2() + " " + parameterModel.getExcellent3() + " " + parameterModel.getExcellent4() + ";\r\n"
						+ "END_FUZZIFY\r\n"
						+ "\r\n"
						+ "DEFUZZIFY tip				// Defzzzify output variable 'tip' : {'poor', 'average', 'generous' }\r\n"
						+ "	TERM poor := trape 0 0 20 30;\r\n"
						+ "	TERM unsatisfactory := trian 20 40 60;\r\n"
						+ "	TERM average := trian 40 60 90;\r\n"
						+ "	TERM good := trian 60 90 100;\r\n"
						+ "	TERM excellent := trian 90 100 100;\r\n"
						+ "	\r\n"
						+ "	METHOD : COG;				// Use 'Center Of Gravity' defuzzification method\r\n"
						+ "	DEFAULT := 0;				// Default value is 0 (if no rule activates defuzzifier)\r\n"
						+ "END_DEFUZZIFY\r\n"
						+ "\r\n"
						+ "RULEBLOCK No1\r\n"
						+ "	AND : MIN;					// Use 'min' for 'and' (also implicit use 'max' for 'or' to fulfill DeMorgan's Law)\r\n"
						+ "	ACT : MIN;					// Use 'min' activation method\r\n"
						+ "	ACCU : MAX;					// Use 'max' accumulation method\r\n"
						+ "\r\n"
						+ "	RULE 1 : IF point IS poor THEN tip IS poor;\r\n"
						+ "	RULE 2 : IF point IS unsatisfactory THEN tip IS unsatisfactory;\r\n"
						+ "	RULE 3 : IF point IS average THEN tip IS average;\r\n"
						+ "	RULE 4 : IF point IS good THEN tip IS good;\r\n"
						+ "	RULE 5 : IF point IS excellent THEN tip IS excellent;\r\n"
						+ "END_RULEBLOCK\r\n"
						+ "\r\n"
						+ "END_FUNCTION_BLOCK";
		
		fis = FIS.createFromString(fuzzyFile, true);
	}
	
	public float evaluate(float point) {
		fis.setVariable("point", point);
		fis.evaluate();
		this.score = Math.round(fis.getVariable("tip").getValue()) + (Math.round(fis.getVariable("tip").getValue()) == 0 ? 0 : 3);
		this.status = checkStatus(point, fis.getVariable("tip").getMembership("poor"), 
								fis.getVariable("tip").getMembership("unsatisfactory"), 
								fis.getVariable("tip").getMembership("average"), 
								fis.getVariable("tip").getMembership("good"),
								fis.getVariable("tip").getMembership("excellent"));
		return getScore();
	}
	
	private String checkStatus(float point, double p, double u, double a, double g, double e) {
		if (point == 100) {
			return "Excellent";
		}
		double var = Math.max(p, Math.max(u, Math.max(a, Math.max(g, e))));
		
		if (var == p) {
			return "Poor";
		} else if (var == u) {
			return "Unsatisfactory";
		} else if (var == a) {
			return "Average";
		} else if (var == g) {
			return "Good";
		} else if (var == e) {
			return "Excellent";
		}
		
		return "Belirlenemedi";
	}
	
	public float evaluate(int multiplyValue, float point) {
		return multiplyValue * point;
	}

	public FIS getFis() {
		return fis;
	}

	public void setFis(FIS fis) {
		this.fis = fis;
	}

	public float getPoint() {
		return point;
	}

	public void setPoint(float point) {
		this.point = point;
	}

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Score : " + Math.round(fis.getVariable("tip").getValue());
	}
}
