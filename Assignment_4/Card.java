/* ******************************************************
 * Emily A. Shine
 * January 28th, 2015
 * Assignment 4 - Card.java
 * This class creates the playing card object.  
 * It defines the suit and number characteristics of 
 * a standard playing card.   
 * ***************************************************** */

package com.emilyshine.Assignment_4;

public class Card {
	
	// *****PRIVATE FIELDS******
	private String suit; 
	private String number;
	
	// *****GETTERS AND SETTERS*****
	public String getSuit() {
		return suit;
	}
	public void setSuit(String suit) {
		this.suit = suit; 
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	} 
	
	// *****PUBLIC METHODS*****
	public String toString(){
		return "Suit = " + getSuit() + "    Number = " + getNumber(); // return Suit and Number of card to display
	} // end toString()

}
