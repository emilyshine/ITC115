/*******************************************************
 * Emily A. Shine
 * January 12th, 2015
 * Assignment 1 - Part 2
 * Create one, two dimensional array of books and authors.  
 * User should be able to enter author name and have any title(s) by that author returned.
 *******************************************************/

package com.emilyshine.Assignment_1_Part2;

import java.util.ArrayList;

import java.util.Scanner;

public class BooksAndAuthors {

	// the user should be able to enter an author name and have any title or
	// titles by that author returned.

	// instantiate the Scanner object
	// allows for user input
	Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		// instantiate this class
		BooksAndAuthors assignment1Part2 = new BooksAndAuthors();
		assignment1Part2.twoDimensionalArray(); // chains down to all arrays
	}

	// Create two dimensional array of books and authors.
	private void twoDimensionalArray() {
		String[][] collection = new String[10][2]; // first number is how many rows, second is how many columns

		collection[0][0] = "Do Androids Dream of Electric Sheep?"; // row & column index in brackets
		collection[0][1] = "Philip K. Dick"; 

		collection[1][0] = "Never Let Me Go";
		collection[1][1] = "Kazuo Ishiguro";

		collection[2][0] = "Ubik";
		collection[2][1] = "Philip K. Dick";

		collection[3][0] = "A Wind in the Door";
		collection[3][1] = "Madeleine L'Engle";

		collection[4][0] = "Blindness";
		collection[4][1] = "José Saramago";

		collection[5][0] = "Seeing";
		collection[5][1] = "José Saramago";

		collection[6][0] = "Harbor";
		collection[6][1] = "John Ajvide Lindqvist";

		collection[7][0] = "Let the Right One In";
		collection[7][1] = "John Ajvide Lindqvist";

		collection[8][0] = "A Pale View of Hills";
		collection[8][1] = "Kazuo Ishiguro";

		collection[9][0] = "A Scanner Darkly";
		collection[9][1] = "Philip K. Dick";

		authorGuess(collection);
	} // end twoDimensionalArray

	// loop compares user entered data to authors and returns matching titles
	private void authorGuess(String[][] collection) {
		System.out.println("Enter author to search available titles: "); // prompts user for author
		String author = new String(); // instantiates author variable
		author = scan.nextLine(); // assigns author to user input
		for (int i = 0; i < 10; i++) { // loops through array positions
			
			if (author.equals(collection[i][1])) { // compares author entered by user to title column
				System.out.println(collection[i][0]); // prints titles matched to author column
			}
		}
	}
}
