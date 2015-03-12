/*  *********************************************
 *  Author:  Andy Donovan & Emily Shine
 *  Date:  March 12, 2015
 * 	Assignment: 7
 * 
 * 	Description:  This program creates and runs the
 *  game called Breakout. A user can manipulate a 
 *  paddle in order to send a ball on a trajectory
 *  to destroy a series of bricks.  
 * 
 *  *********************************************
 */

package com.smokedtrout.Assignment7;

import acm.graphics.*;
import acm.program.*;
import acm.util.*;
import acm.gui.*;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

@SuppressWarnings({ "serial", "restriction" })
public class Breakout extends GraphicsProgram {

	
	/* *********************   CONSTANTS   ************************* */
	private final int GAMEWIDTH = 400;
	private final int GAMEHEIGHT = 600;
	private final int BRICKSPACE = 4; // space between bricks
	private final int NUMBEROFBRICKS = 10;
	private final int BRICKWIDTH = GAMEWIDTH/NUMBEROFBRICKS-BRICKSPACE; // for equal sized bricks across game width
	private final int BRICKHEIGHT = 8;
	private final int BRICKSTARTPOSITIONX = 0;
	private final int BRICKSTARTPOSITIONY = 60;
	private final int BALLDIAMETER = 10;
	private final int PADDLEWIDTH = 60;
	private final int PADDLEHEIGHT = 8;
	private final int PADDLEOFFSET = GAMEHEIGHT-60;
	private final int PAUSE = 5; // pauses between animation frames in milliseconds
	
	
	/* *********************   GLOBAL OBJECTS  ********************* */
		
	//declare the ball and paddle objects	
	private GRect paddle;
	private GOval ball;	

	// declare and set the initial ball trajectories (x and y)
	private double ballVX = 4;
	private double ballVY;	
	
	// declare global variable to hold the score
	private int score;
	
	
	/* *********************   RUN METHOD  ************************* */
	
	public void run() {		
		setup();
		waitForClick();
		moveBall();
	} // end run()
	
	
	
	
	
	
	/* *********************   PUBLIC METHODS   ******************** */	

	
	/* The user moves the paddle with lateral movements of the mouse; 
	 * but paddle is contained within the width of the screen.
	 * THIS METHOD IS ONLY CALLED WHEN THE MOUSE MOVES 
	 */
	public void mouseMoved(MouseEvent e) {		
		if(paddle != null) {
			if(e.getX() < (GAMEWIDTH - PADDLEWIDTH)) {
				paddle.setLocation(e.getX(), PADDLEOFFSET);
			} // end if check for position
		} // end if paddle check		
	} // end public mouseMoved ()
	
	
	
	
	/* *********************   PRIVATE METHODS  ******************** */	
	
	
	// this method calls all the configuration methods to setup the game
	private void setup() {
		score = 0;
		setSize(GAMEWIDTH, GAMEHEIGHT);		
	    assembleWall();
	    createBall();
		createPaddle();
	    addMouseListeners();  // this method calls for all mouse events	    
	} // end setup()
	
	
	
