import java.util.ArrayList;

public class Recipes {

	private ArrayList<listObject> recipes;
	
	public Recipes(){
		recipes = new ArrayList<listObject>();
	}
	
	public void addItem(listObject i) {
		recipes.add(i);
	}

	public void editItem(listObject i) {
	     for(listObject item: recipes){
			if (item.getObjectName().equals(i.getObjectName())){
				recipes.remove(item);
				recipes.add(i);
			}
		}
		
	}

	public listObject getItem(String name) {
		listObject item = null;
		for(listObject i: recipes){
			if(i.getObjectName().equals(name)){
				item=i;
			}
		}
		return item;
	}

	public ArrayList<listObject> getItems() {
		
		return recipes;
	}
	
}