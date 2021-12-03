import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.io.*;

public class recipeFileManager {
    private ArrayList<String> drinkList;
    
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
    
    public void addToDatabase(String d, String m, int s, double p, float diff){
        
    }

    public void displayList(JPanel panel, ArrayList<String> list){
        JList display = new JList(list);
        display.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        display.setLayoutOrientation(JList.VERTICAL);
        display.setVisibleRowCount(-1);
        JScrollPane listScroller = new JScrollPane(display);
        listScroller.setPreferedSize(new Dimension(250, 80));

        panel.add(listScroller);
    }

    private void updateFile(Recipes r){
        File file = new File("/Recipes/" + r.getDrinkName() + ".txt");
        file.delete();
        
        r.importToFile();
    }
    
}
