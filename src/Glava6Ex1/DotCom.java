package Glava6Ex1;
import java.util.ArrayList;
public class DotCom {
    private ArrayList<String> locationCells;//Создаем коллекцию для хранения объектов типа String
    
    public void SetLocationCells(ArrayList<String> loc){//сеттер для определения коллекции locationCells
        locationCells = loc;
    }
    
    public String checkYourself (String userInput){
        String result = "Мимо";
        
        int index = locationCells.indexOf(userInput);//Проверяем, содержится userInput в коллекции locationCells
        //метод indexOf() возвращает либо индек объекта в коллекции, либо "-1", если объекта нет в коллекции
        
        if (index >=0){
            locationCells.remove(index);//userInput в коллекции, значит есть попадание и мы удаляем этот объект из коллекции
            
            if (locationCells.isEmpty()){//Если после удаления элемента список стал пустым, значи это последнее попадание!
                result = "Потопил";
            } else {
                result = "Попал";
            }//конец внутреннего if
        } //конец внешнего if
        
        return result;
    }//method checkYourself
}//class