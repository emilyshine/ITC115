/* ******************************************************
 * Emily A. Shine
 * January 21st, 2015
 * Assignment 3 - Averages.java
 * This class contains methods that will calculate
 * batting and on-base averages from user entered data.   
 * ***************************************************** */

package com.emilyshine.Assignment_3;

public class Averages {

	// PRIVATE FIELDS
	// The class will need fields for Total at bats, number of hits, number of outs and number of walks. 
	// Fields are properties and/or attributes of the class "Averages"
	private double totalAtBats; // 
	private double numberOfHits; // 
	private double numberOfOuts; 
	private double numberOfWalks;
	
	// GETs AND SETs 
	// for private fields
	public double getTotalAtBats() {
		return totalAtBats;
	}
	public void setTotalAtBats(double totalAtBats) {
		this.totalAtBats = totalAtBats;
	}
	public double getNumberOfHits() {
		return numberOfHits;
	}
	public void setNumberOfHits(double numberOfHits) {
		this.numberOfHits = numberOfHits;
	}
	public double getNumberOfOuts() {
		return numberOfOuts;
	}
	public void setNumberOfOuts(double numberOfOuts) {
		this.numberOfOuts = numberOfOuts;
	}
	public double getNumberOfWalks() {
		return numberOfWalks;
	}
	public void setNumberOfWalks(double numberOfWalks) {
		this.numberOfWalks = numberOfWalks;
	}

	// PUBLIC METHODS
	// The class will also contain two methods one to calculate the batting average and one to calculate 
	// the on-base average.
	
	// The batting average is determined by dividing the number of hits by the total at bats.
	// Multiplied by 1000 and cast as int to display in proper baseball statistic format
	public int calculateBattingAverage(){
		double battingAverage = (getNumberOfHits() / getTotalAtBats()) * 1000;
		return (int) battingAverage; 
	} // end calculateBattingAverage
	
	// The on base average is calculated by dividing the number of hits + the number of walks by the total at bats.
	// Multiplied by 1000 and cast as int to display in proper baseball statistic format
	public int calculateOnBaseAverage(){
		double onBaseAverage = ((getNumberOfHits() + getNumberOfWalks()) / getTotalAtBats()) * 1000; 
		return (int) onBaseAverage; 
	} // end calculateOnBaseAverage
}
