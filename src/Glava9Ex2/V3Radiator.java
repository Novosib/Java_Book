package Glava9Ex2;
public class V3Radiator extends V2Radiator {
    int V3quantity;
    V3Radiator (java.util.ArrayList<SimUnit> lglist) {
        //super(lglist);
        for (int g = 0; g < 10; g++) {
            SimUnit V3Unit = new SimUnit("V3радиатор");
            V3Unit.power = V3Unit.powerUse();
            lglist.add(V3Unit);
            V3quantity = g;
        }
        System.out.println("Созданы V3-радиаторы: " + ++V3quantity + " шт.");
    }//constructor
}
