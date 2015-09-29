package _Glava13Ex2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class JTest_2 {

    JFrame frame;
    JPanel panel1;//Панель для текстового поля
    JPanel panel2;//Панель для текстовой области
    JPanel panel3;//Панель для кнопок
    JButton buttonField;
    JButton buttonText;
    JLabel label;
    JTextField field;
    JTextArea text;
    JScrollPane scroller;
    
    public static void main(String[] args) {
        JTest_2 gui = new JTest_2();
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
        
        buttonField = new JButton("Вывести в лог и очистить");
        buttonField.addActionListener(new MyButtonFieldListener());
        panel3.add(buttonField);
        
        label = new JLabel("Текст: ");
        panel1.add(label);
        
        field = new JTextField("...", 20);
        field.addActionListener(new MyFieldListener());
        panel1.add(field);
        
        buttonText = new JButton("Текстовая область");
        buttonText.addActionListener(new MyButtonTextListener());
        panel3.add(buttonText);
        
        text = new JTextArea(10,20);
        text.setLineWrap(true);//Перенос строк
        text.setText("Текстовая область..");
        
        scroller = new JScrollPane(text);
        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        panel2.add(scroller);
    }
    
    class MyButtonFieldListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println("Текст из текстового поля:");
            System.out.println(field.getText());
            field.setText("");
            field.requestFocus();
            frame.repaint();
        }
    }
    
    class MyButtonTextListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            text.append("\n ");
            text.append("Кнопка нажата");
            text.requestFocus();
        }
    }
    
    class MyFieldListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println("Нажали Enter, принят текст:");
            System.out.println(field.getText());
        }
    }
    
}//class