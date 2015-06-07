package Glava6Ex2;
import java.util.*;//1
public class ArrayListMagnet {//2
    
    public static void main(String[] args) {//6
        ArrayList<String> a = new ArrayList<String>();//7
        a.add(0, "ноль");//8
        a.add(1, "один");//8
        a.add(2, "два");//9
        a.add(3, "три");//10
        printAL(a);//10
        a.remove(2);//11
        if (a.contains("три")) {//12
            a.add("четыре");//12
        }//12
        printAL(a);//13
        if (a.contains("два")){//14
            a.add("2.2");//14
        }//14
        if (a.indexOf("четыре") != 4){//15
            a.add(4, "4.2");//15
        }//15
        printAL(a);//16
        printAL(a);//17
    }//конец метода main

    public static void printAL(ArrayList<String> al){//3
        for (String element : al){//4
            System.out.print(element + " ");//5
        }//5
        System.out.println(" ");//5
    }//конец метода printAL
    
    
}//class