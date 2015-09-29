package _Glava15Ex4;

import java.util.logging.Level;
import java.util.logging.Logger;

public class RyanAndMonicaJob implements Runnable{
    
    private BankAccount account = new BankAccount();
    
    public static void main(String[] args) {
        RyanAndMonicaJob job = new RyanAndMonicaJob();
        Thread ryan = new Thread(job);
        Thread monica = new Thread(job);
        ryan.setName("Райан");
        monica.setName("Моника");
        ryan.start();
        monica.start();
    }//main

    public void run() {
        for(int i = 0; i < 10; i++){
            makeWithdrawal(10);
            
            if (account.getBalance() < 0){
                System.out.println("!!! Превышение лимита !!!");
            } else {
                System.out.println();
                System.out.println("Бананс все еще >= 0: " + account.getBalance());
            }
        }//for
    }//run
    
    private void makeWithdrawal(int amount){
        if(account.getBalance() >= amount){
            System.out.println(Thread.currentThread().getName() + " Собирается снять деньги " + account.getBalance());
            try {
                System.out.println(Thread.currentThread().getName() + " идет подремать...... " + account.getBalance());
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(RyanAndMonicaJob.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(Thread.currentThread().getName() + " просыпается " + account.getBalance());
            account.withdraw(amount);
            System.out.println(Thread.currentThread().getName() + " заканчивает транзакцию! " + account.getBalance());
        } else {
            System.out.println("Извините, для клиента " + Thread.currentThread().getName() + " недостаточно денег " + account.getBalance());
        }//if-else
    }//makeWithdrawal
    
}//RyanAndMonicaJob