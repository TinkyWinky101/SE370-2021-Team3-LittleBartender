import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;


public class createRecipes extends recipeFileManager{
    public ArrayList<Recipes> recipe;
    private final static int NUMBER_OF_COLUMNS = 8;
    private final static int NUMBER_OF_ROWS = 2;
    JFrame frame;
    
    
    public createRecipes(){
        frame = new JFrame("Create Your Recipes");
        frame.setVisible(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 1000);
        // frame.setLayout(new GridLayout(NUMBER_OF_COLUMNS, NUMBER_OF_ROWS));
        
        JPanel creator = new JPanel();
        creator.setLayout(new GridLayout(NUMBER_OF_ROWS, NUMBER_OF_COLUMNS));
        frame.add(creator);


        JLabel name = new JLabel("Name of Drink: ");
        creator.add(name);
        
        JTextField nameField = new JTextField();
        creator.add(nameField);
        
        JLabel liquor = new JLabel("Main Liquor: ");
        creator.add(liquor);
        
        JTextField liquorField = new JTextField();
        creator.add(liquorField);

        JLabel size = new JLabel("Serving Size: ");
        creator.add(size);
        
        JTextField sizeField = new JTextField();
        creator.add(sizeField);

        JLabel percent = new JLabel("APV value: ");
        creator.add(percent);
        
        JTextField percentField = new JTextField();
        creator.add(percentField);

        JLabel difficulty = new JLabel("Difficulty from 1 to 10: ");
        creator.add(difficulty);
        
        JTextField difficultyField = new JTextField();
        creator.add(difficultyField);

        JLabel askForRecipes = new JLabel("How to make it: ");
        creator.add(askForRecipes);

        JTextField recipeField = new JTextField();
        creator.add(recipeField);

        JButton create = new JButton("Create the Mix");
        creator.add(create);

        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                String nameOfDrink = nameField.getText();
                String liquorUsed = liquorField.getText();
                String servingSizeAsString = sizeField.getText();
                int trueServingSize = Integer.parseInt(servingSizeAsString);
                String APVString = percentField.getText();
                double APVAsDouble = Double.parseDouble(APVString);
                String difficultyAsString = difficultyField.getText();
                float trueDifficulty = Float.parseFloat(difficultyAsString);

                String userHowTo = recipeField.getText();

                addToDatabase(nameOfDrink, liquorUsed, trueServingSize, APVAsDouble, trueDifficulty);
                // Recipes UCRecipes = new Recipes(nameOfDrink, liquorUsed, trueServingSize, APV, trueDifficulty);
                // UCRecipes.importToFile();

                //destroy frame after done
                frame.dispose();
            }
        });

    }

    public void showFrame() {
        frame.setVisible(true);
    }
}
