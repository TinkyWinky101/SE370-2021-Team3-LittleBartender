

import java.awt.*;

import java.util.*;
import java.nio.file.Paths;
import java.io.*;


import javax.swing.*;

public class mainMenuScreen {

	private JFrame frame;
	private JList<String> list;
	private JScrollPane scrollPane;
	private JPanel borderPanel, gridPanel, buttonPanel;
	private JLabel recipeNameLabel, ingredientNameLabel, directionsLabel;
	private JTextField recipeNameTextField, ingredientNameTextField, directionsTextArea;
	private JButton buttonAddIngredient, buttonAddRecipe, buttonFillList, buttonExit;
	
	// class level variables
	private Recipes recipes;
	private ArrayList<String> ingredients;



	
	public mainMenuScreen (){
		newFrame();
		recipes = new Recipes();
		ingredients=new ArrayList<String>();

		//this code adds new recipe names, need to figure out how to populate it


			// try (Scanner scanner = new Scanner(Paths.get("./Recipes.txt"))) {
			// 	while (scanner.hasNextLine()) {
			// 		String row = scanner.nextLine();
			// 		if (row.isEmpty()) {
			// 			continue;
			// 		}
			// 	defaultRecipe.setObjectName(row);
			// 	recipes.addItem(defaultRecipe);
			// 	}
			// }
			// catch (Exception e) {
			// 	System.out.println("An error occured..");
			// }

			// try (BufferedReader br = new BufferedReader(new FileReader("Recipes.txt"))) {
			// 	String line;
			// 	br.useDelimiter("-|\n");

			// } catch (Exception e) {
			// 	System.err.println("Error reading file");
			// }

			// File tempFile = new File("./Recipes.txt");
			// boolean exists = tempFile.exists();
			// System.out.println(exists);

			// Scanner input = new Scanner(new File("../Recipes.txt"));
			// input.useDelimiter("-|\n");
		
			// while(input.hasNext()) {
			// 	int id = input.nextInt();
			// 	String department = input.next();
			// 	String name = input.next();
			// 	double price = Double.valueOf(input.next().substring(1));
			// 	int stock = input.nextInt();
		
			// 	Product newProduct = new Product(name, price, department, id, stock);
			// 	products = addProduct(products, newProduct);
			// }

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
		System.out.println("Fucking stupid Exception: " + e.getMessage());
	}


	}




 

	private void newFrame(){
		frame = new JFrame();
		frame.setBounds(200,200,550,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Recipe App");
		frame.add(newPanel());


	}
	
	private JPanel newPanel(){
		borderPanel = new JPanel();
		borderPanel.setLayout(new BorderLayout());
		borderPanel.add(newScrollPane(),BorderLayout.EAST);
		borderPanel.add(newGPanel(), BorderLayout.WEST);
		borderPanel.add(newButtonSpace(),BorderLayout.NORTH);
        
		return borderPanel;
	}
	
	private JScrollPane newScrollPane(){
		list = new JList<String>();
		scrollPane = new JScrollPane(list);
		return scrollPane;
	}
	
	private JPanel newGPanel(){
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


	
	private JPanel newButtonSpace(){
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        buttonAddIngredient = new JButton("Add Ingredient");
		buttonAddRecipe = new JButton("Add Recipe");
		buttonFillList=new JButton("Display Recipes");
		buttonExit = new JButton("Exit");

		buttonExit.addActionListener(new ExitListener());
        buttonPanel.add(buttonAddIngredient);
		buttonPanel.add(buttonAddRecipe);
		buttonPanel.add(buttonFillList);
		buttonPanel.add(buttonExit);

		buttonFillList.addActionListener(new ListButtonListener());
		buttonAddRecipe.addActionListener(new AddRecipe());
		buttonExit.addActionListener(new ExitListener());
		buttonAddIngredient.addActionListener(new IngredientListener());

		
		return buttonPanel;
	}
	
	private class ExitListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			System.exit(0);
			
		}
		
	}

	private class ListButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			ArrayList<listObject>items=recipes.getItems();
			DefaultListModel<String> model = new DefaultListModel<String>();
			for(listObject i : items){
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
			r.addItem(ingredientNameTextField.getText());
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
			i = ingredientNameTextField.getText();
			ingredients.add(i);
			ingredientNameTextField.setText("");			
			
		}
		
	}

    public void showFrame(){
        frame.setVisible(true);
    }
}

