import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static java.time.LocalDate.parse;


public class test {

    public static void main(String[] args) {
//    String string = "May 1, 2016";
//    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM, yyyy", Locale.ENGLISH);
//    LocalDate date = parse(string, formatter);
//    System.out.println();
//    System.out.println(date);
//    System.out.println();


        int[][] monthlyCalendar = new int[12][31];   // monthly calendar for 2022 fill up
        int day = 1;
        for (int i = 0; i < monthlyCalendar.length; i++) {
            for (int j = 0; j < monthlyCalendar[0].length; j++) {
                switch (i) {
                    case 0:
                        do {
                            monthlyCalendar[i][j] = day;
                            day++;
                        }
                        while (day <= 30);
                        break;
                    case 1: do {
                        monthlyCalendar[i][j] = day;
                        day++;
                    }
                    while (day <= 28);
                        break;
                }
                System.out.print(monthlyCalendar[i][j] + " ");
            }
            day = 1;
            System.out.println();

            }
        }
    }
