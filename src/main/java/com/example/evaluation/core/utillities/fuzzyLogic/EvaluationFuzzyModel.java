package com.example.evaluation.core.utillities.fuzzyLogic;

import java.io.File;
import java.net.URISyntaxException;

import net.sourceforge.jFuzzyLogic.FIS;

public class EvaluationFuzzyModel {
	
	private FIS fis;
	private float point;
	private float score;
	
	public EvaluationFuzzyModel() throws URISyntaxException {
		super();
		
		File dosya = new File(getClass().getResource("fuzzyfile.fcl").toURI());
		fis = FIS.load(dosya.getPath());
	}
	
	public float evaluate(float point) {
		fis.setVariable("point", point);
		fis.evaluate();
		this.score = Math.round(fis.getVariable("tip").getValue()) + 3;
		return getScore();
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
	
	@Override
	public String toString() {
		return "Score : " + Math.round(fis.getVariable("tip").getValue());
	}
}
