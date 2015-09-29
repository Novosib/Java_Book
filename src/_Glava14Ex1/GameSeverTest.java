package _Glava14Ex1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GameSeverTest {

    public static void main(String[] args) {
        GameCharacter one = new GameCharacter(50, "Эльф", new String[] {"Лук", "Меч", "Кастет"});
        GameCharacter two = new GameCharacter(200, "Троль", new String[] {"Голые руки", "Большой топор"});
        GameCharacter three = new GameCharacter(120, "Маг", new String[] {"Заклинания", "Невидимость"});
        
        System.out.println("Начальное сотояние: ");
        System.out.println("One: " + one.getCondition());
        System.out.println("Two: " + two.getCondition()); 
        System.out.println("Tree: " + three.getCondition()); 
        
        try {//Сохраняем объекты в файл Game.ser
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("Game.ser"));
            os.writeObject(one);
            os.writeObject(two);
            os.writeObject(three);
            os.close();
        } catch (IOException ex) {
            Logger.getLogger(GameSeverTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        one = null;
        two = null;
        three = null;
        
        ObjectInputStream is;
        try {//Восстанавливаем объекты из файла Game.ser
            is = new ObjectInputStream(new FileInputStream("Game.ser"));
            one = (GameCharacter) is.readObject();
            two = (GameCharacter) is.readObject();
            three = (GameCharacter) is.readObject();
            is.close();
        } catch (IOException ex) {
            Logger.getLogger(GameSeverTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
                Logger.getLogger(GameSeverTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println();
        System.out.println("Восстановленное состояние: ");
        System.out.println("One: " + one.getCondition());
        System.out.println("Two: " + two.getCondition()); 
        System.out.println("Tree: " + three.getCondition());
    }//main
    
}//GameSeverTest