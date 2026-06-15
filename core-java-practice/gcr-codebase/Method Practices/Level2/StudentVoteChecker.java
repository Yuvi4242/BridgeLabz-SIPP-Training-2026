package level2;

import java.util.Scanner;

/**
 * StudentVoteChecker - Check voting eligibility and collect votes
 */
public class StudentVoteChecker {
    
    /**
     * Checks if a student is eligible to vote
     * @param age Age of the student
     * @return true if eligible (age >= 18), false otherwise
     */
    public static boolean isEligibleToVote(int age) {
        return age >= 18;
    }
    
    /**
     * Collects vote from an eligible student
     * @param age Age of the student
     * @param candidate Candidate name they vote for
     * @return Vote message
     */
    public static String castVote(int age, String candidate) {
        if (isEligibleToVote(age)) {
            return "Vote for " + candidate + " is recorded.";
        } else {
            return "Not eligible to vote. Must be 18 or older.";
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("--- Student Vote Checker ---");
        System.out.print("Enter your age: ");
        int age = sc.nextInt();
        sc.nextLine();
        
        System.out.print("Enter candidate name: ");
        String candidate = sc.nextLine();
        
        String result = castVote(age, candidate);
        System.out.println("\n" + result);
        
        sc.close();
    }
}
