package _Glava13Ex3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;

public class JTest_3 {

    JFrame frame;
    JPanel panel1;//Панель для текстового поля
    JPanel panel2;//Панель для текстовой области
    JPanel panel3;//Панель для кнопок
    JButton buttonChange;
    JLabel label;
    JCheckBox box;
    
    public static void main(String[] args) {
        JTest_3 gui = new JTest_3();
        gui.go();
    }
    
    void go(){
        frame = new JFrame("JTest 2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setBounds(100, 50, 450, 300);
        
        panel1 = new JPanel();
        panel1.setBackground(Color.GRAY);
        frame.getContentPane().add(panel1,BorderLayout.NORTH);
        
        panel2 = new JPanel();
        panel2.setBackground(Color.DARK_GRAY);
        frame.getContentPane().add(panel2,BorderLayout.CENTER);
       
        panel3 = new JPanel();
        panel3.setBackground(Color.LIGHT_GRAY);
        frame.getContentPane().add(panel3,BorderLayout.SOUTH);
        
        buttonChange = new JButton("Включить/Выключить");
        buttonChange.addActionListener(new MyButtonChangeListener());
        panel3.add(buttonChange);
        
        label = new JLabel("Признак: ");
        panel1.add(label);
        
        box = new JCheckBox("Включи меня!");
        box.addActionListener(new MyBoxListener());
        box.addItemListener(new CheckListener());
        panel1.add(box);
        
    }
    
    class MyButtonChangeListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println("MyButtonBoxListener: меняем состояние");
            if (box.isSelected()) {
                box.setSelected(false);
            } else {
                box.setSelected(true);
            }
        }
    }
    class CheckListener implements ItemListener {
        public void itemStateChanged(ItemEvent e) {
            if (box.isSelected()) {
                System.out.println("CheckListener. Проверка: признак включен!!");
            } else {
                System.out.println("CheckListener. Проверка: признак выключен...");
            }
        }
    }
    class MyBoxListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println("MyBoxListener: ");
            System.out.println("Ого! Изменили состояние крыжика!");
        }
    }
    
}//class