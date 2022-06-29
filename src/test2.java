import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Scanner;

public class test2 {
    public static void printMonthTitle(int month) {
        System.out.println("     " + getMonthName(month) + " " + "2022");
        System.out.println("----------------------------");
        System.out.println(" M  T  W  T  F  S  S");
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
            case 12: monthName = "December"; break;
            default:
                System.out.println("Invalid input.");
        }
        return monthName;
    }
    public static void printMonthBody(int month) {

        String initialSpace = "";
        for (int i = 0; i < findDayOfTheWeek(month, 1, 2022) - 1; i++) {
            initialSpace += "   ";
        }
        System.out.print(initialSpace);

        for (int i = 0, dayOfMonth = 1; dayOfMonth <= getNumberOfDaysInMonth(month); i++) {
            for (int j = ((i == 0) ? findDayOfTheWeek(month, 1,2022) - 1 : 0); j < 7 && (dayOfMonth <= getNumberOfDaysInMonth(month)); j++) {
                System.out.printf("%2d ", dayOfMonth);
                dayOfMonth++;
            }
            System.out.println();
        }
    }
   public static int findDayOfTheWeek(int month, int day, int year) {                      //determine which day of the week
        SimpleDateFormat simpleDateformat = new SimpleDateFormat("EEEE");
        Date date = new GregorianCalendar(year, month - 1, day).getTime();
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
           System.out.println("Welcome to your personal calendar! It looks empty, let's create an event.\nWhich month would you like to see?");
           int month = scan.nextInt();
           printMonthTitle(month);
           printMonthBody(month);
           System.out.println();
 //         createEvent(scan);
           userInputEventInfo(scan);
       }
       //starting the schedule
    public static void userInputEventInfo (Scanner scan) {

        System.out.println("What date would you like to schedule an event for?");
        String date = scan.nextLine();
        scan.nextLine();                                                            //to fix the nextLine skipping problem
        System.out.println("How many events would you like to schedule for this day?");
        int numberOfEvents = scan.nextInt();
        String[][] timetable = new String[numberOfEvents + 1][5];

        timetable[0][0] = "Date  ";
        timetable[0][1] = "Event  ";
        timetable[0][2] = "Start time  ";
        timetable[0][3] = "End time  ";
        timetable[0][4] = "Comment  ";

        for (int i = 1; i <= numberOfEvents + 1; i++) {                   //can't get out of this loop for some reason?
            for (int j = 0; j < 5; j++) {

                timetable[i][j] = date;
                j++;
                System.out.println("What's the name of your event?");
                timetable[i][j] = scan.nextLine();
                j++;
                System.out.println("What time does your event start?");
                timetable[i][j] = scan.nextLine();
                j++;
                System.out.println("What time does your event finish?");
                timetable[i][j] = scan.nextLine();
                j++;
                System.out.println("Leave a comment about your event:");
                timetable[i][j] = scan.nextLine();
                scan.nextLine();
            }
        }
        for (int i = 0; i < timetable.length; i++) {
            for (int j = 0; j < timetable[0].length; j++) {
                System.out.print(timetable[i][j]);
            }
            System.out.println();
        }
    }
//        public static void createEvent(Scanner scan){
//            String[] event1 = {"Dentist", "2/2/2022","10:00","11:00","Don't be late."};
//            System.out.println("Do you want to make a new event?");
//            scan.nextLine();
//            String answer = scan.nextLine();
//            //can't make a new array every time it runs
//            while (answer.toLowerCase().equals("yes")) {
//                System.out.println("Please enter the event name, the date, the start time, the end time, and a comment:");
//                String[] newEvent = {scan.nextLine(), scan.nextLine(), scan.nextLine(), scan.nextLine(), scan.nextLine()};
//
//            }
//                if (answer.toLowerCase().equals("no")){
//                    System.out.println("Okay np");
//                }
//            }
//            if (answer.toLowerCase().equals("yes")) {
//                System.out.println("Please enter the event name, the date, the start time, the end time, and a comment:");
//                String[] newEvent = {scan.nextLine(), scan.nextLine(), scan.nextLine(), scan.nextLine(), scan.nextLine()};
//            } else {
//                System.exit(0);
//            }

    }


