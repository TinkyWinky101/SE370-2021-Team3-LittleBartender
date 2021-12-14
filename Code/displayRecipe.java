import javax.swing.*;
import java.awt.Label;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.Color; 
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.text.DefaultStyledDocument.ElementSpec;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JCheckBox; 


public class displayRecipe {
    private JFrame frame;
    private JPanel displayRecipe;
    private JPanel recipePanel;
    private JButton exitButton;

    //initial fram constructor for view drink recipe page
    private void createFrame(){
        frame = new JFrame("LittleBartender");
        frame.setBounds(705, 120, 500, 800);
        ImageIcon myImage = new ImageIcon("./LittleBartender_Icon.png");
		frame.setIconImage(myImage.getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(false);

    }
    
    public displayRecipe(Recipe r){
        createFrame();
        recipePanel = new JPanel();
        recipePanel.setLayout(new BorderLayout());
        frame.add(namePanel(r),BorderLayout.NORTH);             // R - Recipe name
        frame.add(createRecipePanel(r),BorderLayout.CENTER);    // R - Recipe info 
    }

    // R - Adds a JPanel to display the recipe ingredients and directions //
    private JPanel createRecipePanel(Recipe r){
        displayRecipe = new JPanel();
        GridLayout layout = new GridLayout(4,1);
        layout.setVgap(10);
        displayRecipe.setLayout(layout);
        displayRecipe.setBackground(new Color(40,70,101));
       
        displayRecipe.add(ingredientPanel(r));
        displayRecipe.add(directionsPanel(r)); 

        // R - If statement to determine which image to add to a specific recipe; each image is 330x165 in size//
        String name = r.getObjectName();
        if (name.equals("Bloody Mary")){
            displayRecipe.add(new JLabel(new ImageIcon("./drinkImage_BM.jpg")));
        } else if (name.equals("French 75")){
            displayRecipe.add(new JLabel(new ImageIcon("./drinkImage_F75.jpg")));
        } else if (name.equals("Fresh Lime Margarita")){
            displayRecipe.add(new JLabel(new ImageIcon("./drinkImage_FLM.jpg")));
        } else if (name.equals("Gin and Tonic")){
            displayRecipe.add(new JLabel(new ImageIcon("./drinkImage_GAT.jpg")));
        } else if (name.equals("Irish Coffee")){
            displayRecipe.add(new JLabel(new ImageIcon("./drinkImage_IC.jpg")));
        } else if (name.equals("Martini")){
            displayRecipe.add(new JLabel(new ImageIcon("./drinkImage_M.jpg")));
        } else if (name.equals("Mint Julep")){
            displayRecipe.add(new JLabel(new ImageIcon("./drinkImage_MJ.jpg")));
        } else if (name.equals("Mimosa")){
            displayRecipe.add(new JLabel(new ImageIcon("./drinkImage_MSA.jpg")));
        } else if (name.equals("Mojito")){
            displayRecipe.add(new JLabel(new ImageIcon("./drinkImage_MJT.jpg")));
        } else if (name.equals("Pina Colada")){
            displayRecipe.add(new JLabel(new ImageIcon("./drinkImage_PC.jpg")));
        } else if (name.equals("Pineapple Rum Punch")){
            displayRecipe.add(new JLabel(new ImageIcon("./drinkImage_PRP.jpg")));
        } else if (name.equals("Red Sangria")){
            displayRecipe.add(new JLabel(new ImageIcon("./drinkImage_RS.jpg")));
        } else if (name.equals("Screwdriver")){
            displayRecipe.add(new JLabel(new ImageIcon("./drinkImage_S.jpg")));
        } else if (name.equals("Whiskey Sour")){
            displayRecipe.add(new JLabel(new ImageIcon("./drinkImage_WS.jpg")));
        } else if (name.equals("White Russian")){
            displayRecipe.add(new JLabel(new ImageIcon("./drinkImage_WR.jpg")));
        } else {
            displayRecipe.add(new JLabel(new ImageIcon("./drinkImage_Placeholder.jpg")));     // R - Placeholder image for new recipes since we can't add new ones after the fact
        }
        displayRecipe.add(bottomPanel(r));
        return displayRecipe;
    }
//area to hold the name of the recipe at the very top of the display window, with styling.
    private JPanel namePanel(Recipe r){
        JPanel namePanel = new JPanel();
        JLabel rName = new JLabel(r.getObjectName());
        namePanel.setBackground(new Color(40,70,101));
        rName.setFont(new Font("Rockwell", Font.PLAIN, 48));
        rName.setForeground(new Color(240,239,245));
        namePanel.add(rName);
        return namePanel;
    }
//panel to hold ingredients in a text area, with the relevant styling to make it approachable.
    private JPanel ingredientPanel(Recipe r) {
        JPanel ingredientPanel = new JPanel();
        ingredientPanel.setBackground(Color.WHITE);
        JTextArea textAreaI = new JTextArea(3, 1);
        textAreaI.setBackground(new Color(240,239,245));
        Font font = new Font("Bookman Old Style",Font.PLAIN,12);
        textAreaI.setFont(font);

        textAreaI.setText("Ingredients:\n" + compileIngredients(r));
        textAreaI.setWrapStyleWord(true);
        textAreaI.setLineWrap(true);
        textAreaI.setOpaque(false);
        textAreaI.setEditable(false);
        textAreaI.setPreferredSize(new Dimension(470,300));
        ingredientPanel.add(textAreaI);

        return ingredientPanel;
    }

    private JPanel directionsPanel(Recipe r){
        JPanel directionsPanel = new JPanel();
        directionsPanel.setBackground(Color.WHITE);

        JTextArea textAreaD = new JTextArea(3, 10);
        textAreaD.setBackground(new Color(240,239,245));
        Font font = new Font("Bookman Old Style",Font.PLAIN,12);
        textAreaD.setFont(font);
        
        textAreaD.setText("Directions:\n" + r.getDirections());
        textAreaD.setWrapStyleWord(true);
        textAreaD.setLineWrap(true);
        textAreaD.setOpaque(false);
        textAreaD.setEditable(false);
        textAreaD.setPreferredSize(new Dimension(470,300));
        directionsPanel.add(textAreaD);
        return directionsPanel;        
    }

    //the bottom panel of the view recipe area that holds favoriting functionality
    private JPanel bottomPanel(Recipe r){
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(new Color(40,70,101));
        bottomPanel.setLayout(new BorderLayout());
        JCheckBox favorite = new JCheckBox("Favorite");
        //Set checkbox depending on r
        if(r.getFavorite() == true){
            favorite.setSelected(true);
        }
        else{
            favorite.setSelected(false);
        }
        favorite.setBackground(new Color(40,70,101));
        favorite.setForeground(new Color(240,239,245));
        //ActionListener would have to be here to access r
        favorite.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if(favorite.isSelected()){
                    r.setFavorite();
                }
                else{
                    r.unFavorite();
                }
            }
        });
        exitButton = new JButton("Exit");
        bottomPanel.add(favorite,BorderLayout.CENTER);
        bottomPanel.add(exitButton, BorderLayout.SOUTH);
        exitButton.addActionListener(new ExitListener());
        return bottomPanel;
    }

    private JLabel blankLabel(){
        JLabel blank = new JLabel();
        blank.setBackground(new Color(40,70,101));
        return blank;
    }

   
    //For the exit button
    private class ExitListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            frame.dispose();


        }
    }
    //grab all ingredients and put them into the relevant box so that the display can have them

    private String compileIngredients(Recipe r){
        String ingredientslist = "";
        // for(int i = 0; i < r.getItems().size(); i++){
        //     ingredientslist += (r.getItems().get(i) + ", ");
        // }
        ingredientslist = r.getItems();
        return ingredientslist;
    }

    public void showFrame(){
        frame.setVisible(true);
    }
}
