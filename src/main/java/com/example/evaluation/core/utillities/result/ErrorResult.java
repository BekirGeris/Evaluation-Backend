package com.example.evaluation.core.utillities.result;

public class ErrorResult extends Result{

	public ErrorResult() {
		super(false, 404);
	}
	
	public ErrorResult(int code) {
		super(false, code);
	}
	
	public ErrorResult(String message) {
		this(false, message, 404);
	}
	
	public ErrorResult(String message, int code) {
		this(false, message, code);
	}
	
	public ErrorResult(boolean success, String message, int code) {
		super(success, message, code);
	}
}
