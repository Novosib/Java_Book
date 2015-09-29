package _Glava15Ex4;
public class BankAccount {
    private int balance = 100;
    
    public int getBalance(){
        return balance;
    }
    public void withdraw(int amount){
        balance -=amount;
    }
}//BankAccount