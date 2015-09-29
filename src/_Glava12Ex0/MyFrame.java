package _Glava12Ex0;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import java.awt.Frame;
import java.awt.GraphicsConfiguration;

public class MyFrame extends JFrame {
    public MyFrame(){super();}
    public MyFrame(GraphicsConfiguration gc){super(gc);}
    public MyFrame(String title){super(title);}
    public MyFrame(String title,GraphicsConfiguration gc){super(title, gc);}
    
    
static int countMyFrame = 0;    
    public void paint(Graphics g) {
        System.out.println("Метод paint (MyFrame): попадание № " + ++countMyFrame);
        g.setColor(Color.red);
        /*
        g.drawLine(25, 50, getWidth()-25, getHeight()-25); 
        g.drawLine(25, getHeight()-25, getWidth()-25, 50); 
        g.drawRect(25, 50, getWidth()-50, getHeight()-75);
        g.setColor(Color.BLUE);
        g.drawOval(25, 50, getWidth()-50, getHeight()-75);
        g.setColor(Color.BLACK);
        g.drawString("PaintTest", getWidth()/2-20, 100);
        */
    }
    
}