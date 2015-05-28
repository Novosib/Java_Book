package Glava2Ex3;
public class Player {//описываем класс-шаблон для создания объекта "Игрок"
    int number = 0;//переменная для хранения варианта числа игрока
    public void guess() {//метод определения числа на угад
        number = (int) (Math.random() * 10);
    }//конец метода guess
}//конец класса