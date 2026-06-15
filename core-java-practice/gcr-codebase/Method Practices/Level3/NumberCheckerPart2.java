package level3;

import java.util.Scanner;

/**
 * NumberCheckerPart2 - Check Prime, Neon, and Spy numbers
 */
public class NumberCheckerPart2 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        long n = sc.nextLong();
        
        boolean isPrime = NumberCheckerUtility.isPrime(n);
        boolean isNeon = NumberCheckerUtility.isNeon(n);
        boolean isSpy = NumberCheckerUtility.isSpy(n);
        
        System.out.println("\n--- Number Checker Part2 ---");
        System.out.println("Number: " + n);
        System.out.println("Is Prime: " + isPrime);
        System.out.println("Is Neon: " + isNeon);
        System.out.println("Is Spy: " + isSpy);
        
        sc.close();
    }
}
