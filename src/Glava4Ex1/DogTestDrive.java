package Glava4Ex1;
public class DogTestDrive {
    public static void main(String[] args) {
        Dog Big_dog = new Dog();
        Dog Middle_dog = new Dog();
        Dog Little_dog = new Dog();
        
        Big_dog.name = "Гектор";
        Big_dog.size = 70;
        Middle_dog.name = "Бим";
        Middle_dog.size = 30;
        Little_dog.name = "Кнопка";
        Little_dog.size = 5;
        
        Big_dog.bark();
        Middle_dog.bark();
        Little_dog.bark();
    }//method main
}//class DogTestDrive
