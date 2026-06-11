package ArraysPractice.Lab2;

import java.util.Scanner;

public class EmployeeBonusCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int employeeCount = readPositiveInt(scanner, "Enter number of employees");
        double[] salaries = new double[employeeCount];
        double[] bonuses = new double[employeeCount];
        for (int index = 0; index < employeeCount; index++) {
            salaries[index] = readPositiveDouble(scanner, "Enter salary for employee " + (index + 1));
            int rating = readRating(scanner, "Enter performance rating for employee " + (index + 1) + " (1-100)");
            bonuses[index] = salaries[index] * determineBonusRate(rating);
        }
        for (int index = 0; index < employeeCount; index++) {
            System.out.printf("Employee %d salary %.2f bonus %.2f total %.2f%n", index + 1, salaries[index], bonuses[index], salaries[index] + bonuses[index]);
        }
        scanner.close();
    }

    private static double determineBonusRate(int rating) {
        if (rating >= 90) {
            return 0.20;
        }
        if (rating >= 80) {
            return 0.10;
        }
        return 0.05;
    }

    private static int readRating(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt + ": ");
            String input = scanner.nextLine().trim();
            try {
                int result = Integer.parseInt(input);
                if (result >= 1 && result <= 100) {
                    return result;
                }
            } catch (NumberFormatException ignored) {
            }
            System.out.println("Invalid rating. Enter an integer between 1 and 100.");
        }
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

    private static double readPositiveDouble(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt + ": ");
            String input = scanner.nextLine().trim();
            try {
                double result = Double.parseDouble(input);
                if (result > 0) {
                    return result;
                }
            } catch (NumberFormatException ignored) {
            }
            System.out.println("Invalid input. Please enter a positive decimal number.");
        }
    }
}
