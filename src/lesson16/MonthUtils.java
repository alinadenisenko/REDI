package lesson16;

import java.util.HashMap;
import java.util.Map;

public class MonthUtils {

    public static String getMonthName(int month) {
        switch (month) {
            case 1:  return "January";
            case 2:  return "February";
            case 3:  return "March";
            case 4:  return "April";
            case 5:  return "May";
            case 6:  return "June";
            case 7:  return "July";
            case 8:  return "August";
            case 9:  return "September";
            case 10: return "October";
            case 11: return "November";
            case 12: return "December";
            default: throw new InvalidMonthException();
        }
    }

    private static Map<Integer, String> months = new HashMap<>();

    // init block in the static context! (so this map is reused by all instances of the class)
    static {
        months.put(1, "January");
        months.put(2, "February");
        months.put(3, "March");
        months.put(4, "April");
        months.put(5, "May");
        months.put(6, "June");
        months.put(7, "July");
        months.put(8, "August");
        months.put(9, "September");
        months.put(10, "October");
        months.put(11, "November");
        months.put(12, "December");
    }

    public static String getMonthNameUsingMap(int month) {
        if (month < 1 || month > 12) {
            throw new InvalidMonthException();
        }
        return months.get(month);
    }
}
