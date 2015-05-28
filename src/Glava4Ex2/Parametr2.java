package Glava4Ex2;
class Parametr2 {
    String name;
    int size;
void bark(int size, String name){
    if (size > 60){
        System.out.println(name + " Злится: Рррррр... Гав! Гав!");
    } else if (size > 20){
        System.out.println(name + " Злится: Уф.. Уф.. Уф..");
    } else {
        System.out.println(name + " Злится: тяф! тяф! тяф!");
    }
}//bark
}//class
