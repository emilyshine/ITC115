/* ******************************************************
 * Emily A. Shine
 * February 12th, 2015
 * Assignment 5 - WriteFile.java
 * This is the WriteFile class.  It provides the methods
 * for writing text to a text file.   
 * ***************************************************** */

package com.emilyshine.Assignment_5;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class WriteFile {
	
	// ***** GLOBAL VARIABLES *****
	
	private String path;
	private PrintWriter writer;
	
	// ***** CONSTRUCTOR *****
	
	public WriteFile(String path) throws IOException {
		
		this.path = path;
		
		// call the createFile() method
		createFile();
		
	} // end WriteFile()

	// ***** PUBLIC METHODS *****

	public void addText(String content) {
		// adds a line to the file
		writer.println(content);
	} // end addText()
	
	// relies on user to call this method to close the writer
	public void closeFile() {
		writer.close();
	} // end closeFile()
	
	// ***** PRIVATE METHODS *****
	
	private void createFile() throws IOException {
		// path for file is passed in, true appends the file
		FileWriter outFile = new FileWriter(path, true);		
		
		// sets writer equal to what is returned from PrintWriter
		writer = new PrintWriter(outFile);
		
	} // end createFile()

} // end WriteFile
