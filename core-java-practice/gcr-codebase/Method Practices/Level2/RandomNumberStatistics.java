package level2;

import java.util.Random;
import java.util.Scanner;

/**
 * RandomNumberStatistics - Generate random numbers and calculate statistics
 */
public class RandomNumberStatistics {
    
    /**
     * Generates array of random numbers
     * @param size Size of array
     * @param max Maximum value (exclusive)
     * @return Array of random numbers
     */
    public static int[] generateRandomNumbers(int size, int max) {
        Random random = new Random();
        int[] numbers = new int[size];
        for (int i = 0; i < size; i++) {
            numbers[i] = random.nextInt(max);
        }
        return numbers;
    }
    
    /**
     * Calculates mean of array
     * @param arr Input array
     * @return Mean value
     */
    public static double calculateMean(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return (double) sum / arr.length;
    }
    
    /**
     * Finds maximum value in array
     * @param arr Input array
     * @return Maximum value
     */
    public static int findMax(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            if (num > max) max = num;
        }
        return max;
    }
    
    /**
     * Finds minimum value in array
     * @param arr Input array
     * @return Minimum value
     */
    public static int findMin(int[] arr) {
        int min = arr[0];
        for (int num : arr) {
            if (num < min) min = num;
        }
        return min;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter size of random array: ");
        int size = sc.nextInt();
        
        System.out.print("Enter maximum value: ");
        int max = sc.nextInt();
        
        int[] numbers = generateRandomNumbers(size, max);
        double mean = calculateMean(numbers);
        int maxValue = findMax(numbers);
        int minValue = findMin(numbers);
        
        System.out.println("\n--- Random Number Statistics ---");
        System.out.print("Generated numbers: ");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();
        System.out.println("Mean: " + String.format("%.2f", mean));
        System.out.println("Maximum: " + maxValue);
        System.out.println("Minimum: " + minValue);
        
        sc.close();
    }
}
