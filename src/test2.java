import java.util.Scanner;

public class test2 {
    public static void printMonthTitle(int month) {
        System.out.println("       " + getMonthName(month) + " " + "2012");
        System.out.println("---------------");
        System.out.println("  Sun Mon Tue Wed Thu Fri Sat");
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

        for (int i = 0; i < startDay; i++) {
            System.out.println("   ");
        }
        for (int i = 1; i <= numberOfDaysInMonth; i++) {
            if (i < 10) {
                System.out.println("      " + i);
            } else {
                System.out.println("      " + i);
            }
            if ((i + startDay) % 7 == 0) {
                System.out.println();
            }
            System.out.println();
        }
    }
    public static int getStartDay (int month){
        int startDay2022 = 3;
        int totalNumberOfDays = getTotalNumberOfDays(month);
        return (totalNumberOfDays + startDay2022) % 7;
    }
    public static int getNumberOfDaysInMonth (int month){
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            return 31;
        } else if (month == 4 || month == 6 || month == 9 || month 11) {
            return 30;
        } else {
            return 28;
        }
    }
     public static void getTotalNumberOfDays (int month){

     }

    public static void main(String[] args) {
    }

    Scanner scan = new Scanner(System.in);

}
