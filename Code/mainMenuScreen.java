import java.awt.*;
import java.awt.event.*;

import java.util.*;
import java.nio.file.Paths;
import java.io.*;
import java.awt.Dimension;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.Color;

public class mainMenuScreen {

	private JFrame frame;
	private JList<String> list;
	private JScrollPane scrollPane;
	private JScrollPane scrollA;
	private JScrollPane scrollB;
	private JPanel borderPanel;
	private JPanel gridPanel;
	private JPanel buttonPanelA;
	private JPanel buttonPanelB;
	private JLabel recipeNameLabel;
	private JLabel ingredientNameLabel;
	private JLabel directionsLabel;
	private JLabel servingSizeNameLabel;
	private ImageIcon myImage;
	private JTextField recipeNameTextField;
	private JTextArea ingredientTextArea;
	private JTextField servingSizeTextField;
	private JTextArea directionsTextArea;
	private JButton buttonSearchByName;
	private JButton buttonSearchByrecipe;

	private JButton buttonViewList;
	private JButton buttonAddRecipe;
	private JButton buttonViewFaves;
	private JButton buttonExit;
	
	// class level variables
	private Recipes recipes;
	private ArrayList<String> ingredients;



	
	public mainMenuScreen (){
		newFrame();
		recipes = new Recipes();
		ingredients=new ArrayList<String>();

		try{
		Scanner input = new Scanner(Paths.get("./Recipes.txt"));
		input.useDelimiter("-|\n");

		while(input.hasNext()) {
			Recipe defaultRecipe = new Recipe();
			defaultRecipe.setObjectName(input.next());
			defaultRecipe.addItem(input.next());
			defaultRecipe.setDirections(input.next());
			recipes.addItem(defaultRecipe);
			System.out.println(defaultRecipe.getObjectName());
			System.out.println(defaultRecipe.getItems());
			System.out.println(defaultRecipe.getDirections());
		}
		input.close();
		} catch(Exception e){
			// e.printStackTrace();
			System.out.println("Exception: " + e.getMessage());
		}

	}


