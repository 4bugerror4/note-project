package com.bug.note.handler;

import java.util.Map;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CustomApiException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	private String msg;
	private Map<String, String> errorMap;
	
	public CustomApiException(String msg, Map<String,String> errorMap) {
		super(msg);
		this.errorMap = errorMap;
	}

}
