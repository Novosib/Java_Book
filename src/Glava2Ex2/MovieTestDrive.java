package Glava2Ex2;
public class MovieTestDrive {
    public static void main(String[] args){
        Movie one = new Movie();
        one.name = "Как прогореть на Акциях";
        one.genre = "Трагедия";
        one.rating = -2;
        Movie two = new Movie();
        two.name = "Потерянный в Офисе";
        two.genre = "Комедия";
        two.rating = 5;
        two.playIt();
        Movie three = new Movie();
        three.name = "Бфйт-Клуб";
        three.genre = "Трагедия, но в целом весёлая";
        three.rating = 127;
    }//конец метода main
}//конец класса
