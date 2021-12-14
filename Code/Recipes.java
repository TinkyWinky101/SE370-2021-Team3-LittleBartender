import java.util.ArrayList;
import java.util.Collections;

public class Recipes {
	//Since Recipe shares stuff with listObject, ArrayList is better for other implementation.
	private ArrayList<Recipe> recipes;
	
	//constructor
	public Recipes(){
		recipes = new ArrayList<Recipe>();
	}
	

	//add a recipe object to the Recipes list
	public void addItem(Recipe i) {
		recipes.add(i);
	}


	//returns individual recipe in the recipes array 
	public Recipe getItem(String name) {
		Recipe item = null;
		for(Recipe i: recipes){
			if(i.getObjectName().equals(name)){
				item=i;
			}
		}
		return item;
	}

	//returns whole recipe array list with all recipes in it
	public ArrayList<Recipe> getItems() {
		
		return recipes;
	}
	
}