/* ******************************************************
 * Emily A. Shine
 * February 9th, 2015
 * Quiz 1 - RandomNumbers.java
 * This class contains methods that will create an
 * array of random numbers between 1 and 20, and then 
 * loop through the array to display all the numbers 
 * greater than 10.   
 * ***************************************************** */

package com.emilyshine.Quiz_1;

import java.util.Arrays;
import java.util.Random;

public class RandomNumbers {
	
	// Define size of array.
	final int SIZE = 20;
	
	// Define minimum and maximum values of the array (1-20)
	int min = 1;
	int max = 20;

	public static void main(String[] args) {  
		RandomNumbers n = new RandomNumbers(); 
		n.createArray(); // chains down to all arrays
		} 	// end main

	// Generate pseudo-random number for array between 1 and 20.
	public static int getRandom(int min, int max) {
		Random r = new Random();
		int number = r.nextInt((max-min) + 1) + min;
		return number;
	} 	// end random
	
	// Create an empty array.
	private void createArray() {
		int[] array = new int[SIZE];
		populateArray(array);
	}	// end createArrays
		
	// Populate empty array with 20 pseudo-random integers between 1 and 20 from getRandom() method.
	private void populateArray(int[] array) {
		// start for loop at position 0, using SIZE b/c only 20 spots avail in array
		for (int i = 0; i < array.length; i++) {
			int num = getRandom(1, 20); // will assign random number to num variable
			array[i] = num; // assigns array position i to num  
		} // end for loop
		countArray(array); // send populated array to countArray method
	} // end populateArray
	
	// Method to display all numbers in array greater than 10  
	private void countArray(int[] array) {
		System.out.print("The random numbers over 10 are: ");
		// loops through entire array and prints out numbers greater than 10
		for (int i = 0; i < array.length; i++) {	 
			if (array[i] > 10) {	
				// System.out.print(", " + array[i]);
				System.out.print(array[i]); if(i != array.length - 1) System.out.print (", "); // eliminates comma at end of number list
			}
		}
		
		// Use during testing to test array contents. 
		// System.out.println(Arrays.toString(array));
	}
}
