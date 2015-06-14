package Glava9Ex2;
public class V2Radiator {
    int V2quantity;
    V2Radiator () {}//simple constructor
    V2Radiator (java.util.ArrayList<SimUnit> list) {
        for (int x = 0; x < 5; x++) {
            SimUnit V2Unit = new SimUnit("V2радиатор");
            V2Unit.power = V2Unit.powerUse();
            list.add(V2Unit);
            V2quantity = x;
        }
        System.out.println("Созданы V2-радиаторы: " + ++V2quantity + " шт.");
    }//main constructor
}//class