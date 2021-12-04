import javax.swing.*;


public class displayRecipe {
    private JFrame frame;
    private JPanel displayRecipe;
    private JLabel nameLabel, ingredientLable, recipeLabel;
    private JTextField nameField, ingredientField, recipeField;
    private JButton exitButton;

    public displayRecipe(){
        createFrame();

        displayRecipe = new JPanel();
        displayRecipe.setLayout(new BoxLayout(displayRecipe, BoxLayout.LINE_AXIS));
        frame.add(displayRecipe);
        
        nameLabel = new J

        


    }

    public void createFrame(){
        frame = new JFrame("View Recipe");
        frame.setBounds(200, 200, 1000, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(false);

    }

}