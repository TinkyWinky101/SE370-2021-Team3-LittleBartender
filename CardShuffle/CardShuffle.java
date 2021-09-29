import javax.swing.*;
import java.awt.*;
import java.util.Random;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CardShuffle extends JPanel{
   private JPanel[][] board = new JPanel[4][13];
   String cardFront[] = new String[]{"Clubs", "Diamonds","Hearts","Spades"};
   String cards[][];
   Random randomNum = new Random();

   public CardShuffle() {
    setBackground( new Color(0,153,0));
           setPreferredSize(new Dimension(300, 988));
           setLayout(new GridLayout(5, 13));
           cards = new String[4][13];
           for(int suit = 0; suit < 4; suit++) {
               for(int value = 0; value < 13; value++) {
                   switch(value){
                       case 0:
                       cards[suit][value]= "Queen" + cardFront[suit] + ".png";
                       break;

                       case 10:
                       cards[suit][value] = "King" + cardFront[suit] + ".png";
                        break;

                       case 11:
                       cards[suit][value] = "Ace" + cardFront[suit] + ".png"; 
                        break;

                       case 12:
                       cards[suit][value] = "Jack" + cardFront[suit] + ".png";
                        break;

                       default:            
                        cards[suit][value] = (value + 1) + cardFront[suit] +".png";
                        break;
                   }
               }  
           }

           for(int x = 0; x < board.length; x++) {
               for(int y = 0; y < board[x].length; y++) {
                   ImageIcon icon = new ImageIcon("cards/" + cards[x][y]);
                   Image Pic = icon.getImage().getScaledInstance(85, 85,Image.SCALE_DEFAULT);
                   JLabel overlay = new JLabel(new ImageIcon(Pic));

                   board[x][y] = new JPanel();
                   board[x][y].add(overlay);

                   add(board[x][y]);
                   board[x][y].setBackground(new Color(0,153,0));

               }
           }

           JButton button = new JButton("Shuffle"); //create shuffle button
           

           button.addActionListener(new ActionListener() {
               public void actionPerformed(ActionEvent Argument) {
                revalidate();
                   for(int y = 0; y < 4; y++) {
                       for(int j = 0; j < 13; j++) {

                        ImageIcon icon = new ImageIcon("cards/" + cards[y][j]);
                        Image replPic = icon.getImage().getScaledInstance(85, 85,Image.SCALE_DEFAULT);

                           int randomRow = randomNum.nextInt(4);
                           int randomColumn = randomNum.nextInt(13);
                           String cCard = cards[randomRow][randomColumn];

                          
                           int altRandRow = randomNum.nextInt(4);
                           int altRandCol = randomNum.nextInt(13);
                           
                           JLabel replUpst = new JLabel(new ImageIcon(replPic));
                           cards[randomRow][randomColumn] = cards[altRandRow][altRandCol];
                           cards[altRandRow][altRandCol] = cCard;



                           board[y][j].removeAll();

                           board[y][j].add(replUpst);
                           board[y][j].repaint();
                       }
                   }
               }
           });


   }

   public static void main(String[] a) {

       JFrame frame = new JFrame();
       frame.setSize(1000,500);
       frame.add(new CardShuffle());
       frame.setVisible(true);
   }
}