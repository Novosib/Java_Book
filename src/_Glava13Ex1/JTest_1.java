package _Glava13Ex1;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.*;

public class JTest_1 {

    JFrame frame;
    JPanel panel;
    JButton buttonOne;
    JButton buttonTwo;
    JButton buttonThree;
    
    public static void main(String[] args) {
        JTest_1 gui = new JTest_1();
        gui.go();
    }
    
    void go(){
        frame = new JFrame("JTest");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setBounds(100, 50, 300, 200);
        
        panel = new JPanel();
        panel.setBackground(Color.DARK_GRAY);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        buttonOne = new JButton("Shock me");
        buttonTwo = new JButton("Bliss");
        buttonThree = new JButton("huh");
        panel.add(buttonOne);
        panel.add(buttonTwo);
        panel.add(buttonThree);
        
        frame.getContentPane().add(panel,BorderLayout.EAST);
    }
    
}//class