	private void newFrame(){
		frame = new JFrame();
		frame.setBounds(706,286,492,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("LittleBartender");
		frame.add(createBorderPanel());

		//Image to replace the default java icon, may need to alter the image path on your system //
		myImage = new ImageIcon("D:/Rian/Documents/CSUSM Fall 2021/SE 370/FP/LittleBartender_Icon.png");
		frame.setIconImage(myImage.getImage());
	}
	
	private JPanel createBorderPanel(){

		borderPanel = new JPanel();
		borderPanel.setLayout(new BorderLayout());
		borderPanel.setBackground(new Color(92,192,222));
		borderPanel.add(createScrollPane(),BorderLayout.EAST);
		borderPanel.add(createGridPanel(), BorderLayout.WEST);
		borderPanel.add(createButtonPanelA(),BorderLayout.NORTH);
		borderPanel.add(createButtonPanelB(),BorderLayout.SOUTH);
		return borderPanel;

	}
	
	private JScrollPane createScrollPane(){
		list = new JList<String>();
		//Add a mouse listener so that 2 clicks here will pull a rec
		list.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt){
				JList<String> list = (JList<String>)evt.getSource();
				if(evt.getClickCount() == 2){
					//Require some changes in Recipes for it to work, but that's ok
					ArrayList<Recipe>items = recipes.getItems();
					int index = list.locationToIndex(evt.getPoint());
					Recipe selectedRec = items.get(index);
					displayRecipe displayer = new displayRecipe(selectedRec);
					displayer.showFrame();
				}
			}
		});
		scrollPane = new JScrollPane(list);
		return scrollPane;
	}
	
	private JPanel createGridPanel(){
		//create the main grid panel
		gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(8,1));
		gridPanel.setBackground(new Color(92,192,222));

		recipeNameLabel = new JLabel("Enter Recipe Name");
		recipeNameTextField = new JTextField();
        recipeNameTextField.setColumns(6);

		servingSizeNameLabel = new JLabel("Serving Size (oz)"); 
		servingSizeTextField = new JTextField();
        servingSizeTextField.setColumns(6);

		ingredientNameLabel = new JLabel("Ingredients");
		ingredientTextArea = new JTextArea();
		scrollA = new JScrollPane (ingredientTextArea,  JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		ingredientTextArea.setLineWrap(true);

        directionsLabel = new JLabel("Directions");
        directionsTextArea = new JTextArea();
        scrollB = new JScrollPane (directionsTextArea,  JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		directionsTextArea.setLineWrap(true);
		directionsTextArea.setSize(200, 300);

		gridPanel.add(recipeNameLabel, BorderLayout.NORTH);
		gridPanel.add(recipeNameTextField, BorderLayout.NORTH);
		gridPanel.add(servingSizeNameLabel, BorderLayout.NORTH);
		gridPanel.add(servingSizeTextField, BorderLayout.NORTH);
		gridPanel.add(ingredientNameLabel, BorderLayout.NORTH);
		gridPanel.add(scrollA, BorderLayout.NORTH);
        gridPanel.add(directionsLabel, BorderLayout.NORTH);
        gridPanel.add(scrollB, BorderLayout.NORTH);
		
		return gridPanel;
		//gridPanel = new JPanel();
		//gridPanel.setLayout(new GridLayout(7, 2));
		
		//return gridPanel; 
	}


	
	private JPanel createButtonPanelA(){
		buttonPanelA = new JPanel();
		buttonPanelA.setLayout(new FlowLayout(FlowLayout.LEFT));
		//Added a new frame to surround buttons
		buttonPanelA.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder())); 
		buttonPanelA.setBackground(new Color(66,147,172));
		buttonViewList = new JButton("View Recipe List");
		buttonAddRecipe = new JButton("Add Recipe");
		buttonViewFaves = new JButton("View Favorited Recipes");
		buttonExit = new JButton("Exit");

		// Add top buttons
        buttonPanelA.add(buttonViewList);
		buttonPanelA.add(buttonAddRecipe);
		buttonPanelA.add(buttonViewFaves); 
		buttonPanelA.add(buttonExit);

		//Action listeners
		buttonViewList.addActionListener(new ListButtonListener());
		buttonAddRecipe.addActionListener(new AddRecipe());
		buttonExit.addActionListener(new ExitListener());
		
		return buttonPanelA;
	}
	
	private JPanel createButtonPanelB(){    	
		buttonPanelB = new JPanel();
		buttonPanelB.setLayout(new FlowLayout(FlowLayout.CENTER));
		buttonPanelB.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder())); 
		buttonPanelB.setBackground(new Color(66,147,172));

		buttonSearchByName = new JButton("Search by Name");		
		buttonSearchByrecipe = new JButton("Search by Ingredient");

		// Add buttons
		buttonPanelB.add(buttonSearchByName);
		buttonPanelB.add(buttonSearchByrecipe);

		return buttonPanelB;
	}

	private class ExitListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			System.exit(0);
			
		}
		
	}

	private class ListButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			ArrayList<Recipe>items=recipes.getItems();
			DefaultListModel<String> model = new DefaultListModel<String>();
			for(Recipe i : items){
				model.addElement(i.getObjectName());
			}
			list.setModel(model);
		}
		
	}
	private class AddRecipe implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			Recipe r = new Recipe();
			r.setObjectName(recipeNameTextField.getText());
			r.setDirections(directionsTextArea.getText());
			r.addItem(ingredientTextArea.getText());
			// for(String i: ingredients){
			// 	String ingredient = i;
			// 	r.addItem(ingredient);
			// }
			
			recipes.addItem(r);
			recipeNameTextField.setText("");
			directionsTextArea.setText("");
			ingredients.clear();

			System.out.println(r.getObjectName());
			System.out.println(r.getItems());
			System.out.println(r.getDirections());
			
		}
		
		
	}
	
	private class IngredientListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			String i;
			i = ingredientTextArea.getText();
			ingredients.add(i);
			ingredientTextArea.setText("");			
			
		}
		
	}

    public void showFrame(){
        frame.setVisible(true);
    }
}