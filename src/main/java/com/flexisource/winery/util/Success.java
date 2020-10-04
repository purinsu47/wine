package com.flexisource.winery.util;

public class Success {
	boolean successful;
	String message;

	public boolean isSuccessful() {
		return successful;
	}

	public void setSuccessful(boolean successful) {
		this.successful = successful;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Success(boolean successful, String message) {
		super();
		this.successful = successful;
		this.message = message;
	}

}
