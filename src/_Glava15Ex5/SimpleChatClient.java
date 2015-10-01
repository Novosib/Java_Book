package _Glava15Ex5;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class SimpleChatClient {
    JTextArea incoming;
    JTextField outgoing;
    BufferedReader reader;
    PrintWriter writer;
    Socket clientSocket;
    
    public static void main(String[] args) {
        new SimpleChatClient().go();
    }
    
    public void go() {//Создаем GUI и подключаем служателя к кнопке Send.   А так же вызываем метод setUpNetwirking
        JFrame frame = new JFrame("Ludycrously Simple Chat Client");
        JPanel mainPanel = new JPanel();
        frame.getContentPane().add(mainPanel, BorderLayout.CENTER);
        incoming = new JTextArea(15, 50);
        incoming.setLineWrap(true);
        incoming.setWrapStyleWord(true);
        incoming.setEditable(false);
        JScrollPane qSqroller = new JScrollPane(incoming);
        qSqroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        qSqroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        mainPanel.add(qSqroller);
        
        outgoing = new JTextField(20);
        JButton sendButton = new JButton("Send");
        sendButton.addActionListener(new SendButtonListener());
        mainPanel.add(outgoing);
        mainPanel.add(sendButton);
        
        setUpNetwirking();
        
        Thread readerThread = new Thread(new IncomingReader());//Запускаем новый поток, используя вложенны класс IncomingReader в качестве задачи
        readerThread.start();                                 //Его работа - чтение данных с сервера через сокет и вывод всех входящих сообщений в qScroller
        
        frame.setBounds(50, 50, 400, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }//go
    
    private void setUpNetwirking(){//создаем сокет и PrintWriter
        try {
        clientSocket = new Socket("127.0.0.1", 5000);//Будем использовать сокет для получения входящего и исходящего потоков
        
        InputStreamReader streamReader = new InputStreamReader(clientSocket.getInputStream());
        reader = new BufferedReader(streamReader);
        
        writer = new PrintWriter(clientSocket.getOutputStream());
        System.out.println("networking established ");
        
        } catch (IOException ex) {
            Logger.getLogger(SimpleChatClient.class.getName()).log(Level.SEVERE, null, ex);
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
    
    public class IncomingReader implements Runnable{

        public void run() {
            String message;
            try {
                while((message = reader.readLine()) != null){
                    System.out.println("read " + message);
                    incoming.append(message + "\n");
                }
            } catch (IOException ex) {
                Logger.getLogger(SimpleChatClient.class.getName()).log(Level.SEVERE, null, ex);
            }
        }//run
        
    }//IncomingReader
    
}//SimpleChatClientA