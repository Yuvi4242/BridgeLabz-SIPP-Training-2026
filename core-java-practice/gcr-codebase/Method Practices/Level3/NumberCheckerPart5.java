package level3;

import java.util.Scanner;

/**
 * NumberCheckerPart5 - Comprehensive number analysis
 */
public class NumberCheckerPart5 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        long n = sc.nextLong();
        
        System.out.println("\n--- Complete Number Analysis ---");
        System.out.println("Number: " + n);
        System.out.println("Digit Count: " + NumberCheckerUtility.countDigits(n));
        System.out.println("Is Prime: " + NumberCheckerUtility.isPrime(n));
        System.out.println("Is Armstrong: " + NumberCheckerUtility.isArmstrong(n));
        System.out.println("Is Harshad: " + NumberCheckerUtility.isHarshad(n));
        System.out.println("Is Palindrome: " + NumberCheckerUtility.isPalindrome(n));
        System.out.println("Is Neon: " + NumberCheckerUtility.isNeon(n));
        System.out.println("Is Spy: " + NumberCheckerUtility.isSpy(n));
        System.out.println("Is Automorphic: " + NumberCheckerUtility.isAutomorphic(n));
        System.out.println("Is Buzz: " + NumberCheckerUtility.isBuzz(n));
        System.out.println("Is Perfect: " + NumberCheckerUtility.isPerfect(n));
        System.out.println("Is Abundant: " + NumberCheckerUtility.isAbundant(n));
        System.out.println("Is Deficient: " + NumberCheckerUtility.isDeficient(n));
        
        sc.close();
    }
}
