package Glava5Ex1;
public class SimpleDotComGame {
    public static void main(String[] args) {
        int numOfGuess = 0;//количесво попыток
        GameHelper helper = new GameHelper();//Специальный класс, содержащий метод для приема пользовательского ввода
        SimpleDotCom theDotCom = new SimpleDotCom();//создаем обект "сайт", который нужно будет потопить
        int randomNum = (int) (Math.random()*5);//загадываем начало для ячеек сайта
        int[] locations = {randomNum, randomNum + 1, randomNum + 2};//загадываем три ячейки
        theDotCom.setLocationCells(locations);//присваем загаданные ячейки координатам сайта
        boolean isAlive = true;//вводим индикатор, означающий, что игра продолжается
        
        while (isAlive == true) {
            String guess = helper.getUserInput("Введите число");//Получаем строковой вариант, вводимый пользователем
            String result = theDotCom.checkYourself(guess);//Проверяем введенный вариант
            numOfGuess++;//Инкреминируем количество попыток
            if (result.equals("Потопил")){
                isAlive = false;
                System.out.println("Ваше количество попыток: " + numOfGuess);
            }// end of "if"
        }//end of while (isAlive == true)
    }//end of main
}//end of class
