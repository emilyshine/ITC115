/* ******************************************************
 * Emily A. Shine
 * March 12th, 2015
 * Quiz 4 - Dog.java
 * This class represents a dog and its attributes.
 * It implements the Sounds interface.
 * ***************************************************** */

package com.emilyshine.Quiz_4;

public class Dog implements Sounds {
	
	// ***** FIELDS *****
	private String sound;
	
	// ***** METHODS *****
		@Override
		public String makeSound() {
			sound = "woof"; // sound a dog makes is "woof"
			return sound;		
		} // end makeSound()
		
} // end Dog class
