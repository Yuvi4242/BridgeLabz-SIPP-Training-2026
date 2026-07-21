package level2;

import java.util.Scanner;

/**
 * BMICalculator - Calculate Body Mass Index
 * Formula: BMI = weight (kg) / (height (m) ^ 2)
 */
public class BMICalculator {
    
    /**
     * Calculates BMI given weight and height
     * @param weight Weight in kilograms
     * @param height Height in meters
     * @return BMI value
     */
    public static double calculateBMI(double weight, double height) {
        if (height == 0) {
            throw new IllegalArgumentException("Height cannot be zero!");
        }
        return weight / (height * height);
    }
    
    /**
     * Classifies BMI into categories
     * @param bmi BMI value
     * @return BMI category
     */
    public static String classifyBMI(double bmi) {
        if (bmi < 18.5) return "Underweight";
        if (bmi < 25) return "Normal weight";
        if (bmi < 30) return "Overweight";
        return "Obese";
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter weight (kg): ");
        double weight = sc.nextDouble();
        
        System.out.print("Enter height (m): ");
        double height = sc.nextDouble();
        
        try {
            double bmi = calculateBMI(weight, height);
            String category = classifyBMI(bmi);
            
            System.out.println("\n--- BMI Calculator ---");
            System.out.println("Weight: " + weight + " kg");
            System.out.println("Height: " + height + " m");
            System.out.println("BMI: " + String.format("%.2f", bmi));
            System.out.println("Category: " + category);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        sc.close();
    }
}
