import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.Year;
import java.util.*;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

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
    // NEW one
    
    public birthdayChecker(){
        JFrame frame = new JFrame("LittleBartender");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(693,332,500,300);
        ImageIcon myImage = new ImageIcon("./LittleBartender_Icon.png");
		frame.setIconImage(myImage.getImage());

        ImageIcon image = new ImageIcon("./LittleBartender_bkImage.png");
        JLabel imageLabel = new JLabel(image);
        frame.add(imageLabel);     
        
        imageLabel.setLayout(new FlowLayout(1, 0, 105));
       
        JPanel panel = new JPanel();
        panel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder()));
        panel.setBackground(new Color(54,32,32));        

        JLabel askForYear = new JLabel("Enter your date of birth:");
        askForYear.setForeground(Color.white);
        panel.add(askForYear);
    
        //
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
        panel.add(btn);

        imageLabel.add(panel);

        frame.setVisible(true);
        
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                month = cm.getSelectedIndex() + 1;
                day = cd.getSelectedIndex() + 1;
                year = CURRENT_YEAR - cy.getSelectedIndex();
                revalidate();
                isLegalAdult = checkIfLegal();
                didAnswer = true;
                frame.dispose(); //close whether or not isLegalAdult()
                
            }
        });
    }
}