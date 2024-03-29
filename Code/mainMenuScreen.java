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

	private JFrame windowFrame;
	private JList<String> recipeList;
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
	private ImageIcon myImage;
	private JTextField recipeNameTextField;
	private JTextArea ingredientTextArea;
	private JTextArea directionsTextArea;
	private JButton buttonSearchByName;
	private JButton buttonSearchByrecipe;

	private JButton buttonViewList;
	private JButton buttonAddRecipe;
	private JButton buttonViewFaves;
	private JButton buttonExit;
	
	private Recipes recipes;
	private ArrayList<String> ingredients;
	DefaultListModel defaultListModel=new DefaultListModel();



	
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
		}
		input.close();
		} catch(Exception e){
			// e.printStackTrace();
			System.out.println("Exception: " + e.getMessage());
		}

	}


	private void newFrame(){
		windowFrame = new JFrame();
		windowFrame.setBounds(706,286,492,500);
		windowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		windowFrame.setTitle("LittleBartender");
		windowFrame.add(createBorderPanel());

		//Image to replace the default java icon, may need to alter the image path on your system //
		myImage = new ImageIcon("./LittleBartender_Icon.png");
		windowFrame.setIconImage(myImage.getImage());
	}
	
	private JPanel createBorderPanel(){

		borderPanel = new JPanel();
		borderPanel.setLayout(new BorderLayout());
		borderPanel.setBackground(new Color(78,143,175));
		borderPanel.add(createScrollPane(),BorderLayout.EAST);
		borderPanel.add(createGridPanel(), BorderLayout.WEST);
		borderPanel.add(createButtonPanelA(),BorderLayout.NORTH);
		borderPanel.add(createButtonPanelB(),BorderLayout.SOUTH);
		return borderPanel;

	}
	
	private JScrollPane createScrollPane(){
		recipeList = new JList<>();
		//Add a mouse listener so that 2 clicks here will pull a rec
		recipeList.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt){
				Recipe selectedRec = new Recipe();
				JList<String> list = (JList<String>)evt.getSource();
				if(evt.getClickCount() == 2){
					ArrayList<Recipe>items = recipes.getItems();
					int index = list.locationToIndex(evt.getPoint());

					for(int i = 0; i < items.size(); i++){
							if(items.get(i).getObjectName().contains(list.getModel().getElementAt(index).toString())){
								selectedRec = items.get(i);
						}
					}

					displayRecipe displayer = new displayRecipe(selectedRec);
					displayer.showFrame();

					// System.out.println(listSize + "       " + recipesListSize);
					// System.out.println(list.locationToIndex(evt.getPoint()));
					// System.out.println(list.getModel().toString());
					// System.out.println(items);
					// System.out.println(items.get(0).getObjectName());
				}
			}
		});
		scrollPane = new JScrollPane(recipeList);
		scrollPane.getViewport().getView().setBackground(new Color(240,239,245));
		return scrollPane;
	}
	
	private JPanel createGridPanel(){
		//create the main grid panel
		gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(8,1));
		gridPanel.setBackground(new Color(78,143,175));

		recipeNameLabel = new JLabel("Enter Recipe Name");
		recipeNameTextField = new JTextField();
		recipeNameTextField.setBackground(new Color(240,239,245));
        recipeNameTextField.setColumns(6);


		ingredientNameLabel = new JLabel("Ingredients");
		ingredientTextArea = new JTextArea();
		scrollA = new JScrollPane (ingredientTextArea,  JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		ingredientTextArea.setBackground(new Color(240,239,245));
		ingredientTextArea.setLineWrap(true);

        directionsLabel = new JLabel("Directions");
        directionsTextArea = new JTextArea();
        scrollB = new JScrollPane (directionsTextArea,  JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		directionsTextArea.setBackground(new Color(240,239,245));
		directionsTextArea.setLineWrap(true);
		directionsTextArea.setSize(200, 300);

		gridPanel.add(recipeNameLabel, BorderLayout.NORTH);
		gridPanel.add(recipeNameTextField, BorderLayout.NORTH);
		gridPanel.add(ingredientNameLabel, BorderLayout.NORTH);
		gridPanel.add(scrollA, BorderLayout.NORTH);
        gridPanel.add(directionsLabel, BorderLayout.NORTH);
        gridPanel.add(scrollB, BorderLayout.NORTH);
		
		return gridPanel;
	}


	
	private JPanel createButtonPanelA(){
		buttonPanelA = new JPanel();
		buttonPanelA.setLayout(new FlowLayout(FlowLayout.LEFT));
		//Added a new frame to surround buttons
		buttonPanelA.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder())); 
		buttonPanelA.setBackground(new Color(40,86,110));
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
		buttonViewFaves.addActionListener(new FavoriteButtonListener());
		buttonExit.addActionListener(new ExitListener());
		
		return buttonPanelA;
	}
	
	private JPanel createButtonPanelB(){    	
		buttonPanelB = new JPanel();
		buttonPanelB.setLayout(new FlowLayout(FlowLayout.CENTER));
		buttonPanelB.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder())); 
		buttonPanelB.setBackground(new Color(40,86,110));

		buttonSearchByName = new JButton("Search by Name");		
		buttonSearchByrecipe = new JButton("Search by Ingredient");

		// Add buttons
		buttonPanelB.add(buttonSearchByName);
		buttonPanelB.add(buttonSearchByrecipe);

		buttonSearchByName.addActionListener( new NameSearchListener());
		buttonSearchByrecipe.addActionListener( new IngredientSearchListener());

		return buttonPanelB;
	}

	private class ExitListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			System.exit(0);
			
		}
		
	}

	private class ListButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			ArrayList<Recipe>items = recipes.getItems();
			DefaultListModel<String> dList = new DefaultListModel<String>();
			for(Recipe i : items){
				dList.addElement(i.getObjectName());
			}
			recipeList.setModel(dList);
		}
		
	}

	private class FavoriteButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			ArrayList<Recipe> items = recipes.getItems();
			DefaultListModel<String> dlist = new DefaultListModel<String>();
			for(Recipe i : items){
				if(i.getFavorite() == true){
					dlist.addElement(i.getObjectName());
				}
			}
			recipeList.setModel(dlist);
		}
	}
	
	private class NameSearchListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			ArrayList<Recipe>items = recipes.getItems();
			DefaultListModel<String> dList = new DefaultListModel<String>();
			for(Recipe i : items){
				if(i.getObjectName().contains(recipeNameTextField.getText())){
					dList.addElement(i.getObjectName());
					
				}
			}
			recipeList.setModel(dList);
		}
	}





	private class IngredientSearchListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			ArrayList<Recipe>items = recipes.getItems();
			DefaultListModel<String> aList = new DefaultListModel<String>();
			for(Recipe i : items){
				if(i.getItems().contains(ingredientTextArea.getText())){
					aList.addElement(i.getObjectName());
				}
			}
			recipeList.setModel(aList);
		}
	}

	private class AddRecipe implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			Recipe r = new Recipe();
			r.setObjectName(recipeNameTextField.getText());
			r.setDirections(directionsTextArea.getText());
			r.addItem(ingredientTextArea.getText());
			
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
        windowFrame.setVisible(true);
    }
}