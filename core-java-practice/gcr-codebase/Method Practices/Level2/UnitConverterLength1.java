package level2;

import java.util.Scanner;

/**
 * UnitConverterLength1 - Convert between different length units (km, m, cm)
 */
public class UnitConverterLength1 {
    
    /**
     * Converts kilometers to meters
     * @param km Distance in kilometers
     * @return Distance in meters
     */
    public static double kmToM(double km) {
        return km * 1000;
    }
    
    /**
     * Converts meters to kilometers
     * @param m Distance in meters
     * @return Distance in kilometers
     */
    public static double mToKm(double m) {
        return m / 1000;
    }
    
    /**
     * Converts meters to centimeters
     * @param m Distance in meters
     * @return Distance in centimeters
     */
    public static double mToCm(double m) {
        return m * 100;
    }
    
    /**
     * Converts centimeters to meters
     * @param cm Distance in centimeters
     * @return Distance in meters
     */
    public static double cmToM(double cm) {
        return cm / 100;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("--- Unit Converter Length1 ---");
        System.out.println("1. Km to M");
        System.out.println("2. M to Km");
        System.out.println("3. M to Cm");
        System.out.println("4. Cm to M");
        System.out.print("Choose conversion: ");
        int choice = sc.nextInt();
        
        System.out.print("Enter value: ");
        double value = sc.nextDouble();
        
        double result = 0;
        String conversion = "";
        
        switch (choice) {
            case 1:
                result = kmToM(value);
                conversion = value + " km = " + result + " m";
                break;
            case 2:
                result = mToKm(value);
                conversion = value + " m = " + result + " km";
                break;
            case 3:
                result = mToCm(value);
                conversion = value + " m = " + result + " cm";
                break;
            case 4:
                result = cmToM(value);
                conversion = value + " cm = " + result + " m";
                break;
            default:
                System.out.println("Invalid choice!");
                return;
        }
        
        System.out.println("Result: " + conversion);
        sc.close();
    }
}
