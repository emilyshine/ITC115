/*******************************************************
 * Emily A. Shine
 * January 9th, 2015
 * Assignment 1 
 * Create an array of 50 random numbers and 
 * count how many values are even and how many are odd.
*******************************************************/

package com.emilyshine.Assignment_1;

import java.util.Random;

public class EvenAndOddIntegers {
	
	// Define size of array.
	final int SIZE = 50;

	public static void main(String[] args) {  
		EvenAndOddIntegers n = new EvenAndOddIntegers(); 
		n.createArray(); // chains down to all arrays
	} 	// end main
	
	// Generate random number for array.
	private int getRandom() {
		Random r = new Random();
		int number = r.nextInt();
		return number;
	} 	// end random

	// Create an empty array.
	private void createArray() {
		int[] array = new int[SIZE];
		populateArray(array);
	} // end createArrays
	
	// Populate empty array with 50 random integers.
	private void populateArray(int[] array) {
		// start for loop at 0, using SIZE b/c only 50 spots avail in array
		for (int i = 0; i < SIZE; i++) {
			int num = getRandom(); // will assign random number to num variable
			array[i] = num; // assigns array position i to num  
		} // end for loop
		countArray(array); // send populated array to countArray method
	} // end populateArray
	
	// Method to count number of odds and number of evens and displays totals.  
	private void countArray(int[] array) {
		int totalOdds = 0; // initialize count of odds to 0
		int totalEvens = 0; // initialize count of events to 0
		// Loop through the array and count how many are even and how many are odd.
		for (int i = 0; i < SIZE; i++) {	
			// Determines if num at position i in array is divisible by 2.  
			// Divisibility by 2 implies even number.  Else is odd.  
			if (array[i]%2 == 0) {
				totalEvens++;  // Increment even count by 1
			}
			else {
				totalOdds++; // Increment odd count by 1
			}
		}
		// Output the totals to the console.
		System.out.println("The total number of evens is: " + totalEvens);
		System.out.println("The total number of odds is: " + totalOdds);
	}
	
