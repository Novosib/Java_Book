package Glava4Ex1;
class Dog {
int size;
String name;
void bark(){
    if (size > 60){
        System.out.println(name + " Злится: Рррррр... Гав! Гав!");
    } else if (size > 20){
        System.out.println(name + " Злится: Уф.. Уф.. Уф..");
    } else {
        System.out.println(name + " Злится: тяф! тяф! тяф!");
    }
}//method bark
}//class Dog