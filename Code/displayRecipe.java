import javax.swing.*;

import java.awt.Label;
import java.awt.event.*;

public class displayRecipe {
    private JFrame frame;
    private JPanel displayRecipe;
    private JLabel nameLabel, ingredientLable, directionLabel;
    private JTextField nameField, ingredientField, directionField;
    private JButton exitButton;

    public displayRecipe(Recipe r){
        createFrame();

        displayRecipe = new JPanel();
        displayRecipe.setLayout(new BoxLayout(displayRecipe, BoxLayout.Y_AXIS));
        frame.add(displayRecipe);
        
        addLabel(nameLabel, "Name");
        addField(nameField, r.getObjectName());

        String compilationOfIngredients = compileIngredients(r);
        
        addLabel(ingredientLable, "Ingredients");
        addField(ingredientField, compilationOfIngredients);

        addLabel(directionLabel, "Directions");
        addField(directionField, r.getDirections());

        exitButton = new JButton("Exit");
        displayRecipe.add(exitButton);

        exitButton.addActionListener(new ExitListener());

    }

    private class ExitListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            frame.dispose();


        }
    }

    private void createFrame(){
        frame = new JFrame("View Recipe");
        frame.setBounds(200, 200, 1000, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(false);

    }

    private void addLabel(JLabel label, String name){
        label = new JLabel(name);
        label.setAlignmentX(label.CENTER_ALIGNMENT);
        displayRecipe.add(label);
    }

    private void addField(JTextField field, String text){
        field = new JTextField(text);
        field.setAlignmentX(field.CENTER_ALIGNMENT);
        field.setEditable(false);
        displayRecipe.add(field);
    }

    private String compileIngredients(Recipe r){
        String ingredientslist = "";
        for(int i = 0; i < r.getItems().size(); i++){
            ingredientslist += (r.getItems().get(i) + " ");
        }

        return ingredientslist;
    }

    public void showFrame(){
        frame.setVisible(true);
    }
}