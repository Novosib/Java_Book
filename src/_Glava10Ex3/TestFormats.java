package _Glava10Ex3;
public class TestFormats {
    public static void main(String[] args) {
        String s1 = String.format("%,d; %,.3f", 1000, 1000000.12345678);
        System.out.println("Результат форматирования чисел = " + s1);
        java.util.Date today= new java.util.Date();
        String s2 = String.format("%tA, %<tB %<td", today);
        System.out.println("Новая дата = " + s2);
    }//main
}//class