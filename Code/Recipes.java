import java.awt.*;
import java.util.*;

public class Recipes {
    private String drinkName;
    private String mainLiquor;
    private int servingSize;
    private double percentAlcohol;
    private float difficultyLevel;

    public Recipes(){
        drinkName = "unnamed";
        mainLiquor = "unknown";
        servingSize = 0;
        percentAlcohol = 0.0;
        difficultyLevel = 0;
    }

    public Recipes(String d, String m, int s, double p, float diff){
        drinkName = d;
        mainLiquor = m;
        servingSize = s;
        percentAlcohol = p;
        difficultyLevel = diff;
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
}
