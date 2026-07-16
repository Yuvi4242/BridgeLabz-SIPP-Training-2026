package level3;

import java.util.Scanner;

/**
 * EuclideanDistanceAndLineEquation - Calculate distance and find line equation between two points
 */
public class EuclideanDistanceAndLineEquation {
    
    /**
     * Calculates Euclidean distance between two points
     * @param x1 X coordinate of first point
     * @param y1 Y coordinate of first point
     * @param x2 X coordinate of second point
     * @param y2 Y coordinate of second point
     * @return Distance between points
     */
    public static double calculateDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
    }
    
    /**
     * Calculates slope of line between two points
     * @param x1 X coordinate of first point
     * @param y1 Y coordinate of first point
     * @param x2 X coordinate of second point
     * @param y2 Y coordinate of second point
     * @return Slope of line
     */
    public static double calculateSlope(double x1, double y1, double x2, double y2) {
        if (x2 == x1) return Double.POSITIVE_INFINITY;
        return (y2 - y1) / (x2 - x1);
    }
    
    /**
     * Calculates Y-intercept
     * @param x X coordinate
     * @param y Y coordinate
     * @param slope Slope of line
     * @return Y-intercept
     */
    public static double calculateIntercept(double x, double y, double slope) {
        return y - slope * x;
    }
    
    /**
     * Generates line equation as string
     * @param slope Slope of line
     * @param intercept Y-intercept
     * @return Line equation string
     */
    public static String getLineEquation(double slope, double intercept) {
        if (slope == Double.POSITIVE_INFINITY) {
            return "Vertical line";
        }
        if (intercept >= 0) {
            return "y = " + String.format("%.2f", slope) + "x + " + String.format("%.2f", intercept);
        } else {
            return "y = " + String.format("%.2f", slope) + "x - " + String.format("%.2f", Math.abs(intercept));
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("--- Euclidean Distance and Line Equation ---");
        System.out.print("Enter x1: ");
        double x1 = sc.nextDouble();
        System.out.print("Enter y1: ");
        double y1 = sc.nextDouble();
        
        System.out.print("Enter x2: ");
        double x2 = sc.nextDouble();
        System.out.print("Enter y2: ");
        double y2 = sc.nextDouble();
        
        double distance = calculateDistance(x1, y1, x2, y2);
        double slope = calculateSlope(x1, y1, x2, y2);
        double intercept = (slope == Double.POSITIVE_INFINITY) ? 0 : calculateIntercept(x1, y1, slope);
        String equation = getLineEquation(slope, intercept);
        
        System.out.println("\n--- Results ---");
        System.out.println("Point 1: (" + x1 + ", " + y1 + ")");
        System.out.println("Point 2: (" + x2 + ", " + y2 + ")");
        System.out.println("Distance: " + String.format("%.2f", distance));
        if (slope == Double.POSITIVE_INFINITY) {
            System.out.println("Slope: Undefined (vertical line)");
        } else {
            System.out.println("Slope: " + String.format("%.2f", slope));
        }
        System.out.println("Line Equation: " + equation);
        
        sc.close();
    }
}
