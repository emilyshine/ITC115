/* ******************************************************
 * Emily A. Shine
 * January 28th, 2015
 * Assignment 4 - Display.java
 * This class creates the swing form and its associated 
 * elements and actions.  
 * ***************************************************** */ 

package com.emilyshine.Assignment_4;


import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList; // list object in form

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane; // scroll bar in list
import javax.swing.JTextField;

public class Display {

	// *****GLOBAL OBJECT DECLARATION*****
	private DeckOfCards deck;
	
	// declare list of form objects
	private JFrame frame;
	private JPanel borderPanel;
	private JPanel greetingPanel;
	private JPanel buttonPanel;
	private JScrollPane scrollPane;
	private JList cardList;
	private JLabel greetingPrompt;
	private JLabel cardsInHandPrompt;
	private JTextField numberOfCardsText;
	private JButton dealButton;
	private JButton getWordsButton;
	private JButton exitButton;
	
	// *****CONSTRUCTOR METHOD*****
	public Display(){
		// instantiate the deck as a new Deck
		deck = new DeckOfCards();
		createFrame(); // calls the createFrame() method
		
	} // end Display()
	
	// *****PRIVATE METHODS*****
	// create Frame
	// creates frame, sets size 
	private void createFrame(){
		frame = new JFrame();
		frame.setBounds(100, 100, 375, 300); // (x, y, width, height)
		frame.add(createBorderPanel());
		frame.setVisible(true);
	 } // end createFrame()
	
	// create Border Panel
	// creates the panel which encloses other panels
	// grid style layout for entering info 
	private JPanel createBorderPanel(){
		borderPanel = new JPanel();
		borderPanel.setLayout(new BorderLayout());
		borderPanel.add(createGreetingPanel(), BorderLayout.NORTH);
		borderPanel.add(createScrollPane(),BorderLayout.CENTER);
		borderPanel.add(createButtonPanel(), BorderLayout.SOUTH);
		return borderPanel;
	} // end createBorderPanel()
	
	// create greeting panel and associated parts
	private JPanel createGreetingPanel(){
	  	greetingPanel = new JPanel();
	  	greetingPanel.setLayout(new GridLayout(2,2));
	  	greetingPrompt=new JLabel("Welcome to the card game!");
	  	greetingPanel.add(greetingPrompt);
	  	return greetingPanel;
	} // end createGreetingPanel()
	
	// create scroll pane
	// creates scroll pane for card hand display (embed inside scroll bar to have scroll bar)
	private JScrollPane createScrollPane(){
		 cardList = new JList();
		 scrollPane = new JScrollPane(cardList);
		 scrollPane.setBounds(20, 20, 300, 200);
		 return scrollPane;
	} // end createScrollPane()
	
	// flow layout
	// 1 field to get number of cards, 1 button to deal hand, 1 button to exit
	private JPanel createButtonPanel(){
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		
		cardsInHandPrompt = new JLabel("Cards per hand: ");
		numberOfCardsText = new JTextField(2);
		
		dealButton = new JButton("Deal Cards");
		dealButton.addActionListener(new DealButtonListener());
		
		exitButton = new JButton("Exit");
		exitButton.addActionListener(new ExitListener());
	  
		buttonPanel.add(cardsInHandPrompt);
		buttonPanel.add(numberOfCardsText);
		buttonPanel.add(dealButton);
		buttonPanel.add(exitButton);
	  
		return buttonPanel;
	 } // end createButtonPanel()
	
	// *****ACTIONABLE ITEM LISTENERS*****
	// exits the program, closes the frame
	private class ExitListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
		System.exit(0);
		} // end actionPerformed 
	} // end ExitListener
	
	// gets number of cards entered by player and applies to dealHand 
	private class DealButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
		
			// get number of cards entered by player
			String cardsInHand = numberOfCardsText.getText();
			int numberOfCards = Integer.parseInt(cardsInHand); // cast String as integer
			
			ArrayList<Card> cards = deck.dealHand(numberOfCards);
		
			DefaultListModel model = new DefaultListModel();
		   
			// for each of the cards in the hand, add it to the model, which displays it on the screen
			for(Card c: cards){
				model.addElement(c.toString());
		   		}
		   		cardList.setModel(model);
		  	} // end actionPerformed(ActionEvent e)
		  
		}
}
