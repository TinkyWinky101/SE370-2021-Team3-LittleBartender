import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class birthdayChecker extends JPanel {
    private int month;
    private int day;
    private int year;
    private boolean isLegalAdult = false;
    public final static int CURRENT_YEAR = 2021;
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

        JLabel lbl = new JLabel("What is your birth year?");
        lbl.setVisible(true);

        panel.add(lbl);

        String[] choices = new String[50];
        for(int i = 0; i < 50; i++){
            int calculatedYear = CURRENT_YEAR - i;
            choices[i] = String.valueOf(calculatedYear);
        }

        final JComboBox<String> cb = new JComboBox<String>(choices);

        cb.setVisible(true);
        panel.add(cb);

        JButton btn = new JButton("OK");
        panel.add(btn);

    }
}
