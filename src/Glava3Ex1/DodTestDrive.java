package Glava3Ex1;
public class DodTestDrive {
    public static void main(String[] args) {
        //Создаем объет типа Dog и получаем к нему доступ через переменную-ссылку  dog1
        Dog dog1 = new Dog();
        dog1.bark();
        dog1.name = "Барт";
        //Создаем массив типа Dog:
        Dog[] myDogs = new Dog[3];
        //и поместим в него несколько элементов:
        myDogs[0] = new Dog();
        myDogs[1] = new Dog();
        myDogs[2] = dog1;
        //получаем доступ к объектам типа Dog с помощью ссылок из массива:
        myDogs[0].name = "Фред";
        myDogs[1].name = "Джорж";
        //хм... а какое имя у myDod[2]?
        System.out.print("Имя последней собаки: ");
        System.out.println(myDogs[2].name);
        //Теперь переберем все элементы массива
        //и для каждого элемента вызовем метод bark()
        int x = 0;
        while (x < myDogs.length) {
            myDogs[x].bark();
            x = x + 1;
        }
    }//method main
}//class DogTestDrive
