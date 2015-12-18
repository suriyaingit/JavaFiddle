package com.javafiddle.util;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.javafiddle.config.JavaFiddleConfig;
import com.javafiddle.model.ConsoleMessage;

/**
 * The Class JCompiler.
 */
@Component
public class JCompiler {

	/** The compiler. */
	private JavaCompiler compiler;

	/** The console msg. */
	private ConsoleMessage consoleMsg;

	/** The error stack. */
	private List<String> errorStack;

	/** The custom out. */
	private ByteArrayOutputStream customOut;

	@Autowired
	private JavaFiddleConfig appConfig;

	public JCompiler() {

		super();
	}

	private void initComponents() {

		compiler = ToolProvider.getSystemJavaCompiler();

		consoleMsg = new ConsoleMessage();

		errorStack = new ArrayList<String>();

		customOut = new ByteArrayOutputStream();

		/*
		 * if ToolProvider.getSystemJavaCompiler(); not able to find jdk -> jre
		 * -> java.exe runtime then it will configure application with user jdk
		 * path
		 * 
		 */
		if (compiler == null) {

			System.setProperty("java.home", appConfig.getConfiguration("JDK_PATH"));

		}
	}

	/**
	 * Compile.
	 *
	 * @param fileUrl
	 *            the file url
	 * @return the console message
	 */
	public ConsoleMessage compile(String fileUrl) {

		// Initialize compiler components
		initComponents();

		try {
			// perform java compilation using JavaCompiler API
			if (compiler.run(null, null, customOut, fileUrl) == 0) {

				consoleMsg.setSuccessMessage("Compilation Successfull!");

			} else {

				try {
					consoleMsg.setErrorFlag(true);
					errorStack.add(new String(customOut.toByteArray(), "UTF-8"));
				} catch (UnsupportedEncodingException e) {
					consoleMsg.setErrorFlag(true);
					errorStack.add("Error in encoding data");
				}
			}

		} catch (NullPointerException npe) {
			consoleMsg.setErrorFlag(true); 
			errorStack.add("Unable to find javac for JavaCompiler API Please SetUp your"
					+ " Server JAVA_HOME path to jdk->jre instead of jre. "
					+ "if running under any IDE  change java runtime env to jdk->jre intead of jre");
		}
		// Setting error message to console
		consoleMsg.setErrorStack(errorStack);

		return consoleMsg;

	}

	public JavaFiddleConfig getAppConfig() {
		return appConfig;
	}

	public void setAppConfig(JavaFiddleConfig appConfig) {
		this.appConfig = appConfig;
	}

}
