/* ******************************************************
 * Emily A. Shine
 * February 12th, 2015
 * Assignment 5 - ReadFile.java
 * This is the ReadFile class.  It provides the methods
 * for extracting text from a text file.  
 * ***************************************************** */

package com.emilyshine.Assignment_5;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadFile {
	
	// ***** GLOBAL VARIABLE ***** 
	
	private String path;

	
	// ***** CONSTRUCTOR *****
	
	public ReadFile(String path) {
		this.path = path;
	} // end ReadFile constructor
	
	
	// ***** PUBLIC METHODS *****
	
	// method uses 3 steps to read a file's content
	// a while loop reads each line of content in the file
	public String getText() throws IOException {
		
		// sets content equal to null
		String content = "";
		
		// object for reading file from path
		FileInputStream fstream = new FileInputStream(path);
		
		// object for reading content of file
		DataInputStream fileIn = new DataInputStream(fstream);
		
		// object reads characters of file
		BufferedReader buff = new BufferedReader(new InputStreamReader(fileIn));
		
		// declare a string variable
		String lineIn;
		
		// Set lineIn equal to buff
		while ((lineIn = buff.readLine()) != null) {
			
			// set content equal to the lineIn content plus new line
			content += (lineIn + "\n");
			
		} // end while loop
		
		return content;
		
	} // end getText()

} // end ReadFile
