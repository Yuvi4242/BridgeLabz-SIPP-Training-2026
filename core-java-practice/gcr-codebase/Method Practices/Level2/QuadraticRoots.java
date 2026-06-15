package level2;

import java.util.Scanner;

/**
 * QuadraticRoots - Find roots of quadratic equation using quadratic formula
 * ax² + bx + c = 0
 * x = (-b ± √(b² - 4ac)) / 2a
 */
public class QuadraticRoots {
    
    /**
     * Calculates discriminant
     * @param a Coefficient of x²
     * @param b Coefficient of x
     * @param c Constant term
     * @return Discriminant value
     */
    public static double calculateDiscriminant(double a, double b, double c) {
        return b * b - 4 * a * c;
    }
    
    /**
     * Finds roots of quadratic equation
     * @param a Coefficient of x²
     * @param b Coefficient of x
     * @param c Constant term
     */
    public static void findRoots(double a, double b, double c) {
        if (a == 0) {
            System.out.println("Not a quadratic equation (a cannot be 0)");
            return;
        }
        
        double discriminant = calculateDiscriminant(a, b, c);
        
        System.out.println("\n--- Quadratic Equation ---");
        System.out.println("Equation: " + a + "x² + " + b + "x + " + c + " = 0");
        System.out.println("Discriminant: " + discriminant);
        
        if (discriminant > 0) {
            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.println("Two real roots:");
            System.out.println("Root 1 (x1): " + root1);
            System.out.println("Root 2 (x2): " + root2);
        } else if (discriminant == 0) {
            double root = -b / (2 * a);
            System.out.println("One real root:");
            System.out.println("Root: " + root);
        } else {
            System.out.println("Complex roots (discriminant is negative)");
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter coefficient a: ");
        double a = sc.nextDouble();
        
        System.out.print("Enter coefficient b: ");
        double b = sc.nextDouble();
        
        System.out.print("Enter coefficient c: ");
        double c = sc.nextDouble();
        
        findRoots(a, b, c);
        
        sc.close();
    }
}
