package level2;

import java.util.Scanner;

/**
 * UnitConverterLength2 - Convert between different length units (miles, yards, feet, inches)
 */
public class UnitConverterLength2 {
    
    /**
     * Converts miles to yards
     * @param miles Distance in miles
     * @return Distance in yards
     */
    public static double milesToYards(double miles) {
        return miles * 1760;
    }
    
    /**
     * Converts yards to feet
     * @param yards Distance in yards
     * @return Distance in feet
     */
    public static double yardsToFeet(double yards) {
        return yards * 3;
    }
    
    /**
     * Converts feet to inches
     * @param feet Distance in feet
     * @return Distance in inches
     */
    public static double feetToInches(double feet) {
        return feet * 12;
    }
    
    /**
     * Converts inches to feet
     * @param inches Distance in inches
     * @return Distance in feet
     */
    public static double inchesToFeet(double inches) {
        return inches / 12;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("--- Unit Converter Length2 ---");
        System.out.println("1. Miles to Yards");
        System.out.println("2. Yards to Feet");
        System.out.println("3. Feet to Inches");
        System.out.println("4. Inches to Feet");
        System.out.print("Choose conversion: ");
        int choice = sc.nextInt();
        
        System.out.print("Enter value: ");
        double value = sc.nextDouble();
        
        double result = 0;
        String conversion = "";
        
        switch (choice) {
            case 1:
                result = milesToYards(value);
                conversion = value + " miles = " + result + " yards";
                break;
            case 2:
                result = yardsToFeet(value);
                conversion = value + " yards = " + result + " feet";
                break;
            case 3:
                result = feetToInches(value);
                conversion = value + " feet = " + result + " inches";
                break;
            case 4:
                result = inchesToFeet(value);
                conversion = value + " inches = " + result + " feet";
                break;
            default:
                System.out.println("Invalid choice!");
                return;
        }
        
        System.out.println("Result: " + conversion);
        sc.close();
    }
}
