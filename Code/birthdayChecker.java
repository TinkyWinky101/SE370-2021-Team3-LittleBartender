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
    public final int LEGAL_YEAR = 2000;

    private boolean checkIfLegal(){
        if(year <= LEGAL_YEAR){
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        JFrame frame = new JFrame("A Simple GUI");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frame.setLayout(null);
        frame.setSize(500, 500);
        frame.setLocation(430, 100);

        JPanel panel = new JPanel();

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
        for(int i = 0; i < 12; i++){
            month[i] = String.valueOf(i + 1);
        }

        String[] day = new String[31];
        for(int i = 0; i < 31; i++){
            day[i] = String.valueOf(i + 1);
        }

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
        panel.add(btn);

    }
}
