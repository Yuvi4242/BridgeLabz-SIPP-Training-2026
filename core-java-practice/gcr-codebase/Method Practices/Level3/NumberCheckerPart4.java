package level3;

import java.util.Scanner;

/**
 * NumberCheckerPart4 - Check Abundant, Deficient, Duck, and Strong numbers
 */
public class NumberCheckerPart4 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        long n = sc.nextLong();
        
        boolean isAbund = NumberCheckerUtility.isAbundant(n);
        boolean isDefic = NumberCheckerUtility.isDeficient(n);
        
        System.out.println("\n--- Number Checker Part4 ---");
        System.out.println("Number: " + n);
        System.out.println("Is Abundant: " + isAbund);
        System.out.println("Is Deficient: " + isDefic);
        
        sc.close();
    }
}
