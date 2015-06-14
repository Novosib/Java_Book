package Glava9Ex2;
public class SimUnit {
    String botType;
    int power;
    SimUnit (String type){
        power = 0;
        botType = type;
    }//constructor
    int powerUse(){
        if ("Тепловая машина".equals(botType)){
            return 2;
        } else {
            return 4;
        }//if-else
    }//powerUse()
}//class
