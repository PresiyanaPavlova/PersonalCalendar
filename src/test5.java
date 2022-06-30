import java.util.ArrayList;
import java.util.Scanner;

public class test5 {
    private static ArrayList<String[]> events = new ArrayList<>();{
        String[] addedEvent1 = {"30.06.2022", "Project Hand-in", "14:00", "15:00", "Failure is not an option."};
        String[] addedEvent2 = {"30.06.2022", "Gym", "15:00", "16:00", "Stretching."};
        String[] addedEvent3 = {"30.06.2022", "Laundry", "16:00", "17:00", "Color only."};
        events.add(addedEvent1);
        events.add(addedEvent2);
        events.add(addedEvent3);
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("This");
        for (int i = 0; i < events.size(); i++) {
            System.out.println(events.get(i));
        }



        while (true) {
            System.out.println("");
            System.out.println("Welcome to your personal calendar! What would you like to do? (1 - Create an event | 2 - Daily schedule | 3 - Search event | 4 - Find availability)");
            int option = scan.nextInt();
            switch (option) {
                case 1:
                    createEvent(scan);
                    break;
                case 2:
                    dailySchedule(scan);
                    break;
                case 3:
                    searchEvent(scan);
                    break;
                case 4:
                    findAvailability(scan);
                    break;
                default:
                    System.out.println("Invalid input.");
            }
        }
    }

    private static void createEvent(Scanner scan) {
        String answer = "yes";
        String[] newEvent;
        while (true) {
            if (answer.toLowerCase().equals("yes")) {
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
            } else if (answer.toLowerCase().equals("no")) {
                System.out.println("Okay np");
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
//        for (String[] event : events) {
//            System.out.println("");
//
//            if (searchDate.equals(event[1])) {
//                System.out.print(event[2]);
//                System.out.print(" - ");
//                System.out.print(event[3]);
//                System.out.print(" ");
//                System.out.print(event[0]);
//                if (!event[4].equals("")) {
//                    System.out.print(":");
//                    System.out.print(event[4]);
//                }
//            }
//        }

        for (String[] event : events) {
            for (String search : event) {
                if (search.contains(searchDate)) {
                    System.out.print(event[2]);
                    System.out.print(" - ");
                    System.out.print(event[3]);
                    System.out.print(" ");
                    System.out.print(event[0]);
                    if (!event[4].equals("")) {
                        System.out.print(":");
                        System.out.print(event[4]);
                    }
                }
            }

        }
    }

    private static void searchEvent(Scanner scan) {
        System.out.println("Enter event name: ");
        String searchName = scan.next();
        String[] foundEvent = null;
        for (String[] event : events) {
            System.out.println("");
            String name = event[0];
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
                if (answer.toLowerCase().equals("yes")) {
                    events.remove(foundEvent);
                }
            } else if (answer.equals("2")) {
                System.out.println("Please enter the event's new name, the date, the start time, the end time, and a comment:");
                scan.nextLine();
                foundEvent[0] = scan.nextLine();
                foundEvent[1] = scan.nextLine();
                foundEvent[2] = scan.nextLine();
                foundEvent[3] = scan.nextLine();
                foundEvent[4] = scan.nextLine();
            }
        }
    }

    private static void findAvailability(Scanner scan) {
        System.out.println("Enter date: ");
        String date = scan.next();
        System.out.println("From time: ");
        String hour = scan.next();
        System.out.println("Enter duration: ");
        String duration = scan.next();

        for (String[] event : events) {
        }
    }
}
