import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter weight in kg: ");
        double wt = sc.nextDouble();
        System.out.print("Enter height in cm: ");
        double ht = sc.nextDouble();
        
        double htMeter = ht / 100.0;
        double bmi = wt / (htMeter * htMeter);
        
        System.out.println("BMI: " + bmi);
        
        if (bmi < 18.5) {
            System.out.println("Underweight");
        } else if (bmi >= 18.5 && bmi <= 24.9) {
            System.out.println("Normal Weight");
        } else if (bmi >= 25 && bmi <= 29.9) {
            System.out.println("Overweight");
        } else {
            System.out.println("Obese");
        }
        
        sc.close();
    }
}
