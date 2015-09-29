package _Glava12Ex0;
import javax.swing.JPanel;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public class MyCanvas extends Canvas {
    static int countMyCanvas = 0;
    public void paint(Graphics g) {
        System.out.println("Метод paint(MyCanvas): попадание № " + ++countMyCanvas);
        g.setColor(Color.WHITE);
        int height = getHeight(), width = getWidth();
        g.drawLine(0, height/2-1, width, height/2-1);
        g.drawLine(0, height/2, width, height/2);
        g.drawLine(0, height/2+1, width, height/2+1);
// Вычисляем масштаб таким образом, чтобы на компоненте всегда умещалось 5 периодов
        double k = (2 * Math.PI * 5) / width;
        int sy = calcY(0, width, height, k);
        for (int i=1; i < width; i++) {
        int nsy = calcY(i, width, height, k);
        g.drawLine(i-1, sy, i, nsy);
        sy=nsy;
        }
    }
    private int calcY(int x, int width, int height, double k) {
        double dx = (x - width/2.) * k;
        return (int)( height/2. * (1 - Math.sin(dx)) );
    }
}