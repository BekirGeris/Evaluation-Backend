package com.example.evaluation.core.utillities.result;

import lombok.Data;

@Data
public class Result {

	private boolean success;
	private String message;
	private int code;
	
	public Result(boolean success, int code) {
		this(success, null, code);
	}
	
	public Result(boolean success, String message, int code) {
		this.success = success;
		this.message = message;
		this.code = code;
	}
}
