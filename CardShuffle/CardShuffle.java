import javax.swing.*;
import java.awt.*;
import java.util.Random;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



import javax.swing.JPanel;

public class CardShuffle extends JFrame {
    Dimension dimensions = new Dimension(1100, 520);
    private CardPanel graphBG;
    private JPanel[][] board = new JPanel[4][13];
    String faces[];
    String cards[][];


        public CardShuffle(){
            graphBG = new CardPanel();
            graphBG.setPreferredSize(dimensions); //set dimensions after declaration

            JButton button = new JButton("Shuffle"); //create new JButton for the redraw button
            getContentPane().add(button, BorderLayout.SOUTH); //apply it to the top of the Frame

            graphBG.setBackground(new Color(0, 153, 0));

            add(graphBG);

            pack(); //size everything in the JFrame
            setVisible(true);
            
            graphBG.setPreferredSize(new Dimension(400, 1317));
            // graphBG.setLayout(new GridLayout(5, 13));
            this.setTitle("Card Shuffler");

            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent Argument) { 
                    for(int x = 0; x < 4; x++) {
                        for(int y = 0; y < 13; y++) {
                        Random random = new Random();

 
                            int randomRow = random.nextInt(4);
                            int randomColumn = random.nextInt(13);
                            String cCard = cards[randomRow][randomColumn];
 
                           
                            int altRandRow = random.nextInt(4);
                            int altRandCol = random.nextInt(13);
                            
                           
                            cards[randomRow][randomColumn] = cards[altRandRow][altRandCol];
                            cards[altRandRow][altRandCol] = cCard;

                            board[x][y].removeAll();
                            ImageIcon icon = new ImageIcon("cards/" + cards[x][y]);
                            Image scaleImage = icon.getImage().getScaledInstance(85, 85,Image.SCALE_DEFAULT);
                            JLabel wIcon = new JLabel(new ImageIcon(scaleImage));
 
                            board[x][y].add(wIcon);
                            board[x][y].repaint();
                        }
                    }
                    revalidate();
                }
            });

        }

    public class CardPanel extends JPanel {{
    cards = new String[4][13];
   String cardFront[] = new String[]{"Diamonds","Clubs","Spades","Hearts",};

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
        }




            public static void main(String[] args) {
                new CardShuffle();
        }
    }
}
