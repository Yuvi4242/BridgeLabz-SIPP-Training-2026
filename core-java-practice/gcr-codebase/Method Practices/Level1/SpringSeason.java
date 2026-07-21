package level1;

import java.util.Scanner;

/**
 * SpringSeason - Check if given month is in spring season
 * Spring months: March (3), April (4), May (5)
 */
public class SpringSeason {
    
    /**
     * Checks if a given month is in spring season
     * @param month Month number (1-12)
     * @return true if month is in spring, false otherwise
     */
    public static boolean isSpringMonth(int month) {
        return month >= 3 && month <= 5;
    }
    
    /**
     * Gets the name of the month
     * @param month Month number (1-12)
     * @return Name of the month
     */
    public static String getMonthName(int month) {
        String[] months = {"", "January", "February", "March", "April", "May", 
                          "June", "July", "August", "September", "October", "November", "December"};
        if (month >= 1 && month <= 12) {
            return months[month];
        }
        return "Invalid";
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter month number (1-12): ");
        int month = sc.nextInt();
        
        if (month < 1 || month > 12) {
            System.out.println("Invalid month number!");
        } else {
            String monthName = getMonthName(month);
            boolean isSpring = isSpringMonth(month);
            
            System.out.println("\n--- Spring Season Check ---");
            System.out.println("Month: " + monthName);
            System.out.println("Is Spring Month: " + (isSpring ? "Yes" : "No"));
        }
        
        sc.close();
    }
}
