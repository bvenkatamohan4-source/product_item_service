package com.akhm.item.exception;

public class ApplicationException extends RuntimeException {

	private static final long serialVersionUID = -2650850630966434002L;

	public ApplicationException(String message, Throwable cause) {
		super(message, cause);
	}

}
