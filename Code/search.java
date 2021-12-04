// import javax.swing.*;
// import java.awt.event.*;
// import java.awt.*;
// import java.util.*;

// public abstract class search{
//     private int doesExist = -1;
//     private String userInput;
//     private JFrame frame;
//     private ArrayList<String> data;
    

//     public int checkIfExist(String key){
//         for(int i = 0; i > data.size(); i++){
//             if(data.get(i) == key){
//                 return i;
//             }
//         }
//         return -1;
        
//     }

//     public void displayList(JPanel panel, ArrayList<String> list){
//         JList display = new JList(list);
//         display.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//         display.setLayoutOrientation(JList.VERTICAL);
//         display.setVisibleRowCount(-1);
//         JScrollPane listScroller = new JScrollPane(display);
//         listScroller.setPreferedSize(new Dimension(250, 80));

//         panel.add(listScroller);
//     }

    
// }