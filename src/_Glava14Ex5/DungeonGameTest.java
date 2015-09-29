package _Glava14Ex5;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DungeonGameTest {
    
    public static void main(String[] args) {
        DungeonGame d = new DungeonGame();
        System.out.println("До импорта: " + "x = " + d.getX() + "; y = "+ d.getY() + "; z = " + d.getZ());
        System.out.println(d.getX() + d.getY() + d.getZ());
        
        try {
            FileOutputStream fos = new FileOutputStream("dg.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(d);
            oos.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DungeonGameTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
                Logger.getLogger(DungeonGameTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            FileInputStream fis = new FileInputStream("dg.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            d = (DungeonGame) ois.readObject();
            ois.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DungeonGameTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DungeonGameTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DungeonGameTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("После импорта: " + "x = " + d.getX() + "; y = "+ d.getY() + "; z = " + d.getZ());
        System.out.println(d.getX() + d.getY() + d.getZ());
    }
    
}