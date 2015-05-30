package Glava1;
public class Glava1Ex2_99Battles {
    public static void main(String[] args){
        int Repeat = 1; // показывает текущий номер повторения песни
        int LastRepeat = 2;//количество повторений всей песни
        int num = 99; //начальное количество бутылок
        int end = 9; //последняя цифра num. Влияет на склонение слова "бутылок" 
        int LastStep = 98; //количество бутылок, на котором заканчивается песня
        
        System.out.println("*** повторение песни № " + Repeat + " ***");    
        while (num > LastStep) {
                System.out.println(" *** ");
                if (end == 0) {
                System.out.println(num + " бутылок пива на столе");
                System.out.println(num + " бутылок пива!");
                System.out.println("Возьми одну, пусти по кругу!");
                System.out.println(num - 1 + " бутылок пива на столе");
                }
                if (end > 5) {
                System.out.println(num + " бутылок пива на столе");
                System.out.println(num + " бутылок пива!");
                System.out.println("Возьми одну, пусти по кругу!");
                System.out.println(num - 1 + " бутылок пива на столе");
                }
                if (end == 5) {
                System.out.println(num + " бутылок пива на столе");
                System.out.println(num + " бутылок пива!");
                System.out.println("Возьми одну, пусти по кругу!");
                System.out.println(num - 1 + " бутылки пива на столе");
                }
                if (end > 2 & end <5) {
                System.out.println(num + " бутылки пива на столе");
                System.out.println(num + " бутылки пива!");
                System.out.println("Возьми одну, пусти по кругу!");
                System.out.println(num - 1 + " бутылки пива на столе");
               }
                if (end == 2) {
                System.out.println(num + " бутылки пива на столе");
                System.out.println(num + " бутылки пива!");
                System.out.println("Возьми одну, пусти по кругу!");
                System.out.println(num - 1 + " бутылка пива на столе");
               }
                if (end == 1 &  num > 1) {
                System.out.println(num + " бутылка пива на столе");
                System.out.println(num + " бутылка пива!");
                System.out.println("Возьми одну, пусти по кругу!");
                System.out.println(num - 1 + " бутылок пива на столе");
               }                                    
                if (num == 1) {
                System.out.println(num + " бутылка пива на столе");
                System.out.println(num + " бутылка пива!");
                System.out.println("Возьми одну, пусти по кругу!");
                System.out.println("Нет бутылок пива на столе");
               }                                    
               num = num-1;

                if (end == 0) {
                    end = 9;
                    System.out.println("");
                } else {
                    end = end - 1;
                }
                if (num == 0) {
                    System.out.println(" *** ");
                    System.out.println("Нет бутылок пива на столе!");
                    System.out.println("Нет бутылок пива!");
                    System.out.println("Дуй в магазин, купи ещё");
                    System.out.println("99 бутылок пива на стене!");
                }
                if (num == LastStep & LastRepeat > Repeat) {
                    num = 99;
                    end = 9;
                    Repeat = Repeat + 1;
                    System.out.println("");
                    System.out.println("*** повторение № " + Repeat + " ***");
                }
        }
    }
}
