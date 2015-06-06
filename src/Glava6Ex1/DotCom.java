package Glava6Ex1;
import java.util.ArrayList;
public class DotCom {
    private ArrayList<String> locationCells;//Массив с ячейками, описывающими местоположение "сайта"
    private String name;//имя "сайта"
    
    public void setLocationCells(ArrayList<String> loc){//сеттер для задания местоположения "сайта"
        locationCells = loc;
    }
    public void setName(String n){//сеттер для задания имени "сайта"
        name = n;
    }    
    public String checkYourself (String userInput){
        String result = "Мимо";
        int index = locationCells.indexOf(userInput);//Проверяем, содержится userInput в коллекции locationCells
        //метод indexOf() возвращает либо индек объекта в коллекции, либо "-1", если объекта нет в коллекции
        
        if (index >=0){
            locationCells.remove(index);//userInput в коллекции, значит есть попадание и мы удаляем этот объект из коллекции
            if (locationCells.isEmpty()){//Если после удаления элемента список стал пустым, значи это последнее попадание!
                result = "Потопил";
                System.out.println("Ой! Вы потопили " + name + " :(");
            } else {
                result = "Попал";
            }//конец внутреннего if
        } //конец внешнего if
        
        return result;
    }//method checkYourself
}//class