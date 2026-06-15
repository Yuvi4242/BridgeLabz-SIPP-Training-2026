package level1;

import java.util.Scanner;

/**
 * SimpleInterestCalculator - Calculate simple interest for a loan
 * Formula: SI = (P * R * T) / 100
 */
public class SimpleInterestCalculator {
    
    /**
     * Calculates simple interest given principal, rate, and time
     * @param principal Amount borrowed
     * @param rate Annual interest rate in percentage
     * @param time Time period in years
     * @return Simple interest amount
     */
    public static double calculateSimpleInterest(double principal, double rate, double time) {
        return (principal * rate * time) / 100;
    }
    
    /**
     * Calculates total amount (Principal + Interest)
     * @param principal Amount borrowed
     * @param rate Annual interest rate in percentage
     * @param time Time period in years
     * @return Total amount to be paid
     */
    public static double calculateTotalAmount(double principal, double rate, double time) {
        double interest = calculateSimpleInterest(principal, rate, time);
        return principal + interest;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter Principal Amount: ");
        double principal = sc.nextDouble();
        
        System.out.print("Enter Annual Interest Rate (%): ");
        double rate = sc.nextDouble();
        
        System.out.print("Enter Time Period (years): ");
        double time = sc.nextDouble();
        
        double interest = calculateSimpleInterest(principal, rate, time);
        double totalAmount = calculateTotalAmount(principal, rate, time);
        
        System.out.println("\n--- Simple Interest Calculation ---");
        System.out.println("Principal Amount: " + principal);
        System.out.println("Interest Rate: " + rate + "%");
        System.out.println("Time Period: " + time + " years");
        System.out.println("Simple Interest: " + interest);
        System.out.println("Total Amount: " + totalAmount);
        
        sc.close();
    }
}
