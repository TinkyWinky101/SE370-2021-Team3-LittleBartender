import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;

public class mainMenuScreen implements frames {
    private int optionSelect;
    private final static int NUMBER_OF_ROWS = 3;
    private final static int NUMBER_OF_COLUMNS = 1;
    private JFrame frame;

    public mainMenuScreen(){
        //Initialize all components.
        frame = new JFrame("Main Menu");
        frame.setVisible(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 1000); //maintain 1000, 1000 throughout program

        JPanel mms = new JPanel();
        mms.setLayout(new GridLayout(NUMBER_OF_ROWS, NUMBER_OF_COLUMNS));
        JButton ingredients = new JButton("List of Ingredients");
        JButton recipes = new JButton("List of Recipes");
        JButton cyom = new JButton("Create Your Own Mix");
        
        //Add the Buttons into the jpanel
        mms.add(ingredients);
        mms.add(recipes);
        mms.add(cyom);

        //code actionListeners for each and every one.
        ingredients.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                optionSelect = 1;
        }});

        ingredients.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                optionSelect = 2;
        }});

        ingredients.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                optionSelect = 3;
        }});
    }
    public void showFrame(){
        frame.setVisible(true);
    }
}
