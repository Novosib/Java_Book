package _Glava10Ex6;

import java.util.Calendar;
import static java.lang.System.out;

public class FullMoons {
    static int DAY_IM = 1000 * 60 * 60 * 24;
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        c.set(2004, 0, 7, 15, 40);
        long day = c.getTimeInMillis();
        for (int i = 0; i < 12; i++) {
            day += DAY_IM * 29.52;
            c.setTimeInMillis(day);
            out.println(String.format("Полнолуние было в %tc", c));
        }//for
    }//main
}//class