import java.util.*;

public class Main {
    public static void main(String args[]) throws InterruptedException{
        int selection;
        boolean answered = false;
        mainMenuScreen menu = new mainMenuScreen();

        birthdayChecker checker = new birthdayChecker();
        while(answered == false){
            //sleep thread add
            Thread.sleep(4000);
            answered = checker.didAnswer;
        }

        if(checker.getIfLegal()){
           menu.showFrame();
        }
    }
}
