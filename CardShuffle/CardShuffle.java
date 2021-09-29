
import javax.swing.*;
import java.awt.*;
import java.util.Random;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CardShuffle extends JPanel{
   private JPanel[][] board = new JPanel[4][13];
   String cards[][];
  

   public CardShuffle() {
        setBackground( new Color(0,153,0));   
        setPreferredSize(new Dimension(600, 1976));
        setLayout(new GridLayout(5, 13));
        cards = new String[4][13];
        String faces[] = new String[]{"Clubs","Diamonds","Hearts","Spades"};
           for(int suit = 0; suit < 4; suit++) {
               for(int value = 0; value < 13;value++) {
                   switch(value){
                       case 0:
                        cards[suit][value] = "Ace" + faces[suit] + ".png"; 
                        break;

                       case 10:
                        cards[suit][value] = "Jack" + faces[suit] + ".png";
                        break;

                       case 11:
                        cards[suit][value]= "Queen" + faces[suit] + ".png";
                        break;

                       case 12:
                        cards[suit][value] = "King" + faces[suit] + ".png";
                        break;


                       default:            
                        cards[suit][value] = (value + 1) + faces[suit] +".png";
                        break;
                   }
                //    if(value == 0) {
                //        cards[suit][value] = "Ace" + faces[suit] + ".png";  
                //    }else if(value == 10) {
                //        cards[suit][value] = "Jack" + faces[suit] + ".png";  
                //    }else if(value == 11) {
                //        cards[suit][value]= "Queen" + faces[suit] + ".png";  
                //    }else if(value == 12) {
                //        cards[suit][value] = "King" + faces[suit] + ".png";  
                //    }else {
                //        cards[suit][value] = (value + 1) + faces[suit] +".png";
                //    }

               }  
           }




           for(int i = 0; i < board.length; i++) {
               for(int j = 0; j < board[i].length; j++) {
                   ImageIcon icon = new ImageIcon("cards/"+cards[i][j]);
                   Image scaleImage = icon.getImage().getScaledInstance(150, 150,Image.SCALE_DEFAULT);
                   JLabel wIcon = new JLabel(new ImageIcon(scaleImage));

                   board[i][j] = new JPanel();
                   board[i][j].add(wIcon);

                   add(board[i][j]);
                   board[i][j].setBackground( new Color(0,153,0));

                   board[i][j].setBorder(BorderFactory.createLineBorder(Color.gray));


               }
           }
           JButton button = new JButton("Shuffle"); //create shuffle button
           add(button, BorderLayout.SOUTH); //apply it to the top of the Frame

           button.addActionListener(new ActionListener() {
               public void actionPerformed(ActionEvent Argument) {
                   Random rand = new Random();
                   for(int i = 0; i < 4; i++) {
                       for(int j = 0; j < 13; j++) {

                        ImageIcon icon = new ImageIcon("cards/" + cards[i][j]);
                        Image scaleImage = icon.getImage().getScaledInstance(150, 150,Image.SCALE_DEFAULT);
                        JLabel wIcon = new JLabel(new ImageIcon(scaleImage));

                           int randomRow = rand.nextInt(4);
                           int randomColumn = rand.nextInt(13);
                           String cCard = cards[randomRow][randomColumn];

                          
                           int altRandRow = rand.nextInt(4);
                           int altRandCol = rand.nextInt(13);
                           
                          
                           cards[randomRow][randomColumn] = cards[altRandRow][altRandCol];
                           cards[altRandRow][altRandCol] = cCard;

                           board[i][j].removeAll();

                           board[i][j].add(wIcon);
                           board[i][j].repaint();
                       }
                   }
                   revalidate();
               }
           });


   }

   public static void main(String[] a) {

       JFrame window = new JFrame();
       window.setSize(2000,1000);
       window.getContentPane().add(new CardShuffle());
    //    window.setForeground(Color.GREEN);
       window.setVisible(true);
   }

}