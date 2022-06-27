import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class test4 {
    public static String findDay(int month, int day, int year) {                      //IT WORKS IT GETS ME THE DAY OF THE MONTH
        SimpleDateFormat simpleDateformat = new SimpleDateFormat("EEEE");
        Date date = new GregorianCalendar(year, month - 1, day).getTime();
        String dayText = simpleDateformat.format(date);

        return dayText.toUpperCase();
    }
    public static void main(String[] args){
        Scanner  scan = new Scanner (System.in);
        int day = scan.nextInt();
        int month = scan.nextInt();
        int year = scan.nextInt();
        System.out.println(findDay(month, day, year));
    }
}
