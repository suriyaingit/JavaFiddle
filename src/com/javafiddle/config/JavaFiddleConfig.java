package com.javafiddle.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.stereotype.Component;

/**
 * The Class JavaFiddleConfig.
 */
@Component
public class JavaFiddleConfig {

	/** The system prop. */
	private Properties systemProp;

	/** The configured. */
	private boolean configured;

	/**
	 * Instantiates a new java fiddle config.
	 */
	public JavaFiddleConfig() {

		try {

			InputStream configInput = getClass().getClassLoader().getResourceAsStream("config.properties");

			systemProp = new Properties();

			systemProp.load(configInput);

			configured = true;

		} catch (IOException e) {
			configured = false;
		}

	}

	/**
	 * Gets the configuration.
	 *
	 * @param configName the config name
	 * @return the configuration
	 */
	public String getConfiguration(String configName) {

		return systemProp.getProperty(configName);
	}

	/**
	 * Sets the configuration.
	 *
	 * @param key the key
	 * @param value the value
	 */
	public void setConfiguration(String key, String value) {

		systemProp.setProperty(key, value);
	}

	/**
	 * Checks if is configured.
	 *
	 * @return true, if is configured
	 */
	public boolean isConfigured() {
		return configured;
	}

}
