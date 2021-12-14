

import java.awt.*;
import java.util.*;

public class Recipe extends listObject {
    private String directions;
    private String ingredients;
	private boolean favoritedStatus;

//constructor
    public Recipe() {
        ingredients = "";
		favoritedStatus = false;
    }
	//return the directions for a given recipe
	public String getDirections() {
		return directions;
	}
	//sets directions equal to the passed string from MainMenuScreen
	public void setDirections(String directions) {
		this.directions = directions;
	}

	//change boolean favorite to true to unfavorite the reciupe
	public void setFavorite(){
		favoritedStatus = true;
	}

	//change boolean favorite to false to unfavorite the reciupe
	public void unFavorite(){
		favoritedStatus = false;
	}

	//checks the status of a recipe to see if it is favorited or not
	public boolean getFavorite(){
		return favoritedStatus;
	}


	//passes the item as a string to the ingredients area to add to the recipe
	public void addItem(String i) {
		ingredients = (i);
		
	}

	//is supposed to return an individual ingredient from the ingredients list
	public String getItem(String name) {
		String item=null;

		item = name;
			
		return item;
	}

	//return the entire ingredients list
	public String getItems() {
		
		return ingredients;
	}
}