package level1;

import java.util.Scanner;

/**
 * PositiveNegativeZeroChecker - Classify a number as positive, negative, or zero
 */
public class PositiveNegativeZeroChecker {
    
    /**
     * Checks if a number is positive, negative, or zero
     * @param num Number to check
     * @return String describing the number type
     */
    public static String checkNumber(double num) {
        if (num > 0) {
            return "Positive";
        } else if (num < 0) {
            return "Negative";
        } else {
            return "Zero";
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        double num = sc.nextDouble();
        
        String result = checkNumber(num);
        
        System.out.println("\n--- Number Classification ---");
        System.out.println("Number: " + num);
        System.out.println("Type: " + result);
        
        sc.close();
    }
}
