package com.example.evaluation.core.utillities.fuzzyLogic;

import java.io.File;
import java.net.URISyntaxException;

import net.sourceforge.jFuzzyLogic.FIS;

public class EvaluationFuzzyModel {
	
	private FIS fis;
	private float point;
	private float score;
	
	public EvaluationFuzzyModel(float point) throws URISyntaxException {
		super();
		this.point = point;
		
		File dosya = new File(getClass().getResource("fuzzyfile.fcl").toURI());
		fis = FIS.load(dosya.getPath());
		fis.setVariable("point", point);
		
		fis.evaluate();
		
		this.score = Math.round(fis.getVariable("tip").getValue());
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
