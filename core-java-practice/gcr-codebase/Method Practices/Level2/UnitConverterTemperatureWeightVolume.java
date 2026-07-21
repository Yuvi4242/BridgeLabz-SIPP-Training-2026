package level2;

import java.util.Scanner;

/**
 * UnitConverterTemperatureWeightVolume - Convert temperature, weight, and volume units
 */
public class UnitConverterTemperatureWeightVolume {
    
    /**
     * Converts Celsius to Fahrenheit
     * @param celsius Temperature in Celsius
     * @return Temperature in Fahrenheit
     */
    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }
    
    /**
     * Converts Fahrenheit to Celsius
     * @param fahrenheit Temperature in Fahrenheit
     * @return Temperature in Celsius
     */
    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }
    
    /**
     * Converts kilograms to pounds
     * @param kg Weight in kilograms
     * @return Weight in pounds
     */
    public static double kgToLbs(double kg) {
        return kg * 2.20462;
    }
    
    /**
     * Converts pounds to kilograms
     * @param lbs Weight in pounds
     * @return Weight in kilograms
     */
    public static double lbsToKg(double lbs) {
        return lbs / 2.20462;
    }
    
    /**
     * Converts liters to gallons
     * @param liters Volume in liters
     * @return Volume in gallons
     */
    public static double litersToGallons(double liters) {
        return liters / 3.78541;
    }
    
    /**
     * Converts gallons to liters
     * @param gallons Volume in gallons
     * @return Volume in liters
     */
    public static double gallonsToLiters(double gallons) {
        return gallons * 3.78541;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("--- Unit Converter (Temperature, Weight, Volume) ---");
        System.out.println("1. Celsius to Fahrenheit");
        System.out.println("2. Fahrenheit to Celsius");
        System.out.println("3. Kg to Lbs");
        System.out.println("4. Lbs to Kg");
        System.out.println("5. Liters to Gallons");
        System.out.println("6. Gallons to Liters");
        System.out.print("Choose conversion: ");
        int choice = sc.nextInt();
        
        System.out.print("Enter value: ");
        double value = sc.nextDouble();
        
        double result = 0;
        String conversion = "";
        
        switch (choice) {
            case 1:
                result = celsiusToFahrenheit(value);
                conversion = value + "°C = " + String.format("%.2f", result) + "°F";
                break;
            case 2:
                result = fahrenheitToCelsius(value);
                conversion = value + "°F = " + String.format("%.2f", result) + "°C";
                break;
            case 3:
                result = kgToLbs(value);
                conversion = value + " kg = " + String.format("%.2f", result) + " lbs";
                break;
            case 4:
                result = lbsToKg(value);
                conversion = value + " lbs = " + String.format("%.2f", result) + " kg";
                break;
            case 5:
                result = litersToGallons(value);
                conversion = value + " L = " + String.format("%.2f", result) + " gal";
                break;
            case 6:
                result = gallonsToLiters(value);
                conversion = value + " gal = " + String.format("%.2f", result) + " L";
                break;
            default:
                System.out.println("Invalid choice!");
                return;
        }
        
        System.out.println("Result: " + conversion);
        sc.close();
    }
}
