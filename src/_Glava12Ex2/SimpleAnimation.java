package _Glava12Ex2;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SimpleAnimation {    
    int x = 0, y = 00;
    JFrame frame;
    DrawPanel panel;
    
    public static void main(String[] args) {
        SimpleAnimation gui = new SimpleAnimation();
        gui.go();
    }//main
    
    void go(){
        frame = new JFrame("Simple animation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 400, 400);
        frame.setVisible(true);
        
        panel = new DrawPanel();
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        
        for (int i = 0; i < frame.getWidth()-100; i++){
            x++; y++;
            panel.repaint();
            
            try {
                Thread.sleep(20);
            } catch (Exception ex){System.out.println("Попали в исключение в методе SimpleAnimation.go()");}
        }//for
        
    }//go
    
    class DrawPanel extends JPanel {
        public void paintComponent (Graphics g){
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, this.getWidth(), this.getHeight());
            
            int red, green, blue;
            Color myColor ;
            red = (int) (Math.random() * 255);
            green = (int) (Math.random() * 255);
            blue = (int) (Math.random() * 255);
            myColor = new Color(red, green, blue);
            
            g.setColor(myColor);
            g.fillOval(x, y, 60, 60);
        }//paintComponent 
    }//class DrawPanel
    
}// class SimpleAnimation