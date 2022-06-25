public class test1 {
    public static void main(String[] args) {
    /*    String[][] schedule = {{"0", "name", "date", "start time", "end time", "comment"},
                {"event 1", "dentist", "12.12.2012", "8:00", "9:00", "Arrive on time"},
        {"event 2", "pharmacy", "12.12.2012", "12:00", "14:00", "Good luck"},
        {"event 3", "earliest event", "12.12.2012", "7:00", "8:00", "wake up"}};


        for (int i = 0; i < schedule.length; i++) {
            for (int j = 1; j < schedule[0].length; j++) {
                System.out.print(schedule[i][j] + " ");
            }
            System.out.println();
        }
*/

        int[][] monthlyCalendar = new int[12][31];   // monthly calendar for 2022 fill up
        int day = 1;
        for (int i = 0; i < monthlyCalendar.length; i++) {
            for (int j = 0; j < monthlyCalendar[0].length; j++) {
                if (i == 0 || i == 3 || i == 5 || i == 8 || i == 10){
                    do {
                        monthlyCalendar[i][j] = day;
                        day++;
                    }
                    while (day <= 30);
                    } else if ( i == 1){
                        do {
                            monthlyCalendar[i][j] = day;
                            day++;
                        }
                        while (day <= 28);
                } else {
                    do {
                        monthlyCalendar[i][j] = day;
                        day++;
                    }
                    while (day <= 31);
                }
                System.out.print(monthlyCalendar[i][j] + " ");
            }
            day = 1;
            System.out.println();
        }


    }

}
