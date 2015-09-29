package _Glava12Ex2;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JButton;

public class MyFrame2Test {
    JFrame frame;
    MyDrawPanel panel;
    JButton buttonToPanel;
    JButton buttonToLabel;
    JLabel label;
    
    public static void main(String[] args) {
        MyFrame2Test test = new MyFrame2Test();
        test.go();
    }
    
    void go(){
        //Создаем основной фрейм
        frame = new JFrame("Fjodorov project");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 500, 500);
        frame.setVisible(true);
        
        //Создаем панель для рисования и добавляем её во фрейм
        panel = new MyDrawPanel();
        panel.setBounds(50, 50, 200, 200);
        panel.setVisible(true);
        panel.setBackground(Color.CYAN);
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        
        //Добавляем кнопку для панели в южную часть фрейма, подключаем к ней слушателя
        buttonToPanel = new JButton("Перерисовать");
        frame.getContentPane().add(buttonToPanel, BorderLayout.SOUTH);
        buttonToPanel.addActionListener(new ButtonToPanel_Listener());
        
        //Добавляем надпись в западную часть фрейма, подключаем к ней слушателя
        label = new JLabel("Сработает?", JLabel.CENTER);    
        frame.getContentPane().add(label, BorderLayout.WEST);
        
        //Добавляем кнопку для панели в южную часть фрейма, подключаем к ней слушателя
        buttonToLabel = new JButton("Число от 1 до 9");
        frame.getContentPane().add(buttonToLabel, BorderLayout.NORTH);
        buttonToLabel.addActionListener(new ButtonToLabel_Listener());
        
    }
    
    //Создаем класс-наблюдатель за кнопкой buttonToPanel
    public class ButtonToPanel_Listener implements ActionListener{
        public void actionPerformed(ActionEvent ev){
            panel.repaint();
        }
    }   
    //Создаем класс-наблюдатель за кнопкой buttonToLabel
    public class ButtonToLabel_Listener implements ActionListener{
        public void actionPerformed(ActionEvent ev){
            int random = (int) (Math.random() * 10);
            label.setText("Да! " + random);
        }
    }  
}