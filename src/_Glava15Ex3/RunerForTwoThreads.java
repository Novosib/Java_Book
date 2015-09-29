package _Glava15Ex3;

import java.util.logging.Level;
import java.util.logging.Logger;

public class RunerForTwoThreads implements Runnable{
    int k = 0;
    public static void main(String[] args) {
        RunerForTwoThreads runner = new RunerForTwoThreads();
        Thread alpha = new Thread(runner);
        Thread beta = new Thread(runner);
        alpha.setName("alpha");
        beta.setName("BETA");
        alpha.start();
        beta.start();
    }//main

    public void run() {
        for (int i = 0; i < 5; i++){
            String name = Thread.currentThread().getName();
            System.out.println(name + ",   k = " + ++k);
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(RunerForTwoThreads.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//run
    
}//RunerForTwoThreads