import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class PersonalCalendar {
    public static Date StringToDate(String date) throws ParseException {
       SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
       Date date1 = new SimpleDateFormat("dd.MM.yyyy").parse(date);
            return date1;
    }

    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner (System.in);
        System.out.println("Welcome to your personal calendar! It looks empty, let's create an event. \nWhat's the name of your event?");
        String event = scanner.nextLine();
        System.out.println("What date is your event?");
        String date = scanner.nextLine();
        System.out.println(StringToDate(date));


        System.out.println("What time is your event?");
        String time = scanner.nextLine();
        System.out.println(StringToDate(time));

    }
}
