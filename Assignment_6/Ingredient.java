/* ******************************************************
 * Emily A. Shine
 * February 18th, 2015
 * Assignment 6 - Ingredient.java
 * This is the Ingredient class. 
 * It contains the attributes for the ingredients, 
 * and gets/sets for accessing the ingredient fields.  
 * ***************************************************** */

package com.emilyshine.Assignment_6;

public class Ingredient extends Item {
	
	// ***** PRIVATE FIELDS *****
	private String unitSize;
	private double calories;
	private double fat;
	private double protein;
	private double carbs;
	
	// ***** GETTERS AND SETTERS *****
	public String getUnitSize() {
		return unitSize;
	}
	
	public void setUnitSize(String unitSize) {
		this.unitSize = unitSize;
	}
	
	public double getCalories() {
		return calories;
	}
	
	public void setCalories(double calories) {
		this.calories = calories;
	}
	
	public double getFat() {
		return fat;
	}
	
	public void setFat(double fat) {
		this.fat = fat;
	}
	
	public double getProtein() {
		return protein;
	}
	
	public void setProtein(double protein) {
		this.protein = protein;
	}
	
	public double getCarbs() {
		return carbs;
	}
	
	public void setCarbs(double carbs) {
		this.carbs = carbs;
	}

} // end Ingredient class
