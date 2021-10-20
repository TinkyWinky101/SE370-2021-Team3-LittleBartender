import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.Year;
import java.util.*;

public class birthdayChecker extends JPanel {
    private int month;
    private int day;
    private int year;
    private boolean isLegalAdult = false;
    public static Calendar currentDate = Calendar.getInstance();
    public static int CURRENT_YEAR = currentDate.get(Calendar.YEAR);
    public final int LEGAL_YEAR = CURRENT_YEAR - 21;

    private boolean checkIfLegal(){
        if(year <= LEGAL_YEAR){
            return true;
        }
        return false;
    }

    public static void fillDateArrayGeneric(String[] array, int n){
        for(int i = 0; i < n; i++){
            array[i] = String.valueOf(i+1);
        }
    }



    public static void initializeBox(){
        JFrame frame = new JFrame("Can You Drink");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        JPanel panel = new JPanel();
        // panel.setLayout(new GridLayout(5,1));
        frame.add(panel);

        JLabel askForYear = new JLabel("What is your birth day?");
        askForYear.setVisible(true);

        panel.add(askForYear);

        String[] year = new String[80];
        for(int i = 0; i < 80; i++){
            int calculatedYear = CURRENT_YEAR - i;
            year[i] = String.valueOf(calculatedYear);
        }

        String[] month = new String[12];
        fillDateArrayGeneric(month, 12);

        String[] day = new String[31];
        fillDateArrayGeneric(day, 31);

        //refactor the following
        final JComboBox<String> cm = new JComboBox<String>(month);

        cm.setVisible(true);
        panel.add(cm);

        final JComboBox<String> cd = new JComboBox<String>(day);

        cd.setVisible(true);
        panel.add(cd);

        final JComboBox<String> cy = new JComboBox<String>(year);

        cd.setVisible(true);
        panel.add(cy);

        JButton btn = new JButton("OK");
        // btn.actionListener(this);
        panel.add(btn);
    }
    
    // public void actionPerformed(ActionEvent e)

    public static void main(String[] args){

        initializeBox();
    }
}
