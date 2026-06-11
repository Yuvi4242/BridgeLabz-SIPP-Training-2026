package ArraysPractice.Lab2;

import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int subjectCount = readPositiveInt(scanner, "Enter number of subjects");
        int[] marks = new int[subjectCount];
        int totalMarks = 0;
        for (int index = 0; index < marks.length; index++) {
            marks[index] = readMark(scanner, "Enter marks for subject " + (index + 1));
            totalMarks += marks[index];
        }
        double average = (double) totalMarks / marks.length;
        System.out.printf("Average score is %.2f grade %s%n", average, gradeFromAverage(average));
        scanner.close();
    }

    private static int readPositiveInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt + ": ");
            String input = scanner.nextLine().trim();
            try {
                int result = Integer.parseInt(input);
                if (result > 0) {
                    return result;
                }
            } catch (NumberFormatException ignored) {
            }
            System.out.println("Invalid input. Please enter a positive integer.");
        }
    }

    private static int readMark(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt + " (0-100): ");
            String input = scanner.nextLine().trim();
            try {
                int mark = Integer.parseInt(input);
                if (mark >= 0 && mark <= 100) {
                    return mark;
                }
            } catch (NumberFormatException ignored) {
            }
            System.out.println("Invalid input. Enter a mark between 0 and 100.");
        }
    }

    private static String gradeFromAverage(double average) {
        if (average >= 90) {
            return "A";
        }
        if (average >= 80) {
            return "B";
        }
        if (average >= 70) {
            return "C";
        }
        if (average >= 60) {
            return "D";
        }
        return "F";
    }
}
