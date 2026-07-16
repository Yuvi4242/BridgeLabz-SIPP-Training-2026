package level3;

import java.util.Scanner;

/**
 * NumberCheckerPart1 - Check Armstrong, Harshad, and Palindrome numbers
 */
public class NumberCheckerPart1 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        long n = sc.nextLong();
        
        boolean isArm = NumberCheckerUtility.isArmstrong(n);
        boolean isHarsh = NumberCheckerUtility.isHarshad(n);
        boolean isPal = NumberCheckerUtility.isPalindrome(n);
        
        System.out.println("\n--- Number Checker Part1 ---");
        System.out.println("Number: " + n);
        System.out.println("Is Armstrong: " + isArm);
        System.out.println("Is Harshad: " + isHarsh);
        System.out.println("Is Palindrome: " + isPal);
        
        sc.close();
    }
}
