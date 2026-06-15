package level3;

import java.util.Scanner;

/**
 * StudentScoreCard - Calculate student grades and statistics
 */
public class StudentScoreCard {
    
    /**
     * Represents a student with scores
     */
    static class Student {
        String name;
        double[] scores;
        
        Student(String name, double[] scores) {
            this.name = name;
            this.scores = scores;
        }
    }
    
    /**
     * Calculates average score
     * @param scores Array of scores
     * @return Average score
     */
    public static double calculateAverage(double[] scores) {
        double sum = 0;
        for (double score : scores) {
            sum += score;
        }
        return sum / scores.length;
    }
    
    /**
     * Finds highest score
     * @param scores Array of scores
     * @return Highest score
     */
    public static double findHighest(double[] scores) {
        double max = scores[0];
        for (double score : scores) {
            if (score > max) max = score;
        }
        return max;
    }
    
    /**
     * Finds lowest score
     * @param scores Array of scores
     * @return Lowest score
     */
    public static double findLowest(double[] scores) {
        double min = scores[0];
        for (double score : scores) {
            if (score < min) min = score;
        }
        return min;
    }
    
    /**
     * Assigns grade based on average
     * @param average Average score
     * @return Grade letter
     */
    public static String assignGrade(double average) {
        if (average >= 90) return "A";
        if (average >= 80) return "B";
        if (average >= 70) return "C";
        if (average >= 60) return "D";
        return "F";
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter student name: ");
        String name = sc.nextLine();
        
        System.out.print("Enter number of subjects: ");
        int numSubjects = sc.nextInt();
        
        double[] scores = new double[numSubjects];
        
        System.out.println("Enter scores:");
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Subject " + (i + 1) + ": ");
            scores[i] = sc.nextDouble();
        }
        
        Student student = new Student(name, scores);
        double average = calculateAverage(scores);
        double highest = findHighest(scores);
        double lowest = findLowest(scores);
        String grade = assignGrade(average);
        
        System.out.println("\n--- Student Score Card ---");
        System.out.println("Name: " + student.name);
        System.out.println("Number of Subjects: " + numSubjects);
        System.out.println("Average Score: " + String.format("%.2f", average));
        System.out.println("Highest Score: " + highest);
        System.out.println("Lowest Score: " + lowest);
        System.out.println("Grade: " + grade);
        
        sc.close();
    }
}
