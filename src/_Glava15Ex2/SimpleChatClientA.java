package _Glava15Ex2;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SimpleChatClientA {
    JTextField outgoing;
    PrintWriter writer;
    Socket clientSocket;
    
    public static void main(String[] args) {
        new SimpleChatClientA().go();
    }
    
    public void go() {//Создаем GUI и подключаем служателя к кнопке Send.   А так же вызываем метод setUpNetwirking
        JFrame frame = new JFrame("Ludycrously Simple Chat Client");
        JPanel mainPanel = new JPanel();
        frame.getContentPane().add(mainPanel, BorderLayout.CENTER);
        outgoing = new JTextField(20);
        JButton sendButton = new JButton("Send");
        sendButton.addActionListener(new SendButtonListener());
        mainPanel.add(outgoing);
        mainPanel.add(sendButton);
        
        setUpNetwirking();
        
        frame.setBounds(50, 50, 400, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }//go
    
    private void setUpNetwirking(){//создаем сокет и PrintWriter
        try {
        clientSocket = new Socket("127.0.0.1", 5000);
        writer = new PrintWriter(clientSocket.getOutputStream());
        System.out.println("networking established ");
        } catch (IOException ex) {
            Logger.getLogger(SimpleChatClientA.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//setUpNetwirking
    
    public class SendButtonListener implements ActionListener{

        public void actionPerformed(ActionEvent e) {//Текст из текстового поля отправляем на сервер с помощьюPrintWriter
            System.out.println("Send");
            writer.println(outgoing.getText());
            writer.flush();
            writer.close();
            outgoing.setText("");
            outgoing.requestFocus();
        }
    }//SendButtonListener
    
}//SimpleChatClientA