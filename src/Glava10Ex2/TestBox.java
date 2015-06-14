/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Glava10Ex2;

/**
 *
 * @author тс
 */
public class TestBox {
    Integer i = 5;
    int j;
    public static void main(String[] args) {
        TestBox t = new TestBox();
        t.go();
    }
    
    public void go(){
        j = i;
        System.out.println("Значение Integer i = " + i);
        System.out.println("Значение int j = " + j);
    }
}//class