package _Glava14Ex1;

import java.io.Serializable;

public class GameCharacter implements Serializable {

    int power;
    String type;
    String[] weapons;
    
    public GameCharacter(int p, String t, String[] w) {
        power = p;
        type = t;
        weapons = w;
    }
    
    public int getPower(){
        return power;
    }
    
    public String getType(){
        return type;
    }
    
    public String getWeapuns(){
        String weaponList = "";
        for(int i = 0; i < weapons.length; i++){
            weaponList += weapons[i] + " ";
        }
        return weaponList;
    }
    
    public String getCondition(){
        String cond = null;
        cond += "   Power = " + getPower();
        cond += ";   Type = " + getType();
        cond += ";   Weapons = " + getWeapuns();
        return cond;
    }
    
}// GameCharacter