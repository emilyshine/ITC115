/* ******************************************************
 * Emily A. Shine
 * February 12th, 2015
 * Assignment 5 - Display.java
 * This is the Display class.  It creates the form and
 * associated elements needed for the text read and 
 * write actions.  It also contains the methods 
 * (event handlers) for the button actions.  
 * ***************************************************** */

package com.emilyshine.Assignment_5;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Display {
	
	// ***** CONSTANTS *****
	final String FILEPATH = "C:\\temp\\textfile.txt";
	
	// ***** GLOBAL OBJECTS *****
	// Class level variables
	// Declare Swing objects to be used
	private JFrame frame; // declares name of object
	
	private JPanel borderPanel;
	private JPanel welcomePanel;
	private JPanel buttonPanel;
	
	private JLabel welcomePrompt;
	private JLabel programInstructions;
	private JTextArea textArea;
	private JScrollPane scrollPane;
	
	private JButton openButton;
	private JButton saveButton;
	private JButton exitButton;
	
	
	// ***** CONSTRUCTOR *****
	
	public Display(){
		
		createFrame(); // calls the createFrame() method
		
	} // end Display() constructor
	
	// ***** PRIVATE METHODS ***** 
	// CREATE FRAME
	private void createFrame(){
		
		// instantiates frame as new JFrame
		frame = new JFrame();
		
		// sets size of the frame
		// x, y on screen and width, height
		frame.setBounds(100, 100, 400, 500);
		
		// stops program when window closes
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE); 
		
		// add the panel to the frame
		frame.add(createBorderPanel());
		frame.setVisible(true);
		
	} // end createFrame()
	
	// BORDER PANEL
	// contains all the panels
	private JPanel createBorderPanel(){
		borderPanel = new JPanel();
		borderPanel.setLayout(new BorderLayout());
		borderPanel.add(createWelcomePanel(), BorderLayout.NORTH);
		borderPanel.add(createTextAreaPanel(), BorderLayout.CENTER);
		borderPanel.add(createButtonPanel(), BorderLayout.SOUTH);
		return borderPanel;
	} // end createBorderPanel()
	
	// NORTH
	// creates welcome panel and associated parts
	private JPanel createWelcomePanel(){
		welcomePanel = new JPanel();
		welcomePanel.setLayout(new GridLayout(2,2));
		welcomePrompt=new JLabel("Welcome to the text file program!");
		programInstructions=new JLabel("This program reads and writes to the file: 'C:\\temp\\textfile.txt'");
		welcomePanel.add(welcomePrompt);
		welcomePanel.add(programInstructions);
		return welcomePanel;
	}
		
	// CENTER
	// Creates scroll pane for text area
	private JScrollPane createTextAreaPanel(){
		textArea = new JTextArea();
		scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(20, 20, 300, 300);
		return scrollPane;
	} // end createScrollPane()
	
	// SOUTH
	// Flow layout, 3 buttons total
	// 1 button to open file, 1 button to save file, 1 button to exit
	private JPanel createButtonPanel(){
		
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		
		// OPEN button
		openButton = new JButton("OPEN");
		openButton.addActionListener(new OpenButtonListener());
			
		// SAVE button 
		saveButton = new JButton("SAVE");
		saveButton.addActionListener(new SaveButtonListener());
		
		// EXIT button
		exitButton = new JButton("EXIT");
		exitButton.addActionListener(new ExitButtonListener());
		
		// adds buttons to buttonPanel
		buttonPanel.add(openButton);
		buttonPanel.add(saveButton);
		buttonPanel.add(exitButton);
		  
		return buttonPanel;
	}
	
	// ***** ACTIONABLE ITEM LISTENERS *****
	// OPEN button action, will open existing text file 
	private class OpenButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
		// this method reads the file at the specified path and displays to the text area	
			
			ReadFile rf = new ReadFile(FILEPATH);
			String content;
				
			try {
					
				// set the content variable to what is returned from 
				// the ReadFile getText method
				content = rf.getText();
					
				// display content to the text area
				textArea.setText(content);
					
			} catch (IOException err) {
					
				// if error occurs, display exception message to text area
				textArea.setText(err.getMessage());
					
			} // end try/catch block
		} // end actionPerformed 
	} // end OpenButtonListener	
	
	// SAVE button action, appends user text to existing text file
	private class SaveButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
		// this method appends a user's input to the text file at the specified path
				
			try {
					
				String textInBox = textArea.getText();
					
				// appends user text to the location (path) specified in the argument
				WriteFile wf = new WriteFile(FILEPATH);
				wf.addText(textInBox);
					
				// close the file
				wf.closeFile();
					
			} catch (IOException err) {
					
				// if error occurs, display exception message to text area
				textArea.setText(err.getMessage());
					
			} // end try catch block
		} // end actionPerformed 
	} // end SaveButtonListener
	
	// EXIT button action, will exit the program and close the frame
	private class ExitButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
		System.exit(0);
		} // end actionPerformed 
	} // end ExitButtonListener	
		
}
