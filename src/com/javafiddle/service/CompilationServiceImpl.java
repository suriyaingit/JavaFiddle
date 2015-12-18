package com.javafiddle.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javafiddle.model.ConsoleMessage;
import com.javafiddle.model.JavaSourceCode;
import com.javafiddle.util.JCompiler;

/**
 * The Class CompilationServiceImpl.
 */
@Service
public class CompilationServiceImpl  implements CompilationService{

	/** The context. */
	@Autowired
	private ServletContext context;

	@Autowired
	private JCompiler javaCompiler;

	/** The source file. */
	private File sourceFile;

	/** The file output stream. */
	private FileOutputStream fileOutputStream;

	/** The console msg. */
	private ConsoleMessage consoleMsg;

	/**
	 * Compile.
	 *
	 * @param javaSourceCode
	 *            the java source code
	 * @return the console message
	 */
	public ConsoleMessage compile(JavaSourceCode javaSourceCode) {

		try {

			sourceFile = buildTempFile(javaSourceCode.getClassName());

			fileOutputStream = new FileOutputStream(sourceFile);

			fileOutputStream.write((javaSourceCode.getSourceCode()).getBytes());

			consoleMsg = javaCompiler.compile(context.getRealPath("/") + "/bin/"+javaSourceCode.getClassName()+".java");

		} catch (IOException e) {
			e.printStackTrace();
			consoleMsg.getErrorStack().add(e.getMessage());
		} finally {

			try {
				fileOutputStream.flush();
				fileOutputStream.close();
				cleanTempFiles(javaSourceCode.getClassName());
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		return consoleMsg;

	}

	/**
	 * Sets the servlet context.
	 *
	 * @param servletContext
	 *            the new servlet context
	 */
	public void setServletContext(ServletContext servletContext) {
		this.context = servletContext;
	}

	/**
	 * Clean file.
	 *
	 * @param sourceName
	 *            the source name
	 */
	public void cleanTempFiles(String sourceName) {
		getSourceFile().delete();
		final File[] files = new File(context.getRealPath("/") + "/bin/").listFiles();
		for (File file : files) {
			file.delete();
		}

	}

	/**
	 * Builds the file.
	 *
	 * @param sourceName
	 *            the source name
	 * @return the file
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public File buildTempFile(String sourceName) throws IOException {
		File file = new File(context.getRealPath("/") + "/bin/"+sourceName+".java");
		file.createNewFile();
		return file;
	}

	/**
	 * Gets the source file.
	 *
	 * @return the source file
	 */
	public File getSourceFile() {
		return sourceFile;
	}

	public void setJCompiler(JCompiler javaCompiler) {
		this.javaCompiler = javaCompiler;
	}

}
