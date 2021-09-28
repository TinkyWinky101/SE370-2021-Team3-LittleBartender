// import javax.swing.ImageIcon;
// import javax.swing.JButton;
// import javax.swing.JFrame;
// import javax.swing.JLabel;
// import java.awt.Image;
// import java.awt.Color;
// import javax.swing.BorderFactory;
// import java.awt.Dimension;
// import java.awt.BorderLayout;
// import java.awt.GridLayout;
// import java.util.Random;

// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;




// import javax.swing.JPanel;

// public class ShuffleCards extends JFrame {
//     Dimension dimensions = new Dimension(2000,1000);
//     private CardPanel graphBG;
//     private JPanel[][] board = new JPanel[4][13];
//     String faces[];
//     String cards[][];


//         public ShuffleCards(){
//             graphBG = new CardPanel();
//             graphBG.setPreferredSize(dimensions); //set dimensions after declaration

//             JButton button = new JButton("Shuffle"); //create new JButton for the redraw button
//             graphBG.add(button, BorderLayout.NORTH); //apply it to the top of the Frame


//             add(graphBG);

//             pack(); //size everything in the JFrame
//             setVisible(true);
            
//             graphBG.setPreferredSize(new Dimension(600, 1976));
//             // graphBG.setLayout(new GridLayout(5, 13));
//             this.setTitle("Card Shuffler");

//             button.addActionListener(new ActionListener() {
//                 public void actionPerformed(ActionEvent Argument) { 
//                     for(int i = 0; i < 4; i++) {
//                         for(int j = 0; j < 13; j++) {
//                         Random random = new Random();
//                          ImageIcon icon = new ImageIcon("cards/" + cards[i][j]);
//                          Image scaleImage = icon.getImage().getScaledInstance(150, 150,Image.SCALE_DEFAULT);
//                          JLabel wIcon = new JLabel(new ImageIcon(scaleImage));
 
//                             int randomRow = random.nextInt(4);
//                             int randomColumn = random.nextInt(13);
//                             String cCard = cards[randomRow][randomColumn];
 
                           
//                             int altRandRow = random.nextInt(4);
//                             int altRandCol = random.nextInt(13);
//                             cards[altRandRow][altRandCol] = cCard;
                            
                           
//                             cards[randomRow][randomColumn] = cards[altRandRow][altRandCol];
 
//                             board[i][j].removeAll();
 
//                             board[i][j].add(wIcon);
//                             board[i][j].repaint();
//                         }
//                     }
//                     revalidate();
//                 }
//             });

//         }

//     public class CardPanel extends JPanel {{
//         cards = new String[4][13];
//         faces = new String[]{"Diamonds","Clubs","Spades","Hearts"};

//                    for(int suit = 0; suit < 4; suit++) {
//                     for(int value = 0; value < 13;value++) {
//                         if(value == 0) {
//                             cards[suit][value] = "Ace" + faces[suit] + ".png";  
//                         }else if(value == 10) {
//                             cards[suit][value] = "Jack" + faces[suit] + ".png";  
//                         }else if(value == 11) {
//                             cards[suit][value]= "Queen" + faces[suit] + ".png";  
//                         }else if(value == 12) {
//                             cards[suit][value] = "King" + faces[suit] + ".png";  
//                         }else {
//                             cards[suit][value] = (value + 1) + faces[suit] +".png";
//                         }
     
//                     }  
//                 }
        
        
//                 for(int i = 0; i < board.length; i++) {
//                                    for(int j = 0; j < board[i].length; j++) {
//                                        ImageIcon icon = new ImageIcon("cards/"+cards[i][j]);
//                                        Image scaleImage = icon.getImage().getScaledInstance(150, 150,Image.SCALE_DEFAULT);
//                                        JLabel wIcon = new JLabel(new ImageIcon(scaleImage));
                    
//                                        board[i][j] = new JPanel();
//                                        board[i][j].add(wIcon);
                    
//                                        add(board[i][j]);
                    
//                                        board[i][j].setBorder(BorderFactory.createLineBorder(Color.gray));
                    
                    
//                                    }
//                                }
//     }




//         public static void main(String[] args) {
//             new ShuffleCards();
//     }
// }
// }
