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
    public boolean didAnswer = false;
    public static Calendar currentDate = Calendar.getInstance();
    public static int CURRENT_YEAR = currentDate.get(Calendar.YEAR);
    public final int LEGAL_YEAR = CURRENT_YEAR - 21;

    private boolean checkIfLegal(){
        if(year < LEGAL_YEAR){
            return true;
        }
        if(year == LEGAL_YEAR){
            if (month > currentDate.get(Calendar.MONTH)){
                return true;
            }
            else if(month == currentDate.get(Calendar.MONTH)){
                if(day >= currentDate.get(Calendar.DATE)){
                    return true;
                }
            }
        }
        return false;
    }

    public int convertFromStringToInt(String input){
        return Integer.parseInt(input);
    }

    public static void fillDateArrayGeneric(String[] array, int n){
        for(int i = 0; i < n; i++){
            array[i] = String.valueOf(i+1);
        }
    }

    public int getMonth(){
        return month;
    }

    public int getDay(){
        return day;
    }

    public int getYear(){
        return year;
    }

    public boolean getIfLegal(){
        return isLegalAdult;
    }

    public boolean checkIfAnswered(){
        return didAnswer;
    }

    public birthdayChecker(){
        JFrame frame = new JFrame("Can You Drink");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 500);

        JPanel panel = new JPanel();
        // panel.setLayout(new GridLayout(5,1));
        frame.add(panel);

        JLabel askForYear = new JLabel("What is your birth day?");
        askForYear.setVisible(true);

        panel.add(askForYear);

        String[] yearSelection = new String[80];
        for(int i = 0; i < 80; i++){
            int calculatedYear = CURRENT_YEAR - i;
            yearSelection[i] = String.valueOf(calculatedYear);
        }

        String[] monthSelection = new String[12];
        fillDateArrayGeneric(monthSelection, 12);

        String[] daySelection = new String[31];
        fillDateArrayGeneric(daySelection, 31);

        //refactor the following
        final JComboBox<String> cm = new JComboBox<String>(monthSelection);

        cm.setVisible(true);
        panel.add(cm);

        final JComboBox<String> cd = new JComboBox<String>(daySelection);

        cd.setVisible(true);
        panel.add(cd);

        final JComboBox<String> cy = new JComboBox<String>(yearSelection);

        cy.setVisible(true);
        panel.add(cy);

        JButton btn = new JButton("OK");
        // btn.actionListener(this);
        panel.add(btn);

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                // String inputMonth = cm.getSelectedItem().toString();
                // String inputDay = cd.getSelectedItem().toString();
                // String inputYear = cy.getSelectedItem().toString();
                // month = convertFromStringToInt(inputMonth);
                // day = convertFromStringToInt(inputDay);
                // year = convertFromStringToInt(inputYear);
                month = cm.getSelectedIndex() + 1;
                day = cd.getSelectedIndex() + 1;
                year = CURRENT_YEAR - cy.getSelectedIndex();
                revalidate();
                isLegalAdult = checkIfLegal();
                didAnswer = true;
                // System.out.println(isLegalAdult);
                frame.dispose(); //close whether or not isLegalAdult()
                
            }
        });

        
    }
}
