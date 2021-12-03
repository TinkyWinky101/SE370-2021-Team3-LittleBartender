
import java.awt.ScrollPane;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.nio.file.Paths;
import java.io.File;
import java.awt.Dimension;


import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class mainMenuScreen {

	//declare all the form objects
	private JFrame frame;
	private JList<String> list;
	private JScrollPane scrollPane;
	private JPanel borderPanel;
	private JPanel gridPanel;
	private JPanel buttonPanel;
    private JPanel createPanel;
	private JLabel recipeNameLabel;
	private JLabel ingredientNameLabel;
	private JLabel directionsLabel;
	private JTextField recipeNameTextField;
	private JTextField ingredientNameTextField;
	private JTextArea directionsTextArea;
	private JButton buttonAddIngredient;
	private JButton buttonAddRecipe;
	private JButton buttonFillList;
	private JButton buttonExit;
	
	// class level variables
	// private Recipes recipes;
	// private ArrayList<Item> ingredients;


	
	public mainMenuScreen(){
		//Initialize the frame and classes
		createJFrame();
		// recipes = new Recipes();
		// ingredients=new ArrayList<Item>();

		//this code adds new recipe names, need to figure out how to populate it

	}

 

	private void createJFrame(){
		frame = new JFrame();
		frame.setBounds(200,200,550,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Recipe App");
		frame.add(createBorderPanel());
	}
	
	//create the border panel
	private JPanel createBorderPanel(){
		borderPanel = new JPanel();
		borderPanel.setLayout(new BorderLayout());
		borderPanel.add(createScrollPane(),BorderLayout.EAST);
		borderPanel.add(createGridPanel(), BorderLayout.WEST);
		borderPanel.add(createButtonPanel(),BorderLayout.NORTH);
        
		return borderPanel;
	}
	
	private JScrollPane createScrollPane(){
	//create the scrollpane and add the list to it
		list = new JList<String>();
		//add the selection listener to the list
		scrollPane = new JScrollPane(list);
		return scrollPane;
	}
	
	private JPanel createGridPanel(){
		//create the main grid panel
		gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(7,2));

		recipeNameLabel=new JLabel("Enter Recipe Name");
		recipeNameTextField=new JTextField();
        recipeNameTextField.setColumns(6);
		ingredientNameLabel = new JLabel("Enter Ingredient Name");
		ingredientNameTextField = new JTextField();
        ingredientNameTextField.setColumns(6);

        directionsLabel=new JLabel("Directions");
        directionsTextArea = new JTextArea();
        JScrollPane scroll = new JScrollPane (directionsTextArea,  JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		directionsTextArea.setLineWrap(true);
		
		gridPanel.add(recipeNameLabel, BorderLayout.NORTH);
		gridPanel.add(recipeNameTextField, BorderLayout.NORTH);
		gridPanel.add(ingredientNameLabel, BorderLayout.CENTER);
		gridPanel.add(ingredientNameTextField, BorderLayout.CENTER);
        // gridPanel.add(createPanel());
        gridPanel.add(directionsLabel, BorderLayout.SOUTH);
        gridPanel.add(scroll, BorderLayout.SOUTH);

		// gridPanel.add(directionsTextArea, BorderLayout.SOUTH);

		
		return gridPanel;
		
	}


	
	private JPanel createButtonPanel(){
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        buttonAddIngredient = new JButton("Add Ingredient");
		buttonAddRecipe = new JButton("Add Recipe");
		buttonFillList=new JButton("Display Current");
		buttonExit = new JButton("Exit");

		buttonExit.addActionListener(new ExitListener());
        buttonPanel.add(buttonAddIngredient);
		buttonPanel.add(buttonAddRecipe);
		buttonPanel.add(buttonFillList);
		buttonPanel.add(buttonExit);

		
		return buttonPanel;
	}
	
	private class ExitListener implements ActionListener{
		//listener for exiting the program
		@Override
		public void actionPerformed(ActionEvent arg0) {
			System.exit(0);
			
		}
		
	}
    public void showFrame(){
        frame.setVisible(true);
    }
}