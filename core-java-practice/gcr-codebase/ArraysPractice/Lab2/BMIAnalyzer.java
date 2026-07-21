package ArraysPractice.Lab2;

import java.util.Scanner;

public class BMIAnalyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int personCount = readPositiveInt(scanner, "Enter number of people");
        double[] weights = new double[personCount];
        double[] heights = new double[personCount];
        for (int index = 0; index < personCount; index++) {
            weights[index] = readPositiveDouble(scanner, "Enter weight in kilograms for person " + (index + 1));
            heights[index] = readPositiveDouble(scanner, "Enter height in meters for person " + (index + 1));
        }
        for (int index = 0; index < personCount; index++) {
            double bmi = weights[index] / (heights[index] * heights[index]);
            System.out.printf("Person %d BMI %.2f category %s%n", index + 1, bmi, bmiCategory(bmi));
        }
        scanner.close();
    }

    private static String bmiCategory(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        }
        if (bmi < 25) {
            return "Normal weight";
        }
        if (bmi < 30) {
            return "Overweight";
        }
        return "Obesity";
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
