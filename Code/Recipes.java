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
    private int databaseNumber;

    public Recipes(){
        drinkName = "unnamed";
        mainLiquor = "unknown";
        servingSize = 0;
        percentAlcohol = 0.0;
        difficultyLevel = 0;
        favorite = false;
        databaseNumber = -1;
    }

    public Recipes(String d, String m, int s, double p, float diff){
        drinkName = d;
        mainLiquor = m;
        servingSize = s;
        percentAlcohol = p;
        difficultyLevel = diff;
        favorite = false;
    }

    public Recipes(int fileNumber) throws Exception{
        File file = new File("Recipes.dat");
        Scanner sc = new Scanner(file);

        for(int i = 0; i < fileNumber; i++){
            sc.nextLine();
        }
        while(sc.hasNextLine()){
            drinkName = sc.next();
            mainLiquor = sc.next();
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

    public void importToFile(){
        try {
            //Open file and write variables into files.
            FileWriter file = new FileWriter("Recipes.dat");
            Scanner = scam
            file.write(drinkName + " ");
            file.write(mainLiquor + " ");
            file.write(servingSize + " ");
            file.write(percentAlcohol + " ");
            file.write(difficultyLevel + " ");
            file.write(favorite + " ");
            file.close();
        }

        catch(IOException e){
            System.out.println("File not imported successfully");
            e.printStackTrace();
        }
    }
}
