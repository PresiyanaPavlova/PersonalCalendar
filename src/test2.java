import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
public class test2 {

    private static final ArrayList<String[]> events = new ArrayList<>();

    public static void printMonthTitle(int month) {
        System.out.println("     " + getMonthName(month) + " " + "2022");
        System.out.println("----------------------------");
        System.out.println(" M  T  W  T  F  S  S");
    }

    public static String getMonthName(int month) {
        String monthName = null;
        switch (month) {
            case 1:
                monthName = "January";
                break;
            case 2:
                monthName = "February";
                break;
            case 3:
                monthName = "March";
                break;
            case 4:
                monthName = "April";
                break;
            case 5:
                monthName = "May";
                break;
            case 6:
                monthName = "June";
                break;
            case 7:
                monthName = "July";
                break;
            case 8:
                monthName = "August";
                break;
            case 9:
                monthName = "September";
                break;
            case 10:
                monthName = "October";
                break;
            case 11:
                monthName = "November";
                break;
            case 12:
                monthName = "December";
                break;
            default:
                System.out.println("Invalid input.");
        }
        return monthName;
    }

    public static void printMonthBody(int month) {           //prints the actual calendar
        String initialSpace = "";                            //space before the 1st date of the month
        for (int i = 0; i < findDayOfTheWeek(month, 1, 2022) - 1; i++) {
            initialSpace += "   ";
        }
        System.out.print(initialSpace);

        for (int i = 0, dayOfMonth = 1; dayOfMonth <= getNumberOfDaysInMonth(month); i++) {
            for (int j = ((i == 0) ? findDayOfTheWeek(month, 1, 2022) - 1 : 0); j < 7 && (dayOfMonth <= getNumberOfDaysInMonth(month)); j++) {
                System.out.printf("%2d ", dayOfMonth);
                dayOfMonth++;
            }
            System.out.println();
        }
    }

    public static int findDayOfTheWeek(int month, int day, int year) {                      //determine which day of the week the month starts from
        SimpleDateFormat simpleDateformat = new SimpleDateFormat("EEEE");
        Date date = new GregorianCalendar(year, month - 1, day).getTime();
        String dayOfTheWeek = simpleDateformat.format(date);
        int dayOfTheWeekInt = 0;
        switch (dayOfTheWeek.toUpperCase()) {
            case "MONDAY":
                dayOfTheWeekInt = 1;
                break;
            case "TUESDAY":
                dayOfTheWeekInt = 2;
                break;
            case "WEDNESDAY":
                dayOfTheWeekInt = 3;
                break;
            case "THURSDAY":
                dayOfTheWeekInt = 4;
                break;
            case "FRIDAY":
                dayOfTheWeekInt = 5;
                break;
            case "SATURDAY":
                dayOfTheWeekInt = 6;
                break;
            case "SUNDAY":
                dayOfTheWeekInt = 7;
        }
        return dayOfTheWeekInt;
    }

    public static int getNumberOfDaysInMonth(int month) {        //the total number of days per month for 2022
        int numberOfDaysInMonth = 0;
        switch (month) {
            case 1, 3, 5, 7, 8, 10, 12:
                numberOfDaysInMonth = 31;
                break;
            case 2:
                numberOfDaysInMonth = 28;
                break;
            case 4, 6, 9, 11:
                numberOfDaysInMonth = 30;
                break;
        }
        return numberOfDaysInMonth;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to your personal calendar! Scheduling isn't easy without looking at the calendar. Which month would you like to see? (1-12)");
        int month = scan.nextInt();
        printMonthTitle(month);
        printMonthBody(month);
        System.out.println();

        System.out.println("What would you like to do? (1 - Create an event | 2 - Daily schedule | 3 - Search event | 4 - Find availability)");
        int option = scan.nextInt();
        while(true) {
            if (option == 1) {
                createEvent(scan);

                for (int i = 0; i < createEvent(scan).length; i++) {     //to check what's been input
                    for (int j = 0; j < createEvent(scan)[0].length; j++) {
                        System.out.print(createEvent(scan)[i][j] + " ");
                    }
                    System.out.println();
                }
            } else if (option == 2) {
                dailySchedule(scan);
            } else if (option == 3) {
                searchEvent(scan);
            } else if (option == 4) {
                findAvailability();
            } else {
                System.out.println("Invalid input.");
            }
            System.out.println("Choose your option:");
            option = scan.nextInt();
        }
                }


    //starting the schedule
    public static String[][] createEvent(Scanner scan) {
        System.out.println("How many events would you like to schedule for this day?");
        int numberOfEvents = scan.nextInt();
        scan.nextLine();
        String[][] eventCalendar = new String[numberOfEvents + 3][5];             //2d array to store the events' information
        eventCalendar[0][0] = "Date  ";
        eventCalendar[0][1] = "Event  ";
        eventCalendar[0][2] = "Start time  ";
        eventCalendar[0][3] = "End time  ";
        eventCalendar[0][4] = "Comment  ";
        eventCalendar[1][0] = "30/6/2022";
        eventCalendar[1][1] = "Dentist";
        eventCalendar[1][2] = "10:00";
        eventCalendar[1][3] = "11:00";
        eventCalendar[1][4] = "Don't be late.";
        eventCalendar[2][0] = "30/6/2022";
        eventCalendar[2][1] = "Project Hand-in";
        eventCalendar[2][2] = "19:00";
        eventCalendar[2][3] = "20:00";
        eventCalendar[2][4] = "Failure is not an option.";

        System.out.println("Please enter the event date, the name of the event, the start time, the end time, and a comment:");
        for (int i = 3; i < eventCalendar.length; i++) {
                        while (scan.hasNext()) {
                eventCalendar[i][0] = scan.nextLine();
                eventCalendar[i][1] = scan.nextLine();
                eventCalendar[i][2] = scan.nextLine();
                eventCalendar[i][3] = scan.nextLine();
                eventCalendar[i][4] = scan.nextLine();
                if (numberOfEvents > 1){
                            System.out.println("Enter next event info:");     //little bug here
                        }
                        break;
              }
        }
        return eventCalendar;
    }

        public static void dailySchedule(Scanner scan) {
            System.out.println("Please enter a date(dd/MM/yyyy):");
            String dateSearch = scan.nextLine();
            for (int i = 1; i < createEvent(scan).length; i++) {
                    if (createEvent(scan)[i][0].equals(dateSearch)) {
                        System.out.println(createEvent(scan)[i][0]);
                    }
                }
            }

        public static void searchEvent(Scanner scan) {
            System.out.println("Enter event name: ");
            String nameSearch = scan.nextLine();
            for (int i = 1; i < createEvent(scan).length; i++) {
                    if (createEvent(scan)[i][1].equals(nameSearch)) {
                        System.out.println(createEvent(scan)[i][1]);
                    }
            }
        }
        public static void findAvailability () {

        }
    }




