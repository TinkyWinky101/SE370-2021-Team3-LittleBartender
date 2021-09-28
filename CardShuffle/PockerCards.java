


// import java.awt.Color;
// import java.awt.Dimension;
// import java.awt.GridLayout;
// import java.awt.Image;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
// import java.util.Random;

// import javax.swing.BorderFactory;
// import javax.swing.ImageIcon;
// import javax.swing.JButton;
// import javax.swing.JFrame;
// import javax.swing.JLabel;
// import javax.swing.JPanel;

// public class PockerCards extends JPanel{

//    private static final long serialVersionUID = 1L;

//    //stores number of squares in the grid
//    private JPanel[][] squares;
//    JButton button = new JButton("Shuffle");
//    String cardsName[][];

//    //constructor of gridplay
//    public PockerCards() {
//        try {
//            //set grid layout
//            setLayout(new GridLayout(5, 13));

//            //set squares
//            squares = new JPanel[4][13];

//            //set bg color white
//            setBackground(Color.white);

//            setPreferredSize(new Dimension(150*4, 150*13));
//            cardsName = new String[4][13];
//            String faces[] = new String[]{"Clubs","Diamonds","Hearts","Spades"};
//            for(int i=0;i<4;i++) {
//                for(int j=0;j<13;j++) {
//                    if(j==0) {
//                        cardsName[i][j] = "Ace"+faces[i]+".png";  
//                    }else if(j==10) {
//                        cardsName[i][j] = "Joker"+faces[i]+".png";  
//                    }else if(j==11) {
//                        cardsName[i][j] = "Queen"+faces[i]+".png";  
//                    }else if(j==12) {
//                        cardsName[i][j] = "King"+faces[i]+".png";  
//                    }else {
//                        cardsName[i][j] = (j+1)+faces[i]+".png";
//                    }

//                }  
//            }
//            //loop for all grid
//            for(int i = 0; i < squares.length; i++) {
//                for(int j = 0; j < squares[i].length; j++) {
//                    ImageIcon icon = new ImageIcon("cards/"+cardsName[i][j]);
//                    Image scaleImage = icon.getImage().getScaledInstance(150, 150,Image.SCALE_DEFAULT);
//                    JLabel wIcon = new JLabel(new ImageIcon(scaleImage));

//                    //add panel
//                    squares[i][j] = new JPanel();
//                    squares[i][j].add(wIcon);


//                    add(squares[i][j]);
//                    final int iCopy = i;
//                    final int jCopy = j;

//                    //set color black
//                    squares[iCopy][jCopy].setBackground(Color.black);

//                    //set border gray
//                    squares[i][j].setBorder(BorderFactory.createLineBorder(Color.gray));


//                }
//            }
//            add(button);

//            button.addActionListener(new ActionListener() {

//                @Override
//                public void actionPerformed(ActionEvent arg0) {
//                    Random rand = new Random();
//                    for(int i=0;i<4;i++) {
//                        for(int j=0;j<13;j++) {
//                            int row = rand.nextInt(4);
//                            int col = rand.nextInt(13);
                          
//                            int row1 = rand.nextInt(4);
//                            int col1 = rand.nextInt(13);
                          
//                            String name = cardsName[row][col];
//                            cardsName[row][col] = cardsName[row1][col1];
//                            cardsName[row1][col1] = name;
                      
//                            squares[i][j].removeAll();
//                            ImageIcon icon = new ImageIcon("cards/"+cardsName[i][j]);
//                            Image scaleImage = icon.getImage().getScaledInstance(150, 150,Image.SCALE_DEFAULT);
//                            JLabel wIcon = new JLabel(new ImageIcon(scaleImage));
//                            squares[i][j].add(wIcon);
//                            squares[i][j].repaint();
//                        }
//                    }
//                    revalidate();
//                }
//            });
//        }catch(Exception e) {
//            e.printStackTrace();
//        }

//    }

//    public static void main(String[] a) {

//        JFrame window = new JFrame();
//        window.setSize(2000,1000);
//        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//        //add frame to main class
//        window.getContentPane().add(new PockerCards());
//        window.setVisible(true);
//    }

// }