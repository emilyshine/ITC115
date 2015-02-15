/* ******************************************************
 * Emily A. Shine
 * February 15th, 2015
 * Quiz 3 - FormLayout.java
 * This class creates a form and associated components.
 * It asks the user to enter a name, click a button, 
 * and then the name is displayed in the app, along
 * with a "Welcome" message.  
 * ***************************************************** */

package com.emilyshine.Quiz_3;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FormLayout {
	
	// ***** GLOBAL OBJECTS *****
	// Class level variables
	JFrame frame;
	JPanel panel1; // create panel
	JPanel borderPanel;
	JPanel buttonPanel;
	JLabel label1; 
	JLabel label2; 
	JTextField textName;
	JButton button;
	JButton exitButton;
	
	// ***** CONSTRUCTOR *****
	public FormLayout(){
		createFrame();
	}
	
	// ***** PRIVATE METHODS *****
	// create frame
	private void createFrame(){
		frame = new JFrame();
		frame.setBounds(100, 100, 400, 100);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE); // program closes when window is closed
		frame.add(createBorderPanel());
		frame.setVisible(true);
	} // end createFrame()
	
	// border panel
	private JPanel createBorderPanel(){
		borderPanel = new JPanel();
		borderPanel.setLayout(new BorderLayout());
		borderPanel.add(createPanel(), BorderLayout.NORTH);
		borderPanel.add(createButtonPanel(), BorderLayout.SOUTH);
		return borderPanel;
	}
	
	// create button panel and buttons
	private JPanel createButtonPanel(){
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		
		button = new JButton("Click Here");
		button.addActionListener(new ButtonListener());
		
		exitButton = new JButton("Exit");
		exitButton.addActionListener(new ExitListener());
		
		buttonPanel.add(button);
		buttonPanel.add(exitButton);
		
		return buttonPanel;
	}
	
	// ***** CREATE PANELS *****
	// grid layout
	private JPanel createPanel(){
		panel1=new JPanel();
		// lays out row and columns, no control over size, just divides space
		// can divide grid into other grids
		panel1.setLayout(new GridLayout(2,2));
		// constructor for JLabel to provide instructions to user
		label1 = new JLabel("Enter Your Name");
		textName=new JTextField(25); // max characters specified as 25
		label2 = new JLabel();
		panel1.add(label1);
		panel1.add(textName);
		panel1.add(label2);
		
		return panel1;
	}
	
	// implements ButtonListener
	// ActionListener is an interface
	private class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			label2.setText("Welcome, " + textName.getText());
			
		}
	}
		
	private class ExitListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
				
			}
		
	}
	
}
