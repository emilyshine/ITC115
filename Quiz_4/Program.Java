/* ******************************************************
 * Emily A. Shine
 * March 12th, 2015
 * Quiz 4 - Program.java
 * The Program class runs the program.  
 * It instantiates the classes, and the animal sounds 
 * appear in the console.  
 * ***************************************************** */

package com.emilyshine.Quiz_4;

public class Program {

	public static void main(String[] args) {
		
		Cat cat = new Cat();
		Dog dog = new Dog();
		System.out.println("A cat says: " + cat.makeSound());		
		System.out.println("A dog says: " + dog.makeSound());
				
	} // end main()

} // end Program()
