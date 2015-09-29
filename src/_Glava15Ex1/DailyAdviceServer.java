package _Glava15Ex1;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DailyAdviceServer {
    
    String[] adviceList = {"Поешь", "Поспи", "Напейся", "Еще поспи"};
    
    public static void main(String[] args) {
        DailyAdviceServer server = new DailyAdviceServer();
        server.go();
    }
    
    public String getAdvice(){
        int rand = (int) (Math.random() * adviceList.length);
        return adviceList[rand];
    }//getAdvice
    
    public void go(){
        
        try {
            ServerSocket socketServer = new ServerSocket(4242);
            while (true){//Сервер входит в постоянный цикл ожидания (и обслуживания) клиентских подключений
                Socket socketToClient = socketServer.accept();//метод accept() блокирует приложение, пока не поступит запрос клиента, после чего возвращает сокет (на анонимном порту) для взаимодействия с клиентом
                PrintWriter writer = new PrintWriter(socketToClient.getOutputStream());
                writer.println(getAdvice());
                writer.close();
                System.out.println(getAdvice());
                
            }
            
        } catch (IOException ex) {
            Logger.getLogger(DailyAdviceServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//go
    
}//DailyAdviceServer