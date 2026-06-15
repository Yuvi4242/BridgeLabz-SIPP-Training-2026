package level3;

import java.util.Scanner;

/**
 * CollinearPointsChecker - Check if three points are collinear
 * Points are collinear if they lie on the same straight line
 * Using slope method: (y2-y1)/(x2-x1) == (y3-y2)/(x3-x2)
 * Or area method: Area = 0.5 * |x1(y2-y3) + x2(y3-y1) + x3(y1-y2)| = 0
 */
public class CollinearPointsChecker {
    
    /**
     * Checks if three points are collinear using area method
     * @param x1 X coordinate of first point
     * @param y1 Y coordinate of first point
     * @param x2 X coordinate of second point
     * @param y2 Y coordinate of second point
     * @param x3 X coordinate of third point
     * @param y3 Y coordinate of third point
     * @return true if points are collinear
     */
    public static boolean areCollinear(double x1, double y1, double x2, double y2, double x3, double y3) {
        double area = x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2);
        return Math.abs(area) < 1e-9;
    }
    
    /**
     * Calculates distance between two points
     * @param x1 X coordinate of first point
     * @param y1 Y coordinate of first point
     * @param x2 X coordinate of second point
     * @param y2 Y coordinate of second point
     * @return Distance between points
     */
    public static double distance(double x1, double y1, double x2, double y2) {
        return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("--- Collinear Points Checker ---");
        System.out.print("Enter x1: ");
        double x1 = sc.nextDouble();
        System.out.print("Enter y1: ");
        double y1 = sc.nextDouble();
        
        System.out.print("Enter x2: ");
        double x2 = sc.nextDouble();
        System.out.print("Enter y2: ");
        double y2 = sc.nextDouble();
        
        System.out.print("Enter x3: ");
        double x3 = sc.nextDouble();
        System.out.print("Enter y3: ");
        double y3 = sc.nextDouble();
        
        boolean collinear = areCollinear(x1, y1, x2, y2, x3, y3);
        double d12 = distance(x1, y1, x2, y2);
        double d23 = distance(x2, y2, x3, y3);
        double d13 = distance(x1, y1, x3, y3);
        
        System.out.println("\n--- Results ---");
        System.out.println("Point 1: (" + x1 + ", " + y1 + ")");
        System.out.println("Point 2: (" + x2 + ", " + y2 + ")");
        System.out.println("Point 3: (" + x3 + ", " + y3 + ")");
        System.out.println("Are Collinear: " + collinear);
        System.out.println("Distance P1-P2: " + String.format("%.2f", d12));
        System.out.println("Distance P2-P3: " + String.format("%.2f", d23));
        System.out.println("Distance P1-P3: " + String.format("%.2f", d13));
        
        sc.close();
    }
}
