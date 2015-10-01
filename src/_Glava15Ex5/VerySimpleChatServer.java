package _Glava15Ex5;

import java.util.ArrayList;

public class VerySimpleChatServer {

    ArrayList clientOutputStreams;
    
    public class ClientHandler implements Runnable{//Обработчик клиентов
        
        public void run() {
            
        }//run
        
    }//ClientHandler
    
    public static void main(String[] args) {
        new VerySimpleChatServer().go();
    }//main
    
    public void go(){
        
    }//go
    
    public void tellEveryone(String massage){//Отправить сообщение всем клиентам чата
        
    }//tellEveryone
    
}