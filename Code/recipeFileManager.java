import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.io.*;

public class recipeFileManager {
    private ArrayList<String> drinkList;
    
    public recipeFileManager(){
        drinkList = new ArrayList<String>();
    }

    
    public void toggleFavorite(Recipes r){
        if(r.returnFavorite() == true){
            r.userFavorites();
        }
        else
        {
            r.userFavorites();
        }

        updateFile(r);
    }
    public void changeName(Recipes r, String newName){
        Recipes newR = new Recipes(newName, r.getMainLiquor(), r.getServingSize(), r.getAPA(), r.getDifficultyLevel(), r.getHowTo());
        File file = new File(r.getDrinkName() + ".txt");
        file.delete();
        
        drinkList.remove(r.getDrinkName());

        drinkList.add(newName);
        newR.importToFile();
    }

    public void changeMainLiquor(Recipes r, String newLiquor){
        Recipes newR = new Recipes(r.getDrinkName(), newLiquor, r.getServingSize(), r.getAPA(), r.getDifficultyLevel(), r.getHowTo());
        updateFile(newR);
    }

    public void changeServingSize(Recipes r, int newServingSize){
        Recipes newR = new Recipes(r.getDrinkName(), r.getMainLiquor(), newServingSize, r.getAPA(), r.getDifficultyLevel(), r.getHowTo());
        updateFile(newR);
    }

    public void changePercentAlcohol(Recipes r, double newAPA){
        Recipes newR = new Recipes(r.getDrinkName(), r.getMainLiquor(), r.getServingSize(), newAPA, r.getDifficultyLevel(), r.getHowTo());
        updateFile(newR);
    }

    public void changeDifficultyLevel(Recipes r, float newDifficultyLevel){
        Recipes newR = new Recipes(r.getDrinkName(), r.getMainLiquor(), r.getServingSize(), r.getAPA(), newDifficultyLevel, r.getHowTo();
        updateFile(r);
    }

    public void changeHowTo(Recipes r, String newHowTo){
        Recipes newR = new Recipes(r.getDrinkName(), r.getMainLiquor(), r.getServingSize(), r.getAPA(), r.getDifficultyLevel(), newHowTo);
        updateFile(newR);
    }

    public void addToDatabase(String d, String m, int s, double p, float diff, String rec){
        drinkList.add(d);
        Recipes newRecipe = new Recipes(d, m, s, p, diff, rec);
        newRecipe.importToFile();
    }
    
    public void destroyRecipe(String drink){
       boolean isDeleted = drinkList.remove(drink);
       if(isDeleted){
           File fileToDelete = new File(drink + ".txt");
           fileToDelete.delete();

           System.out.println("File sucessfully deleted");
       }   

       else{
           System.out.println("Something went wrong, file unsucessfully deleted.");
       }


    }

    // public void displayList(JPanel panel, ArrayList<String> list){
    //     JList display = new JList(list);
    //     display.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    //     display.setLayoutOrientation(JList.VERTICAL);
    //     display.setVisibleRowCount(-1);
    //     JScrollPane listScroller = new JScrollPane(display);
    //     listScroller.setPreferedSize(new Dimension(250, 80));

    //     panel.add(listScroller);
    // }

    private void updateFile(Recipes r){
        File file = new File(r.getDrinkName() + ".txt");
        file.delete();
        
        r.importToFile();
    }
    
}
