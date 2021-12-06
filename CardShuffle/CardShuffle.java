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
            this.setTitle("Card Shuffler");

            button.addActionListener(new ActionListener() { //action listened on Shuffle button
                @Override
                public void actionPerformed(ActionEvent Argument) { 
                    for(int x = 0; x < 4; x++) { //loop board 4x13
                        for(int y = 0; y < 13; y++) {
                        Random random = new Random();

 
                            int randomRow = random.nextInt(4); //retrieve random row location
                            int randomColumn = random.nextInt(13); //retrieve random column location
                            String cCard = cards[randomRow][randomColumn]; // new card coordniates
 
                           
                            int altRandRow = random.nextInt(4); //asme as above
                            int altRandCol = random.nextInt(13);
                            
                           //set location of new cards so that we can reshuffle the deck
                            cards[randomRow][randomColumn] = cards[altRandRow][altRandCol];
                            cards[altRandRow][altRandCol] = cCard;

                            //remove all old locations
                            board[x][y].removeAll();
                            //find card file and grab images from the deck
                            ImageIcon pathToCard = new ImageIcon("cards/" + cards[x][y]);
                            //resize image for jpanel viewing so it doesn't take up all the space
                            Image replBG = pathToCard.getImage().getScaledInstance(85, 85,Image.SCALE_DEFAULT);

                            JLabel newBG= new JLabel(new ImageIcon(replBG));
                            board[x][y].add(newBG); //add new pictures in location
                            board[x][y].repaint(); //repaint the component as you do when refreshing a Jpanel/JFrame
                        }
                    }
                    revalidate(); //revalidate up to highest root
                }
            });

        }

    public class CardPanel extends JPanel {{
    cards = new String[4][13];
   String cardFront[] = new String[]{"Diamonds","Clubs","Spades","Hearts",}; //possible card suits from naming convention in the file

        for(int suit = 0; suit < 4; suit++) { //loop board 4x13
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
                      cards[suit][value] = (value + 1) + cardFront[suit] +".png"; //all other cards other than named/royal cards
                      break;
                 }
            }  
        }
        
        
            for(int x = 0; x < board.length; x++) { //loop board 4x13
                for(int y = 0; y < board[x].length; y++) {

                    //find card file and grab images from the deck
                    ImageIcon pathToCard = new ImageIcon("cards/" + cards[x][y]); 
                    //resize image for jpanel viewing so it doesn't take up all the space
                    Image Pic = pathToCard.getImage().getScaledInstance(85, 85,Image.SCALE_SMOOTH);
                    board[x][y] = new JPanel();

                    JLabel overlay = new JLabel(new ImageIcon(Pic));
                    board[x][y].add(overlay); //add image labels to the board in the spot

                    add(board[x][y]);
                    board[x][y].setBackground(new Color(0,153,0)); //set panel background to "vega dealer" green
                }
            }
        }




            public static void main(String[] args) {
                new CardShuffle();
        }
    }
}
