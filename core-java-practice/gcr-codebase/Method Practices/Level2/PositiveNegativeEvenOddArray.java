package level2;

import java.util.Scanner;

/**
 * PositiveNegativeEvenOddArray - Classify array elements as positive/negative and even/odd
 */
public class PositiveNegativeEvenOddArray {
    
    /**
     * Counts positive numbers in array
     * @param arr Input array
     * @return Count of positive numbers
     */
    public static int countPositive(int[] arr) {
        int count = 0;
        for (int num : arr) {
            if (num > 0) count++;
        }
        return count;
    }
    
    /**
     * Counts negative numbers in array
     * @param arr Input array
     * @return Count of negative numbers
     */
    public static int countNegative(int[] arr) {
        int count = 0;
        for (int num : arr) {
            if (num < 0) count++;
        }
        return count;
    }
    
    /**
     * Counts even numbers in array
     * @param arr Input array
     * @return Count of even numbers
     */
    public static int countEven(int[] arr) {
        int count = 0;
        for (int num : arr) {
            if (num % 2 == 0) count++;
        }
        return count;
    }
    
    /**
     * Counts odd numbers in array
     * @param arr Input array
     * @return Count of odd numbers
     */
    public static int countOdd(int[] arr) {
        int count = 0;
        for (int num : arr) {
            if (num % 2 != 0) count++;
        }
        return count;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter array size: ");
        int size = sc.nextInt();
        
        int[] arr = new int[size];
        
        System.out.println("Enter array elements:");
        for (int i = 0; i < size; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            arr[i] = sc.nextInt();
        }
        
        int positive = countPositive(arr);
        int negative = countNegative(arr);
        int even = countEven(arr);
        int odd = countOdd(arr);
        
        System.out.println("\n--- Array Classification ---");
        System.out.println("Positive numbers: " + positive);
        System.out.println("Negative numbers: " + negative);
        System.out.println("Even numbers: " + even);
        System.out.println("Odd numbers: " + odd);
        
        sc.close();
    }
}
