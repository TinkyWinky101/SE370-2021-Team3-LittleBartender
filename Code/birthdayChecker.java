import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class birthdayChecker extends JPanel {
    private int month;
    private int day;
    private int year;
    public final int CURRENT_YEAR = 2020;
    

    // private bool ifLegal(){
    //     if(year >= 
    // }

    public static void main(String[] args){
        JFrame frame = new JFrame("A Simple GUI");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLocation(430, 100);

        JPanel panel = new JPanel();

        frame.add(panel);

        JLabel lbl = new JLabel("Select one of the possible choices and click OK");
        lbl.setVisible(true);

        panel.add(lbl);

        String[] choices = { "CHOICE 1","CHOICE 2", "CHOICE 3","CHOICE 4","CHOICE 5","CHOICE 6"};

        final JComboBox<String> cb = new JComboBox<String>(choices);

        cb.setVisible(true);
        panel.add(cb);

        JButton btn = new JButton("OK");
        panel.add(btn);

    }
}
