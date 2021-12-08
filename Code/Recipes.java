import java.util.ArrayList;
import java.util.Collections;

public class Recipes {
	//Since Recipe shares stuff with listObject, this works completely fine.
	private ArrayList<Recipe> recipes;
	
	public Recipes(){
		recipes = new ArrayList<Recipe>();
	}
	
	public void addItem(Recipe i) {
		recipes.add(i);
	}

	public void editItem(Recipe i) {
	     for(Recipe item: recipes){
			if (item.getObjectName().equals(i.getObjectName())){
				recipes.remove(item);
				recipes.add(i);
			}
		}
		
	}

	public Recipe getItem(String name) {
		Recipe item = null;
		for(Recipe i: recipes){
			if(i.getObjectName().equals(name)){
				item=i;
			}
		}
		return item;
	}

	public ArrayList<Recipe> getItems() {
		
		return recipes;
	}
	
}