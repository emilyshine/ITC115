/* ******************************************************
 * Emily A. Shine
 * February 12th, 2015
 * Quiz 2 - MilesToKilometers.java
 * This class contains a method to convert miles
 * to kilometers based on user entered data.  
 * ***************************************************** */

package com.emilyshine.Quiz_2;

import java.util.Scanner;

public class MilesToKilometers {
	
	public static void main(String[] args) {
		// instantiate the class
		MilesToKilometers m = new MilesToKilometers();
	}
	
	private MilesToKilometers milesToKm;
	Scanner scan; 

	// ***** PRIVATE FIELDS *****
	private double miles;
	private double kilometers;
	
	// ***** GETS AND SETS *****
	// For private fields miles and kilometers
	public int getMiles() {
		return (int) miles;
	}

	public void setMiles(double miles) {
		this.miles = miles;
	}

	public double getKilometers() {
		return kilometers;
	}

	public void setKilometers(double kilometers) {
		this.kilometers = kilometers;
	}
	
	// ***** CONSTRUCTOR METHOD *****
	// Constructor has same name as the class and no return type
	public MilesToKilometers(){ 
		// instantiates the scanner object 
		scan = new Scanner(System.in);
		// call the method to get user input
		getInputs();
		// call the method to generate output 
		getOutput();
	} // End of MilesToKilometers() constructor
	
	// ***** PUBLIC METHODS *****
	// Converts miles to kilometers
	public int mToKm(){
		double convertedKilometers = (getMiles() * 1.7);
		return (int) convertedKilometers;
	} // end mToKm()
	
	// Converts kilometers to miles
	public int kmToM(){
		double convertedMiles = (getKilometers() * 0.62);
		return (int) convertedMiles;
	} // end kmToM()
	
	// *****INPUTS *****
	// Method to ask user for input
	private void getInputs(){
		// Asks user for number of miles to convert to kilometers, 
		// then assigns that input to matching field in the averageStats object
		System.out.println("Welcome to the miles to kilometers conversion program!");
		blankLine();
		System.out.println("Enter the number of miles to convert to kilometers: ");
		setMiles(scan.nextDouble()); // class, method, input
		blankLine();
	} // end getInputs

	// ***** OUTPUT *****
	// Method to display the kilometers converted from miles
	private void getOutput(){
		System.out.println(getMiles() + " mile(s) equals approximately " + mToKm() + " kilometers.");
		} // end getOutput
	
	// Provides blankLine separation for use in print-outs
	private void blankLine(){
		System.out.println(); 
	} // end blankLine

} // end MilesToKilometers()
