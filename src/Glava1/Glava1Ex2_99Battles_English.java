package Glava1;
public class Glava1Ex2_99Battles_English {
    public static void main(String[] args){
        int All_Bottles = 10; //начальное количество бутылок
        int num = All_Bottles;
        while (num > 0) {
            System.out.println(" *** ");
            if (num> 2 ) {
                System.out.println(num + " bottles of beer on the wall");
                System.out.println(num + " bottles of beer!");
                System.out.println("Take one down, pass it around!");
                System.out.println(num - 1 + " bottles of beer on the wall!");
            }
            if (num == 2) {
                System.out.println(num + " bottles of beer on the wall");
                System.out.println(num + " bottles of beer!");
                System.out.println("Take one down, pass it around!");
                System.out.println(num - 1 + " bottle of beer on the wall!");
            }
            if (num == 1) {
                System.out.println(num + " bottle of beer on the wall");
                System.out.println(num + " bottle of beer!");
                System.out.println("Take one down, pass it around!");
                System.out.println("There is not any bottle of beer on the wall");
            }
            num = num-1;        
        }//  конец цикла while
    }// конец метода main
}// конец класса