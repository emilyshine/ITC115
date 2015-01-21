/*******************************************************
 * Emily A. Shine
 * January 16th, 2015
 * Assignment 2
 * Create a guessing game that randomly selects a number 
 * between 1 and 500.  The player has 10 tries to guess
 * the number and loses a point for each incorrect guess.
 * When the game completes, the player is asked to play
 * again or quit the game.  
*******************************************************/
 
//The player gets 10 tries to guess the number. After each guess the program tells the player 
//whether that guess was too high or too low. If the player guesses correctly, the game displays 
//their points (Each player starts with 10 points and loses one with each guess.) Then it asks 
//the player whether he or she wants to play again. If the player says yes, the game is reset 
//and the player gets 10 more guesses at a new number; if the player says no, the game thanks 
//them for playing and ceases.
//Break the code into appropriate methods. Use java naming conventions. 
//Document your code with a header and comments as needed.

package com.emilyshine.Assignment_2;

import java.util.Random;
import java.util.Scanner;

public class GuessingGame {

	// Define maximum random number
		final int MAXRANDOM = 500;
		
	// Instantiate the Scanner object
	Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		GuessingGame n = new GuessingGame(); 
		n.gameRules();
		n.compareGuess(); 
	} 	// end main
	
	// provide directions to the player
	private void gameRules(){
		System.out.println("WELCOME TO THE NUMBER GAME");
		System.out.println("Try to guess a randomly selected number between 1 and 500");
		System.out.println("You will have 10 chances to guess the number.");
		System.out.println("Your score starts at 10 and you lose 1 point for each incorrect guess.");
		System.out.println("Time to play!");
		blankLine();
	}
	
	// creates blank line between transitions
	private void blankLine(){
		System.out.println();
	}

	// The game randomly selects a number between 1 and 500.
	private int getRandom() {
		Random r = new Random();
		// int number = r.nextInt(MAXRANDOM); 
		return r.nextInt(MAXRANDOM);
	} 	// end random number

	// Get player's input from Scanner
	private int userGuess() {
		System.out.println("Enter your guess: "); // prompts user for guess
		int guess = scan.nextInt(); // instantiates guess variable
		return guess;
		}
	
	// Compare player's guess to randomly selected number and provide feedback. 
	private void compareGuess() {
		int number = getRandom();
		for (int i = 10; i > 0; i--) { // 10 guesses, counts down to track score
			int guess = userGuess();
			int score = i-1; 
			if (guess == number) { // if user guess is equal to the random number & provide remaining guesses
				System.out.println("Amazing guess!  You win!  Your score is " + score + ".");
				break;
			}
			else if (guess > number) { // guess is greater than random number & provide remaining guesses
				System.out.println("You guessed too high! " + score + " guesses remain.");
			}
			else if (guess < number) { // guess is less than random number & provide remaining guesses
				System.out.println("You guessed too low! " + score + " guesses remain.");
			}	
		}
		// provide correct random number to user if game is lost.
		System.out.println("The correct number was " + number + ".");
		blankLine();
		// go to game over method once game cycle is complete 
		gameOver();
	}  
	
	// Prompt player to play again or quit the game.
	// Use caseless y/n entry to determine user's choice to play again or stop game.  
	private void gameOver() {
		System.out.println("Do you want to play again? Enter Y for Yes, N for No.");
		String playAgain = new String();
		playAgain = scan.next();
		if (playAgain.equalsIgnoreCase("Y")) {
			compareGuess(); 
		}
		else if (playAgain.equalsIgnoreCase("N")) {
			System.out.println("Thank you for playing!");
		}
	}
}
