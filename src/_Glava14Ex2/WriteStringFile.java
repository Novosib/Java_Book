package _Glava14Ex2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WriteStringFile {
    public static void main(String[] args) {
        try {
            FileWriter writer = new FileWriter("Foo.txt");
            writer.write("Привет, ФФ!");
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(WriteStringFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//main
}//WriteStringFile