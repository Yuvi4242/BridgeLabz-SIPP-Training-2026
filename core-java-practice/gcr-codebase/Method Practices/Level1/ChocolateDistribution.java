package level1;

import java.util.Scanner;

/**
 * ChocolateDistribution - Distribute chocolates equally with remainder distribution
 */
public class ChocolateDistribution {
    
    /**
     * Calculates chocolates per person
     * @param totalChocolates Total number of chocolates
     * @param numPeople Number of people
     * @return Chocolates per person
     */
    public static int chocolatesPerPerson(int totalChocolates, int numPeople) {
        if (numPeople == 0) {
            throw new IllegalArgumentException("Number of people cannot be zero!");
        }
        return totalChocolates / numPeople;
    }
    
    /**
     * Calculates remaining chocolates
     * @param totalChocolates Total number of chocolates
     * @param numPeople Number of people
     * @return Remaining chocolates
     */
    public static int remainingChocolates(int totalChocolates, int numPeople) {
        if (numPeople == 0) {
            throw new IllegalArgumentException("Number of people cannot be zero!");
        }
        return totalChocolates % numPeople;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter total number of chocolates: ");
        int total = sc.nextInt();
        
        System.out.print("Enter number of people: ");
        int people = sc.nextInt();
        
        try {
            int perPerson = chocolatesPerPerson(total, people);
            int remaining = remainingChocolates(total, people);
            
            System.out.println("\n--- Chocolate Distribution ---");
            System.out.println("Total chocolates: " + total);
            System.out.println("Number of people: " + people);
            System.out.println("Chocolates per person: " + perPerson);
            System.out.println("Remaining chocolates: " + remaining);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        sc.close();
    }
}
