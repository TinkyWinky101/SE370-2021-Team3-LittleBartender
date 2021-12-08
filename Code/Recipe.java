// import java.awt.*;
// import java.util.*;

// public class Recipe extends listObject {
//     private String directions;
//     private ArrayList<String> ingredients;
// 	private boolean favoritedStatus;


//     public Recipe() {
//         ingredients = new ArrayList<String>();
//     }
	
// 	public String getDirections() {
// 		return directions;
// 	}
// 	public void setDirections(String directions) {
// 		this.directions = directions;
// 	}

// 	public void addItem(String i) {
// 		ingredients.add(i);
		
// 	}

// 	public void editItem(String i) {
// 		for(String item: ingredients){
// 			if (item == i){
// 				ingredients.remove(item);
// 				ingredients.add(item);
// 			}
// 		}
		
// 	}

// 	public String getItem(String name) {
// 		String item=null;
// 		for(String i: ingredients){
// 			if(i == name){
// 				item=i;
// 			}
// 		}
// 		return item;
// 	}

// 	public ArrayList<String> getItems() {
		
// 		return ingredients;
// 	}
// }

import java.awt.*;
import java.util.*;

public class Recipe extends listObject {
    private String directions;
    private String ingredients;
	private boolean favoritedStatus;


    public Recipe() {
        ingredients = "";
		favoritedStatus = false;
    }
	
	public String getDirections() {
		return directions;
	}
	public void setDirections(String directions) {
		this.directions = directions;
	}

	public void setFavorite(){
		favoritedStatus = true;
	}

	public void unFavorite(){
		favoritedStatus = false;
	}

	public boolean getFavorite(){
		return favoritedStatus;
	}

	public void addItem(String i) {
		ingredients = (i);
		
	}

	// public void editItem(String i) {
	// 	for(String item: ingredients){
	// 		if (item == i){
	// 			ingredients.remove(item);
	// 			ingredients.add(item);
	// 		}
	// 	}
		
	// }

	public String getItem(String name) {
		String item=null;

		item = name;
			
		return item;
	}

	public String getItems() {
		
		return ingredients;
	}
}