/* ******************************************************
 * Emily A. Shine
 * February 18th, 2015
 * Assignment 6 - Recipes.java
 * This is the Recipes class. 
 * It is an extension of Item.  It implements and 
 * potentially overrides methods inherited from the 
 * ManageItems class.  
 * ***************************************************** */

package com.emilyshine.Assignment_6;

import java.util.ArrayList;

public class Recipes implements ManageItems {
	
	// ***** PRIVATE FIELDS *****
	private ArrayList<Recipe> recipeList;
	
	// ***** CONSTRUCTOR *****
	public Recipes(){
		recipeList = new ArrayList<Recipe>();
	} // end Recipes constructor

	// ***** GETTERS AND SETTERS *****
	public ArrayList<Recipe> getRecipeList() {
		return recipeList;
	}

	public void setRecipeList(ArrayList<Recipe> recipeList) {
		this.recipeList = recipeList;
	}

	// ***** OVERRIDE METHODS *****
	@Override
	public void addItem(Item i) {

		// adds a recipe to the recipeList array
		recipeList.add((Recipe) i);
		
	}

	@Override
	public void editItem(Item i) {
		
		/* loops through recipeList, checks if user entered recipe name is equal to
		* any recipe names in the list, and if yes, replaces the recipe object 
		* with the new recipe object passed in by user */
			for(Item recipe : recipeList){
				if(recipe.getName()==i.getName()){ 
					recipe=i;
				} // end if statement
			} // end for loop
		
	}

	@Override
	public void removeItem(Item i) {
		
		/* loops through recipeList, checks if user entered recipe name is equal to
		* any recipe names in the list, and if yes, removes the matching recipe object 
		* from the list */
			for(Item recipe : recipeList){
				if(recipe.getName()==i.getName()){
					recipeList.remove(recipeList.indexOf(recipe));
				} // end if statement
			} // end for loop
		
	}

}
