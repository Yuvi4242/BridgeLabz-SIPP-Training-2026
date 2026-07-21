package ArraysPractice.Lab2;

import java.util.Scanner;

public class BMIAnalyzer2D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int personCount = readPositiveInt(scanner, "Enter number of people");
        double[][] measurements = new double[personCount][2];
        for (int index = 0; index < measurements.length; index++) {
            measurements[index][0] = readPositiveDouble(scanner, "Enter weight in kilograms for person " + (index + 1));
            measurements[index][1] = readPositiveDouble(scanner, "Enter height in meters for person " + (index + 1));
        }
        for (int index = 0; index < measurements.length; index++) {
            double weight = measurements[index][0];
            double height = measurements[index][1];
            double bmi = weight / (height * height);
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
