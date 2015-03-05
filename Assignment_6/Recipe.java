/* ******************************************************
 * Emily A. Shine
 * February 18th, 2015
 * Assignment 6 - Recipe.java
 * This is the Recipe class. 
 * It extends Item by adding Instructions and 
 * Ingredients, as well as the gets/sets for these
 * items.
 * ***************************************************** */

package com.emilyshine.Assignment_6;

import java.util.ArrayList;

public class Recipe extends Item implements ManageItems {
	
	// ***** PRIVATE FIELDS *****
	private ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
	private String instructions;
	
	
	// ***** GETTERS AND SETTERS *****
	public ArrayList<Ingredient> getIngredients() {
		return ingredients;
	}
	
	public void setIngredients(ArrayList<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
	
	public String getInstructions() {
		return instructions;
	}
	
	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	// ***** OVERRIDE METHODS *****
	@Override
	public void addItem(Item i) {
		
		// adds the ingredient to the ingredients array
		ingredients.add((Ingredient) i);
		
	}

	@Override
	public void editItem(Item i) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeItem(Item i) {
		// TODO Auto-generated method stub
		
	}
	
} // end Recipe class
