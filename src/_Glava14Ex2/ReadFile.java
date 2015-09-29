package _Glava14Ex2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReadFile {
    public static void main(String[] args) {
        File myFile = new File("Test.txt");
        
        try {
            FileReader fileReader = new FileReader(myFile);
            BufferedReader reader = new BufferedReader(fileReader);
            String line = null;
            while((line = reader.readLine()) != null){//Читаем строку файла и присваиваем её переменной lint. Пока она не пуста, печатаем прочитанную строку
                System.out.println(line);
            }
            System.out.println(myFile.getAbsolutePath());
            reader.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReadFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
                Logger.getLogger(ReadFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//main
}// ReadFile