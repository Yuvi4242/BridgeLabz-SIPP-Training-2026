package level1;

import java.util.Scanner;

/**
 * TriangularParkRounds - Calculate distance covered in triangular park
 * Each side is of equal length, person runs n complete rounds
 */
public class TriangularParkRounds {
    
    /**
     * Calculates perimeter of equilateral triangle
     * @param side Length of each side
     * @return Perimeter of triangle
     */
    public static double calculatePerimeter(double side) {
        return 3 * side;
    }
    
    /**
     * Calculates total distance covered in n rounds
     * @param sideLength Length of each side of triangle
     * @param rounds Number of complete rounds
     * @return Total distance covered
     */
    public static double calculateDistanceCovered(double sideLength, int rounds) {
        double perimeter = calculatePerimeter(sideLength);
        return perimeter * rounds;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the length of each side of triangular park: ");
        double side = sc.nextDouble();
        
        System.out.print("Enter number of rounds: ");
        int rounds = sc.nextInt();
        
        double perimeter = calculatePerimeter(side);
        double totalDistance = calculateDistanceCovered(side, rounds);
        
        System.out.println("\n--- Triangular Park Rounds ---");
        System.out.println("Side length: " + side);
        System.out.println("Perimeter: " + perimeter);
        System.out.println("Number of rounds: " + rounds);
        System.out.println("Total distance covered: " + totalDistance);
        
        sc.close();
    }
}
