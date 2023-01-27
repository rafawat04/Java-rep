import java.util.*;

public class CalendarApp {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
        int today = cal.get(Calendar.DATE);
        cal.set(Calendar.DATE, 1);
        int beforeBlank = cal.get(Calendar.DAY_OF_WEEK) - 1;
        int dayCount = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        System.out.printf("%16d/%d%n", year, month);
        String[] weeks = { "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat" };
        for (String s : weeks) {
            System.out.printf("%4s", s);
        }
        System.out.println();
        for (int i = 0; i < beforeBlank + dayCount; i++) {
            String str = "";
            if (i >= beforeBlank) {
                int date = i + 1 - beforeBlank;
                str = String.valueOf(date);
                if (date == today) {
                    str = "*" + str;
                }
            }
            System.out.printf("%4s", str);
            if ((i + 1) % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }
}
