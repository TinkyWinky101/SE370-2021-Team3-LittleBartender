import javax.swing.*;
import java.awt.*;
import java.util.*;

public class ingredientsSearch extends search {
    private int found;
    
    private ArrayList<String> ingredientsList;

    public ingredientsSearch(){
        JFrame frame = new JFrame("Ingredients List");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 1000); //maintain 1000, 1000 throughout program

        JPanel inSearch = new JPanel();
        
        frame.add(inSearch);
        JButton search = new JButton("Search");

        displayList(inSearch, ingredientsList);

        inSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                //Check if selected from list exists. 
                checkIfExists()
            }
        });



        
    }

    int isinDatabase(){
        
    }
}

