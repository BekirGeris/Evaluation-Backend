package com.example.evaluation.core.utillities.result;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class DataResult<T> extends Result{
	
	private T data;

	public DataResult(T data, boolean success, String message, int code) {
		super(success, message, code);
		this.data = data;
	}

	public DataResult(T data, boolean success, int code) {
		super(success, code);
		this.data = data;
	}
	
}
