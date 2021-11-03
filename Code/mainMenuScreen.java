import javax.naming.ldap.ManageReferralControl;
import javax.swing.*;
import java.awt.*;
import java.util.*;

public class mainMenuScreen extends MainFrame{
    public int selection;
    private final static int NUMBER_OF_ROWS = 3;
    private final static int NUMBER_OF_COLUMNS = 1;

    public mainMenuScreen(){
        //Initialize all components.
        JPanel mms = new JPanel();
        mms.setLayout(new GridLayout(NUMBER_OF_ROWS, NUMBER_OF_COLUMNS));
        JButton ingredients = new JButton("List of Ingredients");
        JButton recipes = new JButton("List of Recipes");
        JButton cyom = new JButton("Create Your Own Mix");
        
        //Add the Buttons into the jpanel
        mms.add(ingredients);
        mms.add(recipes);
        mms.add(cyom);
    }

}
