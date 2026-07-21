package StringPractice.Level2.lab1;

import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Physics marks: ");
        int physics = scanner.nextInt();
        System.out.print("Enter Chemistry marks: ");
        int chemistry = scanner.nextInt();
        System.out.print("Enter Mathematics marks: ");
        int mathematics = scanner.nextInt();
        scanner.close();
        int total = physics + chemistry + mathematics;
        double average = total / 3.0;
        double percentage = (total * 100.0) / 300.0;
        long roundedAverage = Math.round(average);
        long roundedPercentage = Math.round(percentage);
        String grade = assignGrade(roundedPercentage);
        System.out.println("Total: " + total);
        System.out.println("Average: " + roundedAverage);
        System.out.println("Percentage: " + roundedPercentage + "%");
        System.out.println("Grade: " + grade);
    }

    private static String assignGrade(long percentage) {
        if (percentage >= 90) {
            return "A+";
        }
        if (percentage >= 80) {
            return "A";
        }
        if (percentage >= 70) {
            return "B+";
        }
        if (percentage >= 60) {
            return "B";
        }
        if (percentage >= 50) {
            return "C";
        }
        if (percentage >= 40) {
            return "D";
        }
        return "F";
    }
}