	// in two loops, this method creates a 10 X 10 colorful brick wall
	private void assembleWall() {
		int x = BRICKSTARTPOSITIONX;
		int y = BRICKSTARTPOSITIONY;
		Color color = Color.RED;
		
		// first loop for the number of rows
		for (int row=1; row < 11; row++) {
			
			// create the alternating color rows
			if(row <=1) {
			    color = Color.RED;
		    } else if(row >1 && row <=3) {
		    	color = Color.ORANGE;
			} else if(row >3 && row <=5) {
				color = Color.YELLOW;
			} else if(row >5 && row <=7) {
				color = Color.GREEN;
			} else if(row >7 && row <=9) {
				color = Color.CYAN;
			} // end if/else statements
			
			// second loop (embedded) for number of bricks per row
			for (int i=1; i<11; i++) {
				GRect brick = new GRect(x,y,BRICKWIDTH,BRICKHEIGHT);
				brick.setFillColor(color);
				brick.setFilled(true);
								
				add(brick);				
				
				// increment x position + brickspace for next round (column) in loop
				x += BRICKWIDTH + BRICKSPACE;
				
			} // end interior for loop
		
			x = 0; // reset x to beginning of row
			// increment y position + brickspace for next round (row) in loop
			y += BRICKHEIGHT + BRICKSPACE;
			
		} // end exterior for loop
		
	} // end assembleWall()
	
	
	
	
	// this method creates the ball object
	private void createBall() {
		
		// set the initial downward direction of ball randomly
		RandomGenerator rand = new RandomGenerator();
		ballVY = rand.nextDouble(1.0, 3.0);
		
		// configure ball shape, position, size, and color
		ball=new GOval(GAMEWIDTH/2-BALLDIAMETER/2, GAMEHEIGHT/2-BALLDIAMETER/2,	BALLDIAMETER, BALLDIAMETER);
		ball.setFillColor(Color.BLUE);
		ball.setFilled(true);
		
		add(ball);
	} // end createBall()
	
	
	
	// this method creates the paddle
	private void createPaddle() {
		
		// configure paddle shape, position, size, and color
		paddle = new GRect (GAMEWIDTH/2-PADDLEWIDTH/2,PADDLEOFFSET, PADDLEWIDTH, PADDLEHEIGHT);
		paddle.setFillColor(Color.black);
		paddle.setFilled(true);
		
		add(paddle);
	} // end createPaddle()
	
	
	
	// this method creates conditions for how and where the ball should move throughout the game
	private void moveBall() {
		
		boolean keepGoing = true;
		
		while(keepGoing) {
			
			
			//this makes it so when the ball hits the edges it reverses direction
			//          (Right)EAST SIDE				(Left) WEST SIDE
			if(ball.getX() >= GAMEWIDTH-BALLDIAMETER || ball.getX() <= 0) {
				ballVX = -ballVX;
			} // end if		
	
			
			//same for top and bottom -- "bounces" off top and bottom
			if (ball.getY() >= GAMEHEIGHT-BALLDIAMETER || ball.getY() <= 0) {
				ballVY = -ballVY;
			} // end if
			
			
			//this checks for the location of the paddle. If it and the ball's
			//coordinates are the same, it bounces off the paddle
			if (getElementAt(ball.getX() + BALLDIAMETER, ball.getY() + BALLDIAMETER) == paddle) {
				ballVY = -ballVY;
			} // end if
			
			
			
			// if the ball "hit" something, but it is not the paddle, then it is a brick
			// if so, then remove (from canvas/program) the rectangle that was hit
			if (getElementAt(ball.getX() + BALLDIAMETER, ball.getY() + BALLDIAMETER - (2*BRICKHEIGHT)) != null && 
				getElementAt(ball.getX() + BALLDIAMETER, ball.getY() + BALLDIAMETER - (2*BRICKHEIGHT)) != paddle	
				) 
			{				
				ballVY = -ballVY;
				remove(getElementAt(ball.getX() + BALLDIAMETER, ball.getY() + BALLDIAMETER - (2*BRICKHEIGHT)));
				score += 10; // add 10 to the score
				System.out.println("Your score is " + score + " points.");
				
			} // end if
			
						
			//if the ball goes below the paddle we exit the loop and end the game
			if ( ball.getY() > paddle.getY() ) {
				keepGoing = false;
			} // end if
			
			
			//move the ball
			ball.move(ballVX, ballVY);			
			// set the "speed" of ball AKA pause length between movements
			pause(PAUSE);
			
			
		} // end while loop
		
		
		if (keepGoing == false) {		
			resetGame();				
		} // end if
		
		
		
	} // end moveBall()
	
	
	
	// at game over, the position "freezes" until the user clicks
	// then it removes all elements in the canvas
	// and re-runs the game
	private void resetGame() {
		System.out.println("Your total score is " + score + " points.");
		waitForClick();
		removeAll();
		run();		
	} // end resetGame();
	
	
			
} // end Breakout class
