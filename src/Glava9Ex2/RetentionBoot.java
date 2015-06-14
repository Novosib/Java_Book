package Glava9Ex2;
public class RetentionBoot {
    RetentionBoot (java.util.ArrayList<SimUnit> rlist){
        SimUnit RUnit = new SimUnit("Тепловая машина");
        RUnit.power = RUnit.powerUse();
        rlist.add(RUnit);
    }//constructor
}//class
