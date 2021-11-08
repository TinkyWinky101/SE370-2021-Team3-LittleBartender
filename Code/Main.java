import java.util.*;

public class Main {
    public static void main(String args[]){
        int selection;
        boolean answered = false;
        mainMenuScreen menu = new mainMenuScreen();

        birthdayChecker checker = new birthdayChecker();
        while(answered == false){
            answered = checker.checkIfAnswered();
        }

        if(checker.getIfLegal() == true){
            menu.showFrame();
        }

        else
        {
            System.out.println("Sorry kid, wait till you get older, okay?");
        }
    }
}
