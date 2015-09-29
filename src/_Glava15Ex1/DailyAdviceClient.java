package _Glava15Ex1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DailyAdviceClient {

    public static void main(String[] args) {
        DailyAdviceClient client = new DailyAdviceClient();
        client.go();
    }
    
    public void go(){
        try {
            Socket socketClient = new Socket("127.0.0.1", 4242);//Соелинение через порт 4242 - на том же компьютере, где выполняется данный код (localhost)
            InputStreamReader streamReader = new InputStreamReader(socketClient.getInputStream());
            BufferedReader reader = new BufferedReader(streamReader);
            String advice = reader.readLine();
            
            System.out.println("Сегдня тебе следует узнать вот что: " + advice);
            reader.close();
        } 
        catch (IOException ex) {
            Logger.getLogger(DailyAdviceClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//go
    
}//DailyAdviceClient