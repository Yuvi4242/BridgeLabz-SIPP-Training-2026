package level3;

import java.util.Scanner;

/**
 * FootballTeamHeightStatistics - Calculate height statistics for football teams
 */
public class FootballTeamHeightStatistics {
    
    /**
     * Calculates average height
     * @param heights Array of heights
     * @return Average height
     */
    public static double calculateAverage(double[] heights) {
        double sum = 0;
        for (double height : heights) {
            sum += height;
        }
        return sum / heights.length;
    }
    
    /**
     * Finds tallest player
     * @param heights Array of heights
     * @return Maximum height
     */
    public static double findTallest(double[] heights) {
        double max = heights[0];
        for (double height : heights) {
            if (height > max) max = height;
        }
        return max;
    }
    
    /**
     * Finds shortest player
     * @param heights Array of heights
     * @return Minimum height
     */
    public static double findShortest(double[] heights) {
        double min = heights[0];
        for (double height : heights) {
            if (height < min) min = height;
        }
        return min;
    }
    
    /**
     * Counts players above average height
     * @param heights Array of heights
     * @param average Average height
     * @return Count of players above average
     */
    public static int countAboveAverage(double[] heights, double average) {
        int count = 0;
        for (double height : heights) {
            if (height > average) count++;
        }
        return count;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number of players: ");
        int n = sc.nextInt();
        
        double[] heights = new double[n];
        
        System.out.println("Enter heights of players (in cm):");
        for (int i = 0; i < n; i++) {
            System.out.print("Player " + (i + 1) + ": ");
            heights[i] = sc.nextDouble();
        }
        
        double average = calculateAverage(heights);
        double tallest = findTallest(heights);
        double shortest = findShortest(heights);
        int aboveAverage = countAboveAverage(heights, average);
        
        System.out.println("\n--- Football Team Height Statistics ---");
        System.out.println("Average Height: " + String.format("%.2f", average) + " cm");
        System.out.println("Tallest Player: " + tallest + " cm");
        System.out.println("Shortest Player: " + shortest + " cm");
        System.out.println("Players Above Average: " + aboveAverage);
        
        sc.close();
    }
}
