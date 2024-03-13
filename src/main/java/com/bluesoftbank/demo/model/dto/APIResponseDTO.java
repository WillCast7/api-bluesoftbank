package com.bluesoftbank.demo.model.dto;

import java.io.Serializable;
import java.util.Map;

import lombok.Data;

@Data
public class APIResponseDTO<T> implements Serializable {

	private boolean state = false;
	private String message = null;
	private String error = null;
	private String code = null;
	private T data = null;


	public void setResponse(T data, String message, String code) {
		this.setMessage(message);
		this.setCode(code);
		this.setState(Boolean.TRUE);
		this.setData(data);
	}

	public void setSuccess(String message, String code) {
		this.setMessage(message);
		this.setCode(code);
		this.setState(Boolean.TRUE);
	}

	public void setFail(String message, String code) {
		this.setMessage(message);
		this.setCode(code);
		this.setState(Boolean.FALSE);
	}

	public void setFailError(String message, String code, String error) {
		this.setMessage(message);
		this.setError(error);
		this.setCode(code);
		this.setState(Boolean.FALSE);
	}

}
