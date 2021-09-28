import javax.swing.*;
import java.awt.*;

public class CardShuffle extends JFrame {
    private JPanel greenBackGround;
    public CardShuffle(){
        greenBackGround = new JPanel();
        JButton shuffle = new JButton();
        greenBackGround.setBackground(Color.green);
        setSize(800, 900);
        setLocationRelativeTo(null);
        greenBackGround.add(shuffle);
        add(greenBackGround, BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args) throws Exception {
        new CardShuffle();
    }
}
