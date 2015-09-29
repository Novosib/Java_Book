package _Glava15Ex3;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MyRunnableTestDrive {

    public static void main(String[] args) {
        Runnable job = new MyRunnable();
        Thread t = new Thread(job);
        t.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(MyRunnable.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Вернулись в метод main");
    }
    
}//ThreadTestDrive