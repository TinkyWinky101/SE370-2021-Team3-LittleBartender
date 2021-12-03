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

    public Recipes(String FileName) throws Exception{
        File file = new File("/Recipes/" + FileName + ".txt");
        Scanner sc = new Scanner(file);

        
        while(sc.hasNextLine()){
            drinkName = sc.nextLine();
            mainLiquor = sc.nextLine();
            servingSize = sc.nextInt();
            percentAlcohol = sc.nextDouble();
            difficultyLevel = sc.nextFloat();
            favorite = sc.nextBoolean();
        }
        sc.close();
    }

    // return functions just in case I need something
    public String getDrinkName(){
        return drinkName;
    }

    public String getMainLiquor(){
        return mainLiquor;
    }

    public int getServingSIze(){
        return servingSize;
    }

    public double getPA(){
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

    public String returnHowTo(){
        return howToMake;
    }

    
    public void importToFile(){
        try {
            //Open file and write variables into files.
            FileWriter file = new FileWriter("/Recipes/" + drinkName + ".txt");
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
}
