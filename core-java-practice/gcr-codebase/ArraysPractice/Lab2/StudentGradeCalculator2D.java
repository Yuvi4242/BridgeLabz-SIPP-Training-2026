package ArraysPractice.Lab2;

import java.util.Scanner;

public class StudentGradeCalculator2D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int studentCount = readPositiveInt(scanner, "Enter number of students");
        int subjectCount = readPositiveInt(scanner, "Enter number of subjects per student");
        int[][] marks = new int[studentCount][subjectCount];
        for (int student = 0; student < studentCount; student++) {
            for (int subject = 0; subject < subjectCount; subject++) {
                marks[student][subject] = readMark(scanner, "Enter marks for student " + (student + 1) + ", subject " + (subject + 1));
            }
        }
        for (int student = 0; student < marks.length; student++) {
            int sum = 0;
            for (int subject = 0; subject < marks[student].length; subject++) {
                sum += marks[student][subject];
            }
            double average = (double) sum / marks[student].length;
            System.out.printf("Student %d average %.2f grade %s%n", student + 1, average, gradeFromAverage(average));
        }
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
