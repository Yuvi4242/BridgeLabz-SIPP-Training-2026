package level1;

import java.util.Scanner;

/**
 * TrigonometricFunctions - Calculate trigonometric functions (sin, cos, tan)
 */
public class TrigonometricFunctions {
    
    /**
     * Converts degrees to radians
     * @param degrees Angle in degrees
     * @return Angle in radians
     */
    public static double degreesToRadians(double degrees) {
        return degrees * Math.PI / 180.0;
    }
    
    /**
     * Calculates sine of an angle
     * @param degrees Angle in degrees
     * @return Sine value
     */
    public static double calculateSine(double degrees) {
        double radians = degreesToRadians(degrees);
        return Math.sin(radians);
    }
    
    /**
     * Calculates cosine of an angle
     * @param degrees Angle in degrees
     * @return Cosine value
     */
    public static double calculateCosine(double degrees) {
        double radians = degreesToRadians(degrees);
        return Math.cos(radians);
    }
    
    /**
     * Calculates tangent of an angle
     * @param degrees Angle in degrees
     * @return Tangent value
     */
    public static double calculateTangent(double degrees) {
        double radians = degreesToRadians(degrees);
        return Math.tan(radians);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter angle in degrees: ");
        double degrees = sc.nextDouble();
        
        double sine = calculateSine(degrees);
        double cosine = calculateCosine(degrees);
        double tangent = calculateTangent(degrees);
        
        System.out.println("\n--- Trigonometric Functions ---");
        System.out.println("Angle: " + degrees + "°");
        System.out.println("sin(" + degrees + "°) = " + String.format("%.4f", sine));
        System.out.println("cos(" + degrees + "°) = " + String.format("%.4f", cosine));
        System.out.println("tan(" + degrees + "°) = " + String.format("%.4f", tangent));
        
        sc.close();
    }
}
