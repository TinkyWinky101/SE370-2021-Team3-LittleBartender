import java.awt.*;
import java.util.*;
import java.io.*;

public class Recipes {
    private String drinkName;
    private String mainLiquor;
    private int servingSize;
    private double percentAlcohol;
    private float difficultyLevel;
    private boolean favorite = false;
    private String howToMake;
    // private int databaseNumber;

    public Recipes(){
        drinkName = "unnamed";
        mainLiquor = "unknown";
        servingSize = 0;
        percentAlcohol = 0.0;
        difficultyLevel = 0;
        favorite = false;
        howToMake = "";
        // databaseNumber = -1;
    }

    public Recipes(String d, String m, int s, double p, float diff){
        drinkName = d;
        mainLiquor = m;
        servingSize = s;
        percentAlcohol = p;
        difficultyLevel = diff;
        howToMake = "";
        favorite = false;
    }

    public Recipes(String d, String m, int s, double p, float diff, String rec){
        drinkName = d;
        mainLiquor = m;
        servingSize = s;
        percentAlcohol = p;
        difficultyLevel = diff;
        howToMake = "";
        favorite = false;
    }

    public Recipes(String FileName){
        try {
            File file = new File(FileName + ".txt");
            Scanner sc = new Scanner(file);

            drinkName = sc.nextLine();
            mainLiquor = sc.nextLine();
            servingSize = sc.nextInt();
            percentAlcohol = sc.nextDouble();
            difficultyLevel = sc.nextFloat();
            howToMake = sc.nextLine();
            favorite = sc.nextBoolean();
            howToMake = sc.nextLine();
            sc.close();
        }

        catch(Exception e){
            System.out.println("Something went wrong");
        }
    }

    // return functions just in case I need something
    public String getDrinkName(){
        return drinkName;
    }

    public String getMainLiquor(){
        return mainLiquor;
    }

    public int getServingSize(){
        return servingSize;
    }

    public double getAPA(){
        return percentAlcohol;
    }

    public float getDifficultyLevel(){
        return difficultyLevel;
    }

    public boolean returnFavorite(){
        return favorite;
    }

    public void userFavorites(){
        favorite = true;
    }

    public void userUnfavorites(){
        favorite = false;
    }

    public String getHowTo(){
        return howToMake;
    }

    
    public void importToFile(){
        try {
            //Open file and write variables into files.
            File dummyFile = new File(drinkName + ".txt");
            FileWriter file = new FileWriter(dummyFile);
            file.write(drinkName + "\n");
            file.write(mainLiquor + "\n");
            file.write(servingSize + "\n");
            file.write(percentAlcohol + "\n");
            file.write(difficultyLevel + "\n");
            file.write(favorite + "\n");
            file.close();
        }

        catch(IOException e){
            System.out.println("File not imported successfully");
            e.printStackTrace();
        }
    }

    public void importToFileWithHowTo(String r)
    {
        try {
            //Open file and write variables into files.
            File dummyFile = new File(drinkName + ".txt");
            FileWriter file = new FileWriter(dummyFile);
            file.write(drinkName + "\n");
            file.write(mainLiquor + "\n");
            file.write(servingSize + "\n");
            file.write(percentAlcohol + "\n");
            file.write(difficultyLevel + "\n");
            file.write(favorite + "\n");
            file.write(r + "\n");
            file.close();
        }

        catch(IOException e){
            System.out.println("File not imported successfully");
            e.printStackTrace();
        }
    }

    public void printContents(){
        System.out.println(drinkName);
        System.out.println(mainLiquor);
        System.out.println(servingSize);
        System.out.println(percentAlcohol);
        System.out.println(difficultyLevel);
        System.out.println(favorite);
    }
}
