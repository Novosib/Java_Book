package _Glava12Ex1;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Label;

public class SimpleGui1B implements java.awt.event.ActionListener {
    
    JFrame frame;
    JButton button;
    Label label;
    static int amountOfPress = 0;
    
    public static void main(String[] args) {
        SimpleGui1B gui = new SimpleGui1B();
        gui.go();
    }
    
    void go() {
        frame = new JFrame();//создаём фрейм (окно)
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(200, 100, 400, 350);//Задаем граници-область фрейма (int x, int y, int width, int height)
        frame.setVisible(true);
        
        button = new JButton("Количество нажатий: " + amountOfPress);//создаем кнопку с текстом        
        button.setBounds(100,260,220, 20);
        button.setFont(new Font("Calibri", Font.ITALIC, 15));
        button.setForeground(Color.DARK_GRAY);//Цвет текста и всего что выводится на кнопке (кроме фона кнопки)
        button.addActionListener(this);// Регистрирем слушателя события ActionEvent
        frame.add(button);
        
        label = new Label("Тестируем кнопку", Label.CENTER);
        label.setBounds(50,50,100, 20);
        label.setFont(new Font("Calibri", Font.ITALIC, 15));
        frame.add(label);
    }
    
    public void actionPerformed(java.awt.event.ActionEvent e) {        
         button.setText("Количество нажатий: " + ++amountOfPress);
        System.out.println();
        System.out.print("Координаты: x = " + frame.getX() + " y = " + frame.getY());
        System.out.println("   Размеры: width = " + frame.getWidth() + " height = " + frame.getHeight());
        System.out.print("Видимость: visible = " + frame.isVisible());
        System.out.println("   Доступность: enabled = " + frame.isEnabled());
        
    }
    
}//class