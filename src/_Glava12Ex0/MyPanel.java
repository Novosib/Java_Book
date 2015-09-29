package _Glava12Ex0;
import javax.swing.JPanel;
import java.awt.Panel;
import java.awt.Graphics;
import java.awt.Color;

public class MyPanel extends Panel{
        static int countMyPanel = 0;
        public void paint(Graphics g) {
        System.out.println("Метод paint(MyPanel): попадание № " + ++countMyPanel);
        int numColor;
        /*
        numColor = (int) (Math.random()*7);
        if (numColor == 0){g.setColor(Color.RED);}
        if (numColor == 1){g.setColor(Color.ORANGE);}
        if (numColor == 2){g.setColor(Color.YELLOW);}
        if (numColor == 3){g.setColor(Color.GREEN);}
        if (numColor == 4){g.setColor(Color.cyan);}
        if (numColor == 5){g.setColor(Color.BLUE);}
        if (numColor == 6){g.setColor(Color.MAGENTA);}
        g.fillRect(0, 0, getWidth(), getHeight());
        */
        //g.setColor(Color.red);
        // g.drawLine(25, 50, getWidth()-25, getHeight()-25); 
        //g.drawLine(25, getHeight()-25, getWidth()-25, 50); 
        /*g.drawRect(25, 50, getWidth()-50, getHeight()-75);
        g.setColor(Color.BLUE);
        g.drawOval(25, 50, getWidth()-50, getHeight()-75);
        g.setColor(Color.BLACK);
        g.drawString("PaintTest", getWidth()/2-20, 100);
        */
        //g.setClip(getWidth()/4, getWidth()/4, getWidth()/2, getWidth()/2);
        
        for (int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                numColor = i+j;
                //numColor = (int) (Math.random()*7);
                if (numColor == 0){g.setColor(Color.RED);}
                if (numColor == 1){g.setColor(Color.ORANGE);}
                if (numColor == 2){g.setColor(Color.YELLOW);}
                if (numColor == 3){g.setColor(Color.GREEN);}
                if (numColor == 4){g.setColor(Color.cyan);}
                if (numColor == 5){g.setColor(Color.BLUE);}
                if (numColor == 6){g.setColor(Color.MAGENTA);}
                g.fillRect(i*getWidth()/4 + (50-i*25), j*getHeight()/4 + (50-j*25), (getWidth()-100)/4, (getHeight()-100)/4);
                //g.fillRect(i*getWidth()/4, j*getHeight()/4, getWidth()/4, getHeight()/4);
            }
        }
        
    }
}