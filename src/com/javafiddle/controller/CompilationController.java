package com.javafiddle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javafiddle.model.ConsoleMessage;
import com.javafiddle.model.JavaSourceCode;
import com.javafiddle.service.CompilationServiceImpl;

/**
 * The Class CompilationController.
 */
@Controller
public class CompilationController {

	/** The compilation service. */
	@Autowired
	private CompilationServiceImpl compilationServiceImpl;

	

	/**
	 * Handle source code.
	 *
	 * @param javaSourceCode
	 *            the java source code
	 * @return the console message
	 */
	@RequestMapping(value = "execute", method = RequestMethod.POST)
	@ResponseBody
	public ConsoleMessage handleSourceCode(@RequestBody JavaSourceCode javaSourceCode) {

		return compilationServiceImpl.compile(javaSourceCode);

	}

	@RequestMapping(value = "test", method = RequestMethod.GET)
	@ResponseBody
	public String test() {

		return "works";

	}
	
	
	/**
	 * Sets the compilation service.
	 *
	 * @param compilationServiceImpl
	 *            the new compilation service
	 */
	public void setCompilationService(CompilationServiceImpl compilationServiceImpl) {
		this.compilationServiceImpl = compilationServiceImpl;
	}

}
