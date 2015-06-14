package Glava9Ex1;
public class SonOfBoo extends Boo {
    public SonOfBoo(String str, int j){
        super(str, j);
        System.out.println("Отработал конструктор SunOfBoo с параметрами: String str = " + str + ", int j = " + j);
    }
    public static void main(String[] args) {
        SonOfBoo test = new SonOfBoo("Пример", 32);
    }//main
}//class
