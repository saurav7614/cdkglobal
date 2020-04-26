/**
 * 
 */
package com.cdkglobal.exception;

/**
 * @author Saurav
 * This is an user defined exception class for Ticket API
 */
public class EcommerceException extends Exception {

	private static final long serialVersionUID = 1L;

	public EcommerceException() {
		super();
	}

	public EcommerceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public EcommerceException(String message, Throwable cause) {
		super(message, cause);
	}

	public EcommerceException(String message) {
		super(message);
	}

	public EcommerceException(Throwable cause) {
		super(cause);
	}
	
}
