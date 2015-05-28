package Glava2Ex3;
public class GuessGame {//класс, в котором создаются игроки и вызывается  
                        //метод StartGame, в котором происходит игровой процесс
    //Объявляем переменные экземпляра для заведения трех игроков:
    Player p1;
    Player p2;
    Player p3;
    
    public void StartGame(){
        p1 = new Player();//создаем три объекта Player и
        p2 = new Player();//присваиваем их трем переменным экземпляра
        p3 = new Player();
        
        int guessp1 = 0;//объявляем три переменные для хранения
        int guessp2 = 0;//вариантов каждого игрока
        int guessp3 = 0;
        
        boolean p1isRight = false;//объявляем три переменные для хранения
        boolean p2isRight = false;//правилоьности или неправильности (true или false)
        boolean p3isRight = false;//каждого из ариантов трех игроков
        
        int targetNumber = (int) (Math.random()*10);
        System.out.println("Загадываю число от 1 до 9...");
        
        int step = 0;//Переменная: количество попыток для определения победителя
        
        while (true){
            step = step + 1;
            System.out.println("");
            System.out.println("Итак... Попытка № " + step);
            System.out.println("Число, которое нужно угадать, - " + targetNumber);
                        
            p1.guess();//вызываем метод guess() из каждого объекта Player 
            p2.guess();
            p3.guess();
            
            guessp1 = p1.number; //извлекаем варианты каждого игрока
            guessp2 = p2.number; //(результаты работы их методов guess()),
            guessp3 = p3.number; //получая доступ к их переменным number
            
            //выводим результаты угадываний каждого игрока:
            System.out.println("Первый игрок думает, что это " + guessp1);
            System.out.println("Второй игрок думает, что это " + guessp2);
            System.out.println("Третий игрок думает, что это " + guessp3);
            
            //Проверяем варианты каждого из игроков на соответствие загаданному числу
            //Если игрок угадал, то присваиваем соответствующей переменной значение true
            //помним, что по умолчанию во всех трех переменных хранится false
            if (guessp1 == targetNumber){
                p1isRight = true;
            }
            if (guessp2 == targetNumber){
                p2isRight = true;
            }
            if (guessp3 == targetNumber){
                p3isRight = true;
            }
            
            if (p1isRight || p2isRight || p3isRight){//Если кто-то из игроков угадал...
                System.out.println("У нас есть победитель!!!");
                System.out.println("Первый игрок угадал? " + p1isRight);
                System.out.println("Второй игрок угадал? " + p2isRight);
                System.out.println("Третий игрок угадал? " + p3isRight);
                System.out.println("Конец игры!!!");
                break;// Т.к. игра закончена, прерываем цикл
            } else {//Игроки должны попробовать еще раз, т.к. никто не угадал.
                System.out.println("Игроки должны попробовать еще раз!");
            }//конец if/else
            
        }//конец цикла while(true)
    }//конец метода StartGame
}//конец класса GuessGame