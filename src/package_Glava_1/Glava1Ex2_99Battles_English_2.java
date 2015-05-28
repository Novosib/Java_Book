package package_Glava_1;
public class Glava1Ex2_99Battles_English_2 {
    public static void main(String[] args){
        int num = 10; //начальное количество бутылок
        String word = "bottles";
        while (num > 0) {
            System.out.println(" *** ");
            if (num> 1 ) {
                System.out.println(num + " " + word + " of beer on the wall");
                System.out.println(num + " " + word + " bottles of beer!");
                System.out.println("Take one down, pass it around!");
                num = num-1;
                if (num == 1) {word = "bottle";}// В единственном числе - 1 бутылка
                System.out.println(num + " " + word + " of beer on the wall!");
            }
            System.out.println(" *** ");
            if (num == 1) {// Если осталась 1 бутылка
                System.out.println(num + " " + word + " of beer on the wall!");
                System.out.println(num + " " + word + " bottles of beer!");
                System.out.println("Take one down, pass it around!");
                System.out.println("There is not any bottle of beer on the wall");
                num = num-1;
            }        
        }//  конец цикла while
    }// конец метода main
}// конец класса