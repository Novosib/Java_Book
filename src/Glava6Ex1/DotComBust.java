package Glava6Ex1;
import java.util.*;
public class DotComBust {
    private GameHelper helper = new GameHelper();
    private ArrayList<DotCom> dotComList = new ArrayList<DotCom>();
    private int numOfGuess = 0;
    
    private void setUpGame(){
        //Создадим несколько сайтов и присвоим им имена
        DotCom one = new DotCom();
        one.setName("Шопоголик.ру");
        DotCom two = new DotCom();
        two.setName("Пусьен.ру");
        DotCom three = new DotCom();
        three.setName("ChuChu.com");
        dotComList.add(one);
        dotComList.add(two);
        dotComList.add(three);
        System.out.println("Ваша цель - потопить три ''сайта'' :");
        System.out.println(one.name + ", " + two.name + ", " + three.name);
        System.out.println("Попытайтесь потопить их за минимальное количество ходов");
        
        for (DotCom d : dotComList){//повторяем с каждым объектом DotCom в списке
            ArrayList<String> newLocation = helper.placeDotCom(3);//Запрашиваем у вспомогательного объекта адрес "сайта"
            d.setLocationCells(newLocation);//Передаем объекту DotCom местоположение, только что полученное из вспомогательного метода
        }
    }//конец метода setUpGame()
    
    private void startPlaying(){
        while (!dotComList.isEmpty()){//До тех пор, пока список объектов DotCom не станет пустым
            String userGuess = helper.getUserInput("Сделайте ход");//Получаем пользовательский ввод с помощью вспомагательного объекта
            checkUserGuess(userGuess);//Вызываем наш метод, проверяющий пользовотельский ввод
        }//конец while
        finishGame();//Вызываем наш метод для вывода результатов игры
    }//конец метода startPlaying()
    
    private void checkUserGuess(String userGuess){
        numOfGuess++;//количество попыток +1
        String result = "Мимо";//значение по умолчанию
        for (DotCom dotComToTest : dotComList){//Делаем проверку по всем обектам DotCom в списке dotComList
            result = dotComToTest.checkYourself(userGuess);//Проверяем ход пользователя в очередном DotCom
            if (result.equals("Попал")){
                break;
            }
            if (result.equals("Потопил")){
                dotComList.remove(dotComToTest);//Ему пришел конец, так что удаляем его из списка сайтов и выходим из цикла
                break;
            }            
        }//конец цикла for
        System.out.println(result);
    }//конец метода checkUserGuess
    
    private void finishGame(){
        System.out.println("Все сайты ушли ко дну! Ваши акции теперь ничего не стоят...");
        if (numOfGuess <= 18){
            System.out.println("Это заняло у вас всего" + numOfGuess + "попыток, отлично!");
            System.out.println("Это заняло у вас всего" + numOfGuess + "попыток, отлично!");
        } else {
            System.out.println("Это заняло у вас достаточно много времени: " + numOfGuess + "попыток, не самый лучший реультат...");
            System.out.println("Рыбы водят хороводы вокруг ваших вложений");
        }
    }//конец метода finishGame
    
    public static void main(String[] args) {
        DotComBust game = new DotComBust();//создаем игровой объект
        game.setUpGame();//Просим игровой объект подготовить игру
        game.startPlaying();//Просим игровой объект начать игру
    }//конец main
}//class