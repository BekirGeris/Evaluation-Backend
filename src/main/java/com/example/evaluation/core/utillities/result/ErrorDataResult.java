package com.example.evaluation.core.utillities.result;

public class ErrorDataResult<T> extends DataResult<T>{
	
	public ErrorDataResult(T data) {
		super(data, false, 404);
	}
	
	public ErrorDataResult(String message) {
		super(null, false, message, 404);
	}
	
	public ErrorDataResult(T data, String message) {
		super(data, false, message, 404);
	}
	
	public ErrorDataResult(T data, String message, int code) {
		super(data, false, message, code);
	}
}
