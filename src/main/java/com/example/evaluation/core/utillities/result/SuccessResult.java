package com.example.evaluation.core.utillities.result;


public class SuccessResult extends Result{

	public SuccessResult() {
		super(true, 200);
	}
	
	public SuccessResult(int code) {
		super(true, code);
	}
	
	public SuccessResult(String message) {
		this(true, message, 200);
	}
	
	public SuccessResult(String message, int code) {
		this(true, message, code);
	}
	
	public SuccessResult(boolean success, String message, int code) {
		super(success, message, code);
	}
}
