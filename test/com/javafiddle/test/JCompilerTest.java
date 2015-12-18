package com.javafiddle.test;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.javafiddle.config.JavaFiddleConfig;
import com.javafiddle.model.ConsoleMessage;
import com.javafiddle.util.JCompiler;

public class JCompilerTest {

	private JCompiler compiler;

	@Before
	public void setup() {
		compiler = new JCompiler();
		compiler.setAppConfig(new JavaFiddleConfig());

	}

	@Test
	public void testCompileWithoutError() {

		ConsoleMessage console = compiler.compile("test-resources/TestClassWithoutError.java");

		Assert.assertEquals(console.getErrorStack(), new ArrayList<String>());

		Assert.assertEquals("Test Compilation Successfull!", "Compilation Successfull!", console.getSuccessMessage());

		Assert.assertFalse(console.isErrorFlag());
	}

	@Test
	public void testCompileWithError() {

		ConsoleMessage console = compiler.compile("test-resources/TestClassWithError.java");

		Assert.assertNotNull(console.getErrorStack());

		Assert.assertNull(console.getSuccessMessage());

		Assert.assertTrue(console.isErrorFlag());
	}

}
