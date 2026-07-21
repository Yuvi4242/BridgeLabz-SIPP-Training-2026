package level1;

import java.util.Scanner;

/**
 * SmallestAndLargestOfThree - Find smallest and largest among three numbers
 */
public class SmallestAndLargestOfThree {
    
    /**
     * Finds the smallest number among three
     * @param a First number
     * @param b Second number
     * @param c Third number
     * @return Smallest number
     */
    public static int findSmallest(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }
    
    /**
     * Finds the largest number among three
     * @param a First number
     * @param b Second number
     * @param c Third number
     * @return Largest number
     */
    public static int findLargest(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter first number: ");
        int a = sc.nextInt();
        
        System.out.print("Enter second number: ");
        int b = sc.nextInt();
        
        System.out.print("Enter third number: ");
        int c = sc.nextInt();
        
        int smallest = findSmallest(a, b, c);
        int largest = findLargest(a, b, c);
        
        System.out.println("\n--- Smallest and Largest ---");
        System.out.println("Numbers: " + a + ", " + b + ", " + c);
        System.out.println("Smallest: " + smallest);
        System.out.println("Largest: " + largest);
        
        sc.close();
    }
}
