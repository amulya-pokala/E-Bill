/*
 * 
 */
package com.leap.hackathon.elist.CustomExceptions;

/**
 * The Class CustomBadRequestException.
 */
public class CustomBadRequestException extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new custom bad request exception.
	 *
	 * @param msg
	 *            the msg
	 */
	public CustomBadRequestException(String msg) {
		super(msg);
	}
}
