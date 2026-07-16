package level2;

import java.util.Scanner;

/**
 * LeapYearChecker - Check if a year is a leap year
 * Rules: Divisible by 4 AND (NOT divisible by 100 OR divisible by 400)
 */
public class LeapYearChecker {
    
    /**
     * Checks if a year is a leap year
     * @param year Year to check
     * @return true if leap year, false otherwise
     */
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
    
    /**
     * Gets the number of days in a year
     * @param year Year to check
     * @return 366 for leap year, 365 for non-leap year
     */
    public static int daysInYear(int year) {
        return isLeapYear(year) ? 366 : 365;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a year: ");
        int year = sc.nextInt();
        
        boolean leap = isLeapYear(year);
        int days = daysInYear(year);
        
        System.out.println("\n--- Leap Year Checker ---");
        System.out.println("Year: " + year);
        System.out.println("Is Leap Year: " + (leap ? "Yes" : "No"));
        System.out.println("Days in year: " + days);
        
        sc.close();
    }
}
