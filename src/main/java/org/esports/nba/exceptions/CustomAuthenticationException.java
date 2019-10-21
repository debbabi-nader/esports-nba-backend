package org.esports.nba.exceptions;

import org.springframework.security.core.AuthenticationException;


public class CustomAuthenticationException extends AuthenticationException {

	private static final long serialVersionUID = -358236879161848806L;

	public CustomAuthenticationException() {
		super("");
	}
	
	public CustomAuthenticationException(String msg) {
		super(msg);
	}

	public CustomAuthenticationException(String msg, Throwable t) {
		super(msg, t);
	}
	
}
