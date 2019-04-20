package com.codefountain.networking.java.utils;

public class SocketHandlingException extends RuntimeException{

	private static final long serialVersionUID = -2690633798353593675L;
	
	public SocketHandlingException() {
		super();
	}
	
	public SocketHandlingException(String error) {
		super(error);
	}
	
	public SocketHandlingException(String error, Throwable cause) {
		super(error, cause);
	}

}
