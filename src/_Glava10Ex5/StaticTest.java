package _Glava10Ex5;
public class StaticTest extends StaticSuper{
    static int rand = (int) (Math.random() * 6); 
    static{
        System.out.println("Статический блок дочернего класса " + rand);
    }
    StaticTest() {
        System.out.println("Конструктор дочернего класса");
    }
    public static void main(String[] args) {
        System.out.println("Внутри main");
        StaticTest st = new StaticTest();
    }//main
    
}//class