/* ******************************************************
 * Emily A. Shine
 * February 18th, 2015
 * Assignment 6 - Item.java
 * This is the abstract class Item. 
 * It contains the toString method returning Item name.
 * ***************************************************** */

package com.emilyshine.Assignment_6;

public abstract class Item {
	
	// ***** PRIVATE FIELDS *****
	
	private String name;

	// ***** GETTERS AND SETTERS *****
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	// ***** toString METHOD *****
	public String toString(){
		return "Item name: " + getName();
	} // end toString()

} // end Item class
