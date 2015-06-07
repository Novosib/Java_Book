package Glava6Ex1;
import java.io.*;
import java.util.*;

public class GameHelper {
    private static final String alphabet = "abcdefg";
    private int gridLenght = 7;
    private int gridSize = 49;
    private int[] grid = new int[gridSize];
    private int comCount = 0;

    public String getUserInput(String promt){
       String inputLine = null;
       System.out.print(promt + " ");
       try{
           BufferedReader is = new BufferedReader(
            new InputStreamReader(System.in));
           inputLine = is.readLine();
           if (inputLine.length() == 0) return null;
       } catch (IOException e){
           System.out.println("IOException: " + e);
       }//конец try-catch
       return inputLine.toLowerCase();
    }//конец метода getUserInput
    
    public ArrayList<String> placeDotCom(int comSize){
        ArrayList<String> alphaCells = new ArrayList<String>();
        String[] alphacoords = new String[comSize];//хранит координаты типа f6
        String temp = null;//Временная строка для конкатенации
        int[] coords = new int[comSize];//координаты текущего "сайта"
        int attempts = 0;//счетчик текущих попыток
        boolean success = false;//нашли подходящее местоположение?
        int location = 0;//Текущее начальное местоположение
        
        comCount++;//Энный "сайт" для размещения
        int incr = 1;//Устанавливаем горизонтальный инкремен
        if ((comCount % 2) == 1) {//Если нечетный (размещаем вертикально)
            incr = gridLenght;    //Устанавливаем вертикальный инкремент
        }
        
        while (!success & attempts++ < 200){//Главный поисковой цикл (32)
            location = (int) (Math.random() * gridSize);//Получаем случайную стартовую точку
            System.out.print("Пробуем " + location + "; ");
            int x = 0;//Энная позиция в "сайте", который нужно разместить
            success = true;//Предполагаем успешный исход
            while (success && x < comSize){//Ищем соседнюю неиспользованную ячейку
                if (grid[location] == 0){//Если еще не используется
                    coords[x++] = location;//Сохраняем местоположение
                    location += incr;//Пробуем "следующую" соседнюю ячейку
                    if (location >= gridSize){//Вышли за рамки - низ
                        success = false;//неудача
                    }
                    if (x > 0 && (location % gridLenght == 0)){//Вышли за рамки - правый край
                        success = false;//неудача
                    }                    
                } else {//Нашли уже используещееся местоположение
                    System.out.print("Используется" + location);
                    success = false;//неудача
                }//конец ветвления if-else
            }//конец внутреннего цикла while
        }//конец внешнего цикла while
        
        int x = 0;//Переводим местоположение в символьные координаты
        int row = 0;
        int column = 0;
        System.out.println("\n");
        while (x < comSize) {//Помечаем ячейки на главной сетке, как "использованные"
            grid[coords[x]] = 1;
            row = (int) (coords[x] / gridLenght);//Получаем значение строки
            column = coords[x] % gridLenght;//Получаем числовое значение столбца
            temp = String.valueOf(alphabet.charAt(column));//Преобразуем его в строковой символ
            
            alphaCells.add(temp.concat(Integer.toString(row)));
            x++;
            System.out.print(" coord " + x + " = " + alphaCells.get(x-1));//Говорит, где именно находится сайт           
        }//конец цикла while
        System.out.println("\n");
        return alphaCells;
    }//конец метода placeDotCom
}//class
