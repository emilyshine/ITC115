/* ******************************************************
 * Emily A. Shine
 * March 12th, 2015
 * Quiz 4 - Cat.java
 * This class represents a cat and its attributes.
 * It implements the Sounds interface.
 * ***************************************************** */

package com.emilyshine.Quiz_4;

public class Cat implements Sounds {

	// ***** FIELDS *****
	private String sound;
	
	// ***** METHODS *****
	@Override
	public String makeSound() {
		sound = "meeeow"; // sound a cat makes is "meeeow"
		return sound;		
	} // end makeSound()
		
} // end Cat class
