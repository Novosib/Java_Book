package Glava9Ex2;
import java.util.*;
public class TestLifeSupportSim {
    public static void main(String[] args) {
        int Rquantity = 0;
        int Energy = 0;
        ArrayList<SimUnit> aList = new ArrayList<SimUnit>();
        V2Radiator v2 = new V2Radiator(aList);
        V3Radiator v3 = new V3Radiator(aList);
        for (int z = 0; z < 20; z++){
            RetentionBoot ret = new RetentionBoot(aList);
            Rquantity = z;
        }
        System.out.println("Созданы Тепловые машины: " + ++Rquantity + " шт.");
        SimUnit unit;
        while (!aList.isEmpty()) {//Вычисляем энергопотребоение
            unit = aList.get(0);
            Energy = Energy + unit.power;
            aList.remove(0);
        }
        System.out.println();
        System.out.println("Итоговое энергопотребление: " + Energy + " единиц");
    }//main
}//class
