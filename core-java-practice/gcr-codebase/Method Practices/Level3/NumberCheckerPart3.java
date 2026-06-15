package level3;

import java.util.Scanner;

/**
 * NumberCheckerPart3 - Check Automorphic, Buzz, and Perfect numbers
 */
public class NumberCheckerPart3 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        long n = sc.nextLong();
        
        boolean isAuto = NumberCheckerUtility.isAutomorphic(n);
        boolean isBuzz = NumberCheckerUtility.isBuzz(n);
        boolean isPerfect = NumberCheckerUtility.isPerfect(n);
        
        System.out.println("\n--- Number Checker Part3 ---");
        System.out.println("Number: " + n);
        System.out.println("Is Automorphic: " + isAuto);
        System.out.println("Is Buzz: " + isBuzz);
        System.out.println("Is Perfect: " + isPerfect);
        
        sc.close();
    }
}
