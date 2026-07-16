package level3;

import java.util.Scanner;

/**
 * CalendarDisplay - Display calendar for a given month and year
 */
public class CalendarDisplay {
    
    /**
     * Checks if year is leap year
     * @param year Year to check
     * @return true if leap year
     */
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
    
    /**
     * Gets number of days in a month
     * @param month Month number (1-12)
     * @param year Year
     * @return Number of days in month
     */
    public static int getDaysInMonth(int month, int year) {
        int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (month == 2 && isLeapYear(year)) {
            return 29;
        }
        return days[month];
    }
    
    /**
     * Calculates day of week for first day of month using Zeller's algorithm
     * @param month Month number (1-12)
     * @param year Year
     * @return Day of week (0=Saturday to 6=Friday)
     */
    public static int getFirstDayOfMonth(int month, int year) {
        if (month < 3) {
            month += 12;
            year--;
        }
        int q = 1;
        int m = month;
        int k = year % 100;
        int j = year / 100;
        int h = (q + (13 * (m + 1)) / 5 + k + k / 4 + j / 4 - 2 * j) % 7;
        return (h + 5) % 7;
    }
    
    /**
     * Displays calendar for given month and year
     * @param month Month number (1-12)
     * @param year Year
     */
    public static void displayCalendar(int month, int year) {
        String[] monthNames = {"", "January", "February", "March", "April", "May", 
                              "June", "July", "August", "September", "October", 
                              "November", "December"};
        
        System.out.println("\n     " + monthNames[month] + " " + year);
        System.out.println("Su Mo Tu We Th Fr Sa");
        
        int firstDay = getFirstDayOfMonth(month, year);
        int daysInMonth = getDaysInMonth(month, year);
        
        for (int i = 0; i < firstDay; i++) {
            System.out.print("   ");
        }
        
        for (int day = 1; day <= daysInMonth; day++) {
            System.out.printf("%2d ", day);
            if ((day + firstDay) % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter month (1-12): ");
        int month = sc.nextInt();
        
        System.out.print("Enter year: ");
        int year = sc.nextInt();
        
        if (month < 1 || month > 12) {
            System.out.println("Invalid month!");
        } else {
            displayCalendar(month, year);
        }
        
        sc.close();
    }
}
