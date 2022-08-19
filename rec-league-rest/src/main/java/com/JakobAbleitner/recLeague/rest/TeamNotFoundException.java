package com.JakobAbleitner.recLeague.rest;

public class TeamNotFoundException extends RuntimeException {

	public TeamNotFoundException() {
	}

	public TeamNotFoundException(String message) {
		super(message);
	}

	public TeamNotFoundException(Throwable cause) {
		super(cause);
	}

	public TeamNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public TeamNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
