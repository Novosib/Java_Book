package Glava2Ex3;
public class GameLauncher {//основной класс, запускаающий игру

    public static void main(String[] args) {
        GuessGame game = new GuessGame();// создаем новый объект - игру
        game.StartGame();//в созданной обекте game запескаем метод StartGame (процесс игры)
    }//конец метода main   
}//конец класса