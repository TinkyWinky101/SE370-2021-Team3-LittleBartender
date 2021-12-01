import java.util.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;

public class createRecipes {
    public ArrayList<Recipes> recipe;
    private final static int NUMBER_OF_COLUMNS = 2;
    private final static int NUMBER_OF_ROWS = 6;

    
    public createRecipes(){
        JFrame frame = new JFrame("Create Your Recipes");
        frame.setVisible(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 1000);
        frame.setLayout(new GridLayout(NUMBER_OF_COLUMNS, NUMBER_OF_ROWS));
        
        JPanel creater = new JPanel();
        frame.add(creater);

        JButton searchButton = new JButton("Create");

        JLabel name = new JLabel("Name of Drink: ");
        frame.add(name);
        
        JTextField nameField = new JTextField();
        frame.add(nameField);
        
        JLabel liquor = new JLabel("Main Liquor: ");
        frame.add(liquor);
        
        JTextField liquorField = new JTextField();
        frame.add(liquorField);

        JLabel size = new JLabel("Serving Size: ");
        frame.add(size);
        
        JTextField sizeField = new JTextField();
        frame.add(sizeField);

        JLabel percent = new JLabel("APV value: ");
        frame.add(percent);
        
        JTextField percentField = new JTextField();
        frame.add(percentField);

        JLabel difficulty = new JLabel("Difficulty from 1 to 10: ");
        frame.add(difficulty);
        
        JTextField difficultyField = new JTextField();
        frame.add(difficultyField);

        frame.add(searchButton);

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPreformed(ActionEvent e){
                String nameOfDrink = nameField.getText();
                String liquorUsed = liquorField.getText();
                String servingSizeAsString = sizeField.getText();
                int trueServingSize = Integer.parseInt(servingSizeAsString);
                String aPVString = percent.getText();
                double APV = Double.parseDouble(aPVString);
                String difficultyAsString = difficultyField.getText();
                float trueDifficulty = Float.parseFloat(difficultyAsString);

                Recipes UCRecipes = new Recipes(nameOfDrink, liquorUsed, trueServingSize, APV, trueDifficulty);
                UCRecipes.importToFile();
                //destroy frame after done
                frame.dispose();
            }

        });
    }
}
