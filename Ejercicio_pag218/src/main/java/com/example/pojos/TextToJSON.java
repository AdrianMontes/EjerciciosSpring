package com.example.pojos;

public class TextToJSON {
	private String message = "";
	
	public TextToJSON(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}