package package_Glava_1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author тс
 */
public class Glava1Ex1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int x = 9;
        System.out.println("Начальное значение x =" + x);
        while (x < 10 & x > 0){
            System.out.println("Цикл выполнен, x = " + x);
            x = x - 1;
        }
        System.out.println("Цикл НЕ выполнен, x = " + x);
    }
    
}
