package _Glava12Ex5;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VanishReact {

    int x = 1, y = 1;
    
    public static void main(String[] args) {
        VanishReact gui = new VanishReact();
        gui.go();
    }//main
    
    void go() {
        JFrame frame = new JFrame("Vanish of Reactangle"); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setBounds(50, 50, 500, 310);
        MyDrawP drawP = new MyDrawP();
        frame.getContentPane().add(drawP, BorderLayout.CENTER);
        JButton button = new JButton("Vanish");
        frame.getContentPane().add(button, BorderLayout.SOUTH);
        
        for (int i = 0; i < 119; i++, x+=2, y++) {
            System.out.println("i = " + i + "; Width = " + drawP.getWidth() + "; Height = " + drawP.getHeight());
            drawP.repaint();
            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                Logger.getLogger(VanishReact.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }//go
    
    class MyDrawP extends JPanel {
        public void paintComponent(Graphics g){
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, this.getWidth(), this.getHeight());
            g.setColor(Color.BLUE);
            g.fillRect(x, y, getWidth()-2*x, this.getHeight()-2*y);
        }
    }
}//class VanishReact