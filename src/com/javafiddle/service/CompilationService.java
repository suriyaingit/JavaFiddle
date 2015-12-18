package com.javafiddle.service;

import com.javafiddle.model.ConsoleMessage;
import com.javafiddle.model.JavaSourceCode;

public interface CompilationService {
	public ConsoleMessage compile(JavaSourceCode javaSourceCode);
}
