package Glava5Ex1;
public class SimpleDotComTestDrive {
    public static void main(String[] args) {
        String testResult;//переменная для результата теста
        String result;//переменная для хранения результата проверки варианта пользователя
        int x;
        //---------Тест №1: Сайт {1,2,3}, ход "2", результат "Попал" 
        System.out.println();
        System.out.println("Начало теста ...");
        int[] locations1 = {2,3,4}; //Задаем целочисленный массив из трёх чисел
        String UserGuess1 = "2";//Имитируем вариант, введенный пользователем
        
        SimpleDotCom Test1 = new SimpleDotCom(); //Создаем объект-сайт
        Test1.setLocationCells(locations1); //Вызываем сеттер для задания ячеек сайта
        result = Test1.checkYourself(UserGuess1);//Вычисляем результат проверки варианта пользователяЫ
        if (result.equals("Попал")){ //Проверяем итог теста
            testResult = "Тест пройден :)";
        } else {testResult = "Тест НЕ пройден :(";}
        
        //---------Выводим результаты теста
        System.out.print("Координаты сайта: { ");
        x = 0;
        while (x < locations1.length){
            System.out.print(locations1[x] + " ");
            x++;}
        System.out.print(" }; Ход пользователя = ");
        System.out.print(UserGuess1 + "; ");
        System.out.println("Анализ хода выдал: " + result);
        System.out.println("Результат теста: " + testResult);
        
         //---------Тест №2: Сайт {2}, ход "2", результат "Потопил" 
        System.out.println();
        System.out.println("Начало теста ...");
        int[] locations2 = {2}; //Задаем целочисленный массив из трёх чисел
        String UserGuess2 = "2";//Имитируем вариант, введенный пользователем
        
        SimpleDotCom Test2 = new SimpleDotCom(); //Создаем объект-сайт
        Test2.setLocationCells(locations2); //Вызываем сеттер для задания ячеек сайта
        result = Test2.checkYourself(UserGuess2);//Вычисляем результат проверки варианта пользователяЫ
        if (result.equals("Потопил")){ //Проверяем итог теста
            testResult = "Тест пройден :)";
        } else {testResult = "Тест НЕ пройден :(";}
        
        //---------Выводим результаты теста
        System.out.print("Координаты сайта: { ");
        x = 0;
        while (x < locations2.length){
            System.out.print(locations2[x] + " ");
            x++;}
        System.out.print(" }; Ход пользователя = ");
        System.out.print(UserGuess2 + "; ");
        System.out.println("Анализ хода выдал: " + result);
        System.out.println("Результат теста: " + testResult);
       
         //---------Тест №3: Сайт {2,3,4}, ход "1", результат "Мимо" 
        System.out.println();
        System.out.println("Начало теста ...");
        int[] locations3 = {2,3,4}; //Задаем целочисленный массив из трёх чисел
        String UserGuess3 = "1";//Имитируем вариант, введенный пользователем
        
        SimpleDotCom Test3 = new SimpleDotCom(); //Создаем объект-сайт
        Test3.setLocationCells(locations3); //Вызываем сеттер для задания ячеек сайта
        result = Test3.checkYourself(UserGuess3);//Вычисляем результат проверки варианта пользователяЫ
        if (result.equals("Мимо")){ //Проверяем итог теста
            testResult = "Тест пройден :)";
        } else {testResult = "Тест НЕ пройден :(";}
        
        //---------Выводим результаты теста
        System.out.print("Координаты сайта: { ");
        x = 0;
        while (x < locations3.length){
            System.out.print(locations3[x] + " ");
            x++;}
        System.out.print(" }; Ход пользователя = ");
        System.out.print(UserGuess3 + "; ");
        System.out.println("Анализ хода выдал: " + result);
        System.out.println("Результат теста: " + testResult);
        
    }//main
}//class