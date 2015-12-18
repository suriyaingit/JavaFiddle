/*
 * 
 */
package com.javafiddle.model;

import java.util.List;

/**
 * The Class ConsoleMessage.
 */
public class ConsoleMessage {

	/** The error stack. */
	private List<String> errorStack;

	/** The success message. */
	private String successMessage;

	/** The error flag. */
	private boolean errorFlag;

	
	/**
	 * Instantiates a new console message.
	 *
	 * @param errorStack
	 *            the error stack
	 * @param successMessage
	 *            the success message
	 * @param errorFlag
	 *            the error flag
	 */
	public ConsoleMessage(List<String> errorStack, String successMessage, boolean errorFlag) {
		super();
		this.errorStack = errorStack;
		this.successMessage = successMessage;
		this.errorFlag = errorFlag;
	}

	/**
	 * Instantiates a new console message.
	 */
	public ConsoleMessage() {
		super();
		this.errorFlag = false;
	}


	/**
	 * Gets the error stack.
	 *
	 * @return the error stack
	 */
	public List<String> getErrorStack() {
		return errorStack;
	}

	/**
	 * Sets the error stack.
	 *
	 * @param errorStack
	 *            the new error stack
	 */
	public void setErrorStack(List<String> errorStack) {
		this.errorStack = errorStack;
	}

	/**
	 * Gets the success message.
	 *
	 * @return the success message
	 */
	public String getSuccessMessage() {
		return successMessage;
	}

	/**
	 * Sets the success message.
	 *
	 * @param successMessage
	 *            the new success message
	 */
	public void setSuccessMessage(String successMessage) {
		this.successMessage = successMessage;
	}

	/**
	 * Checks if is error flag.
	 *
	 * @return true, if is error flag
	 */
	public boolean isErrorFlag() {
		return errorFlag;
	}

	/**
	 * Sets the error flag.
	 *
	 * @param errorFlag
	 *            the new error flag
	 */
	public void setErrorFlag(boolean errorFlag) {
		this.errorFlag = errorFlag;
	}

}
