import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class test2 {
    public static void printMonthTitle(int month) {
        System.out.println("     " + getMonthName(month) + " " + "2022");
        System.out.println("----------------------------");
        System.out.println("S   M   T   W   T   F   S");
    }

    public static String getMonthName(int month) {
        String monthName = null;
        switch (month) {
            case 1: monthName = "January"; break;
            case 2: monthName = "February"; break;
            case 3: monthName = "March"; break;
            case 4: monthName = "April"; break;
            case 5: monthName = "May"; break;
            case 6: monthName = "June"; break;
            case 7: monthName = "July"; break;
            case 8: monthName = "August"; break;
            case 9: monthName = "September"; break;
            case 10: monthName = "October"; break;
            case 11: monthName = "November"; break;
            case 12: monthName = "December";
        }
        return monthName;
    }

    public static void printMonth(int month) {
        printMonthTitle(month);
       printMonthBody(month);
    }

    public static void printMonthBody(int month) {
        int startDay = getStartDay(month);
        int numberOfDaysInMonth = getNumberOfDaysInMonth(month);
        int repeatSpace = 7 - findDayOfTheWeek(month,1,2022);
        System.out.print("   ".repeat(repeatSpace));                   //TODO: fix this spacing
        for (int i = 1; i <= numberOfDaysInMonth; i++) {
            if (i < 10) {
                System.out.print("  " + i);
            } else {
                System.out.print(" " + i);
            }
            if ((i + startDay) % 7 == 0) {
                System.out.println();
            }
        }
    }

    public static int getStartDay (int month){
       int totalNumberOfDays = getNumberOfDaysInMonth(month);

        return (totalNumberOfDays + (7 - findDayOfTheWeek(month,1, 2022)) % 7);
   }

   public static int findDayOfTheWeek(int month, int day, int year) {                      //determine which day of the week
        SimpleDateFormat simpleDateformat = new SimpleDateFormat("EEEE");
        Date date = new GregorianCalendar(year, month - 1, day).getTime();     //see how to get rid of year, so it's2022 by default, and day 1 as default
        String dayOfTheWeek = simpleDateformat.format(date);
        int dayOfTheWeekInt = 0;
        switch (dayOfTheWeek.toUpperCase()){
            case "MONDAY" : dayOfTheWeekInt = 1; break;
            case "TUESDAY": dayOfTheWeekInt = 2; break;
            case "WEDNESDAY": dayOfTheWeekInt = 3; break;
            case "THURSDAY": dayOfTheWeekInt = 4; break;
            case "FRIDAY": dayOfTheWeekInt = 5; break;
            case "SATURDAY": dayOfTheWeekInt = 6; break;
            case "SUNDAY": dayOfTheWeekInt = 7;
        }

        return dayOfTheWeekInt;
    }
    public static int getNumberOfDaysInMonth (int month){
        int numberOfDaysInMonth = 0;
        switch (month){
            case 1, 3, 5, 7, 8, 10, 12:
                numberOfDaysInMonth = 31; break;
            case 2: numberOfDaysInMonth = 28; break;
            case 4, 6, 9, 11:
                numberOfDaysInMonth = 30; break;
        }
        return numberOfDaysInMonth;
    }
       public static void main(String[] args) {


           Scanner scan = new Scanner(System.in);
           System.out.println("Enter month");
           int month = scan.nextInt();
    printMonthTitle(month);
    printMonthBody(month);
       }

}
