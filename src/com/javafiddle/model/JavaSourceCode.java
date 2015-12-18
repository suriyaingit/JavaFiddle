/*
 * 
 */
package com.javafiddle.model;

/**
 * The Class JavaSourceCode.
 */
public class JavaSourceCode {

	
	/** The source code. */
	private String sourceCode;
	
	/** The class name. */
	private String className;
	
 	
	/** The Default PACKAGE_NAME. */
	private final  static String PACKAGE_NAME = "package bin;";

	
	/**
	 * Instantiates a new java source code.
	 *
	 * @param className the class name
	 * @param sourceCode the source code
	 */
	public JavaSourceCode(String className,String sourceCode) {
		super();
		this.className = className;
		this.sourceCode = sourceCode;
	}


	/**
	 * Instantiates a new java source code.
	 */
	public JavaSourceCode() {
		super();
		
	}
 

	/**
	 * Gets the source code.
	 *
	 * @return the source code
	 */
	public String getSourceCode() {
		return sourceCode;
	}


	/**
	 * Sets the source code.
	 *
	 * @param sourceCode the new source code
	 */
	public void setSourceCode(String sourceCode) {
		this.sourceCode = sourceCode;
	}


	/**
	 * Gets the package name.
	 *
	 * @return the package name
	 */
	public static String getPackageName() {
		return PACKAGE_NAME;
	}


	/**
	 * Gets the class name.
	 *
	 * @return the class name
	 */
	public String getClassName() {
		return className;
	}


	/**
	 * Sets the class name.
	 *
	 * @param className the new class name
	 */
	public void setClassName(String className) {
		this.className = className;
	}


	
	
}
