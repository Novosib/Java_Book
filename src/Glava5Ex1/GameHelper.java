package Glava5Ex1;
import java.io.*;
public class GameHelper {
    public String getUserInput(String prompt){
        String inputLine = null;
        System.out.print(prompt + " ");
        try {
            BufferedReader is = new BufferedReader (
            new InputStreamReader(System.in));
            inputLine = is.readLine();
            if (inputLine.length() == 0) return null;
        } catch (IOException e){
            System.out.println("Попали в исключение в классе GameHelper: ошибка ввода/вывода");
            System.out.println("IOException: " + e);
        }//catch
        return inputLine;
    }//getUserInput
}//class