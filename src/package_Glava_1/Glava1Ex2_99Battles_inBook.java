package package_Glava_1;
public class Glava1Ex2_99Battles_inBook {
    public static void main(String[] args){
        int num = 10; //начальное количество бутылок
        String word = "бутылок (бутылки)";
        while (num > 0) {          
            System.out.println(" *** ");
            System.out.println(num + " " + word + " пива на стене");
            System.out.println(num + " " + word + " пива!");
            System.out.println("Возьми одну, пусти по кругу!");
            num = num-1;
            if (num == 1) {word = "бутылка";}// В единственном числе - 1 бутылка
            if (num > 0) {
            System.out.println(num + " " + word + " пива на стене");
            } else {
              System.out.println("Нет бутылок пива на стене");
            }
        }//  конец цикла while
    }// конец метода main
}// конец класса