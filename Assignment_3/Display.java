/* ******************************************************
 * Emily A. Shine
 * January 21st, 2015
 * Assignment 3 - Display.java  
 * This class accepts user input and generates 
 * baseball batting and base averages by using the 
 * Display.java class methods.
 * ***************************************************** */

package com.emilyshine.Assignment_3;

import java.util.Scanner;

public class Display {
	
	// Makes "Averages" object available for use in "Display" class
	private Averages averageStats;
	Scanner scan; 
	
	// CONSTRUCTOR METHOD
	// Constructor has same name as the class and no return type (void, int, etc)
	public Display(){ 
		// instantiates the averages object
		averageStats = new Averages();
		// instantiates the scanner object 
		scan = new Scanner(System.in);
		// call the method to get user input
		getInputs();
		// call the method to generate output 
		getOutput();
	} // End of Display() constructor
	
	// INPUTS
	// Method to ask user for input
	private void getInputs(){
		// Asks user for total number of at bats, then assigns that input to matching field in the averageStats object
		System.out.println("Welcome to the Baseball Statistics Program!");
		blankLine();
		System.out.println("Enter total number of at bats:");
		averageStats.setTotalAtBats(scan.nextDouble()); // class, method, input
		blankLine();
		
		// Asks user for total number of hits, then assigns that input to matching field in the averageStats object
		System.out.println("Enter total number of hits:");
		averageStats.setNumberOfHits(scan.nextDouble());
		blankLine();
		
		// Asks user for total number of outs, then assigns that input to matching field in the averageStats object
		System.out.println("Enter total number of outs:");
		averageStats.setNumberOfOuts(scan.nextDouble());
		blankLine();
		
		// Asks user for total number of walks, then assigns that input to matching field in the averageStats object
		System.out.println("Enter total number of walks:");
		averageStats.setNumberOfWalks(scan.nextDouble());
		blankLine();
	} // end getInputs

	// Method to display the calculated averages derived from user inputs
	// The batting average is determined by dividing the number of hits by the total at bats. 
	// The on base average is calculated by dividing the number of hits + the number of walks by the total at bats. 
	private void getOutput(){
		System.out.println("The batting average is: " + averageStats.calculateBattingAverage());
		blankLine();
		System.out.println("The on-base average is: " + averageStats.calculateOnBaseAverage());
	} // end getOutput

	// Provides blankLine separation for use in print outs
		private void blankLine(){
			System.out.println(); 
		} // end blankLine

} // end of display
