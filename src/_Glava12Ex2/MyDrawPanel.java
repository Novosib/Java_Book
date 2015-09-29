package _Glava12Ex2;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Panel;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class MyDrawPanel extends JPanel{
    static int numOfpaint = 0;
    
    public void paintComponent(Graphics g1D){
        Graphics2D g = (Graphics2D) g1D;
        System.out.println("Зашли в метод PaintComponent (panel) : № " + ++numOfpaint);
        g.setPaint(Color.LIGHT_GRAY);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        //Задаем градиент двух случайных цветов:
        Color startColor;
        int red = (int) (Math.random() * 255);
        int green = (int) (Math.random() * 255);
        int blue = (int) (Math.random() * 255);
        startColor = new Color(red, green, blue);
        
        Color endColor ;
        red = (int) (Math.random() * 255);
        green = (int) (Math.random() * 255);
        blue = (int) (Math.random() * 255);
        endColor = new Color(red, green, blue);
        
        GradientPaint gradient2 = new GradientPaint(70, 70, startColor, 240, 240, endColor);
        g.setPaint(gradient2);
        g.fillOval(65, 90, 250, 250);
        
    }
    
}