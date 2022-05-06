package com.example.evaluation.core.utillities.result;

public class SuccessDataResult<T> extends DataResult<T>{

	public SuccessDataResult(T data) {
		super(data, true, 200);
	}
	
	public SuccessDataResult(String message) {
		super(null, true, message, 200);
	}
	
	public SuccessDataResult(T data, String message) {
		super(data, true, message, 200);
	}
	
	public SuccessDataResult(T data, String message, int code) {
		super(data, true, message, code);
	}
}
