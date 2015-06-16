package _Glava10Ex4;
import java.util.Calendar;
public class CalendarTest {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        c.set(2015, 5, 15, 20, 19);
        String date1 = "Год = " + c.get(c.YEAR) + ", Месяц = " + c.get(c.MONTH) + ", Неделя = " + c.get(c.WEEK_OF_MONTH);
        date1 += ", День = " + c.get(c.DAY_OF_MONTH) + ", Час = " + c.get(c.HOUR_OF_DAY);
        System.out.println(date1);
        
        long day1 = c.getTimeInMillis();
        //System.out.println(day1 + " = day1");
        System.out.println("Добавляем 1 час:");
        day1 += 1000 * 60 * 60;
        //System.out.println(day1 + " = day1 + 1 час");
        c.setTimeInMillis(day1);
        String date2 = "Год = " + c.get(c.YEAR) + ", Месяц = " + c.get(c.MONTH) + ", Неделя = " + c.get(c.WEEK_OF_MONTH);
        date2 += ", День = " + c.get(c.DAY_OF_MONTH) + ", Час = " + c.get(c.HOUR_OF_DAY);
        System.out.println(date2);
        
        System.out.println("Добавляем 35 дней:");
        c.add(c.DATE, 35);
        String date3 = "Год = " + c.get(c.YEAR) + ", Месяц = " + c.get(c.MONTH) + ", Неделя = " + c.get(c.WEEK_OF_MONTH);
        date3 += ", День = " + c.get(c.DAY_OF_MONTH) + ", Час = " + c.get(c.HOUR_OF_DAY);
        System.out.println(date3);
        
        System.out.println("Прокручиваем 6 дней:");
        c.roll(c.DATE, 6);
        String date4 = "Год = " + c.get(c.YEAR) + ", Месяц = " + c.get(c.MONTH) + ", Неделя = " + c.get(c.WEEK_OF_MONTH);
        date4 += ", День = " + c.get(c.DAY_OF_MONTH) + ", Час = " + c.get(c.HOUR_OF_DAY);
        System.out.println(date4);
        
        System.out.println("Устанавливаем 1-ое число месяца:");
        c.set(c.DATE, 1);
        String date5 = "Год = " + c.get(c.YEAR) + ", Месяц = " + c.get(c.MONTH) + ", Неделя = " + c.get(c.WEEK_OF_MONTH);
        date5 += ", День = " + c.get(c.DAY_OF_MONTH) + ", Час = " + c.get(c.HOUR_OF_DAY);
        System.out.println(date5);
        
        System.out.println();
        System.out.println("Дата в формате метода getTime(): " + c.getTime());
        System.out.println();
        System.out.println("Сдвиг относительно GTM в милисикундах: " + c.ZONE_OFFSET);
        //System.out.println("Экземпляр calendar: " + c.getInstance());
        
    }//main
}//class