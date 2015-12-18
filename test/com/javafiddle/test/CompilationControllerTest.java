package com.javafiddle.test;

import javax.servlet.ServletContext;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.springframework.mock.web.MockServletContext;

import com.javafiddle.controller.CompilationController;
import com.javafiddle.model.JavaSourceCode;
import com.javafiddle.service.CompilationServiceImpl;
import com.javafiddle.util.JCompiler;
 
 
public class CompilationControllerTest {

	
	 
	private CompilationController compilationController; 
	
 
	private JavaSourceCode javaSourceCode;
	
 
	private CompilationServiceImpl compilationServiceImpl;
	
	 
	@Before
	public void setUp() throws Exception {
		
		compilationServiceImpl = new CompilationServiceImpl();
	 
		ServletContext mockContext = new MockServletContext();

		compilationServiceImpl.setServletContext(mockContext);

		compilationServiceImpl.setJCompiler(new JCompiler());
		
		compilationController = new CompilationController();
		
		compilationController.setCompilationService(compilationServiceImpl);

		javaSourceCode = new JavaSourceCode("TestClass",new StringBuffer()
						.append("public class TestClass {\n"
								+ " public static void main(String args[]) {System.out.println(\"Hello, World\"); }}")
						.toString());
		
	}

	 
	@Test
	public void testCompilationController() {
	 
		Assert.assertNotEquals(compilationController.handleSourceCode(javaSourceCode),null);	
		
		 
	}

}
