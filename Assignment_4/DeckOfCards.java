/* ******************************************************
 * Emily A. Shine
 * January 28th, 2015
 * Assignment 4 - DeckOfCards.java
 * This class creates the card deck object.  
 * It defines the characteristics of a deck of cards, 
 * and contains methods for generating and shuffling 
 * a standard deck of 52 cards.   
 * ***************************************************** */

package com.emilyshine.Assignment_4;

import java.util.ArrayList;
import java.util.Collections;

public class DeckOfCards {
	
	// *****CONSTANTS*****
	// declare and assign constants for SUITS and NUMBERS
	final String SUITS[] = {"HEART", "SPADE", "DIAMOND", "CLUB"};
	final String NUMBERS[] = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"}; 
	
	// *****DECLARATION*****
	private ArrayList<Card> cards; // ArrayList to hold cards, deck is called "cards," is list of objects

	// *****CONSTRUCTOR*****
	public DeckOfCards(){
		cards = new ArrayList<Card>(); // Instantiates card object, creates cards as an ArrayList in memory
	} 
		
	// *****PUBLIC METHODS*****
	// deal out (x) number of cards
	// method created with two arguments
	public ArrayList<Card> dealHand(int cardsDealt){
		
		// create an ArrayList to hold the hand
		ArrayList<Card> hand = new ArrayList<Card>(); // reminder: declares = then instantiate
		
		// populate deck before shuffling
		populateDeck(); // calling populateDeck()
		
		// shuffling deck prior to dealing out cards
		shuffle(cards);
		
		// get the card at position i, position i is number of cards in hand (from user)
		for (int i = 0; i < cardsDealt; i++) {
			hand.add(cards.get(i)); // add card at position i to the hand
		}
		return hand;
	} // end of dealHand()
	
	// get method
	public ArrayList<Card> getDeck() {
		return cards; 
	} // end getDeck()
	
	// populate deck with 52 cards
	public void populateDeck(){
		for (String suit : SUITS) {
			for (String number : NUMBERS) {
				Card card = new Card(); // declaring a card object = and instantiating it as a new Card
				card.setSuit(suit); // sets suit for specific loop round
				card.setNumber(number); // sets number for specific loop round
				cards.add(card); // add card to ArrayList
			}
		}
	} // end populateDeck()
	
	// *****PRIVATE METHOD*****
	// Shuffle (randomize) the deck method
	private void shuffle(ArrayList<Card> deck){
		// Calls the internal shuffle method
		Collections.shuffle(deck);
	}
}
