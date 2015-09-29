package _Glava11Ex4;

import java.io.IOException;

class MyEx extends Exception {}
public class ExTestDrive {

    public static void main(String[] args) throws IOException {
        java.io.BufferedReader reader = new java.io.BufferedReader(
        new java.io.InputStreamReader(System.in));
        String test = reader.readLine();
        System.out.print("t");
        System.out.print("h");
        try {
            doRisky(test);
            System.out.print("r");
            System.out.print("o");
        } catch (MyEx e){
            System.out.print("a");
        } finally {
            System.out.print("w");
            System.out.print("s");
        }
    }//main
     
    static void doRisky(String t) throws MyEx {
        if ("yes".equals(t)) {
            throw new MyEx();
        }
    }//doRisky
}//class
