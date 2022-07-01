import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class PersonalCalendar {
    private static final ArrayList<String[]> events = new ArrayList<>();{

    }

    public static void printMonthTitle(int month) {
        System.out.println("     " + getMonthName(month) + " " + "2022");
        System.out.println("----------------------------");
        System.out.println(" M  T  W  T  F  S  S");
    }

    public static String getMonthName(int month) {
        String monthName = null;
        switch (month) {
            case 1 -> monthName = "January";
            case 2 -> monthName = "February";
            case 3 -> monthName = "March";
            case 4 -> monthName = "April";
            case 5 -> monthName = "May";
            case 6 -> monthName = "June";
            case 7 -> monthName = "July";
            case 8 -> monthName = "August";
            case 9 -> monthName = "September";
            case 10 -> monthName = "October";
            case 11 -> monthName = "November";
            case 12 -> monthName = "December";
            default -> System.out.println("Invalid input.");
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
        int dayOfTheWeekInt = switch (dayOfTheWeek.toUpperCase()) {
            case "MONDAY" -> 1;
            case "TUESDAY" -> 2;
            case "WEDNESDAY" -> 3;
            case "THURSDAY" -> 4;
            case "FRIDAY" -> 5;
            case "SATURDAY" -> 6;
            case "SUNDAY" -> 7;
            default -> 0;
        };
        return dayOfTheWeekInt;
    }

    public static int getNumberOfDaysInMonth(int month) {        //the total number of days per month for 2022
        int numberOfDaysInMonth = switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 2 -> 28;
            case 4, 6, 9, 11 -> 30;
            default -> 0;
        };
        return numberOfDaysInMonth;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] addedEvent1 = {"30/06/2022", "Project Hand-in", "14:00", "15:00", " Failure is not an option."};
        String[] addedEvent2 = {"30.06.2022", "Gym", "15:00", "16:00", " Stretching."};
        String[] addedEvent3 = {"30.06.2022", "Laundry", "16:00", "17:00", " Color only."};
        String[] addedEvent4 = {"29.06.2022", "Class", "15:00", "17:00", " Don't forget your homework."};
        events.add(addedEvent1);
        events.add(addedEvent2);
        events.add(addedEvent3);
        events.add(addedEvent4);

        System.out.println("Welcome to your personal calendar! Scheduling isn't easy without looking at the calendar. Which month would you like to see? (1-12)");
        int month = scan.nextInt();
        printMonthTitle(month);
        printMonthBody(month);
        System.out.println();


        while (true) {
            System.out.println("");
            System.out.println("Welcome to your personal calendar! What would you like to do? (1 - Create an event | 2 - Daily schedule | 3 - Search event | 4 - Find availability)");
            int option = scan.nextInt();
            switch (option) {
                case 1 -> createEvent(scan);
                case 2 -> dailySchedule(scan);
                case 3 -> searchEvent(scan);
                case 4 -> findAvailability(scan);
                default -> System.out.println("Invalid input.");
            }
        }
    }
    private static void createEvent(Scanner scan) {
        String answer = "yes";
        String[] newEvent;
        while (true) {
            if (answer.equalsIgnoreCase("yes")) {
                System.out.println("");
                System.out.println("Please enter the event date(dd.MM.yyyy), the event name, the start time, the end time, and a comment:");
                scan.nextLine();
                String date = scan.nextLine();
                String name = scan.nextLine();
                String start = scan.nextLine();
                String end = scan.nextLine();
                String comment = scan.nextLine();
                System.out.println("Event scheduled successfully!");

                newEvent = new String[]{date, name, start, end, comment};
                events.add(newEvent);

                System.out.println("Would you like to make another event?");
                answer = scan.next();
            } else if (answer.equalsIgnoreCase("no")) {
                System.out.println("Okay, no problem.");
                break;
            } else {
                System.out.println("Unknown answer, \"yes\" or \"no\"");
                answer = scan.next();
            }
        }
    }
    private static void dailySchedule(Scanner scan) {
        System.out.println("Enter date: ");
        String searchDate = scan.next();
        for (String[] event : events) {
            if (searchDate.equals(event[0])) {
                System.out.print((event[1]) + " ");
                System.out.print(event[2] + " ");
                System.out.print(" - ");
                System.out.print(event[3] + " ");
                System.out.print((event[4]) + " ");
            }
        }
    }
    private static void searchEvent(Scanner scan) {  //doesn't work
        System.out.println("Enter event name: ");
        String searchName = scan.next();
        String[] foundEvent = null;
        for (String[] event : events) {
            String name = event[1];
            if (name.toLowerCase().contains(searchName)) {
                System.out.print(event[1]);
                System.out.print(" ");
                System.out.print(event[2]);
                System.out.print(" - ");
                System.out.print(event[3]);
                System.out.print(" ");
                System.out.print(event[0]);
                if (!event[4].equals("")) {
                    System.out.print(":");
                    System.out.print(event[4]);
                }
                foundEvent = event;
                System.out.println("");
                break;
            }
        }
        if (foundEvent != null) {
            System.out.println("Do you want to Cancel or Edit event (1 - Cancel | 2 - Edit | press any other key to continue)");
            String answer = scan.next();
            if (answer.equals("1")) {
                System.out.println("Are you sure you want to cancel the event?");
                answer = scan.next();
                if (answer.equalsIgnoreCase("yes")) {
                    events.remove(foundEvent);
                }
            } else if (answer.equals("2")) {
                System.out.println("Please enter the event's new date, the name, the start time, the end time, and a comment:");
                scan.nextLine();
                foundEvent[0] = scan.nextLine();
                foundEvent[1] = scan.nextLine();
                foundEvent[2] = scan.nextLine();
                foundEvent[3] = scan.nextLine();
                foundEvent[4] = scan.nextLine();
            }
        }
    }

    private static void findAvailability(Scanner scan) {     //not finished, can't get inside the loop, doesn't recognise event[]
        System.out.println("Enter date: ");
        String wantedDate = scan.next();
        System.out.println("From time: ");
        String wantedHour = scan.next();
        int wantedHourInt = Integer.parseInt(wantedHour.replace(":", ""));
        System.out.println("Enter duration: ");
        int wantedDuration = scan.nextInt();


        for (String[] event : events) {
            if (wantedDate.equals(event[1]) && wantedHour.equals(event[2])) {
                int startTime = Integer.parseInt(event[2].replace(":", ""));
                int endTime = Integer.parseInt(event[3].replace(":", ""));
                int unavailableSlot = (endTime - startTime);
                System.out.println("Next available slot: " + (unavailableSlot + wantedHourInt));
            }
        }
    }
}
