import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Physics marks: ");
        int phy = sc.nextInt();
        System.out.print("Enter Chemistry marks: ");
        int chem = sc.nextInt();
        System.out.print("Enter Maths marks: ");
        int math = sc.nextInt();
        
        int total = phy + chem + math;
        double avg = total / 3.0;
        double per = (total / 300.0) * 100;
        
        System.out.println("Total: " + total);
        System.out.println("Average: " + avg);
        System.out.println("Percentage: " + per);
        
        char grade;
        if (per >= 90) {
            grade = 'A';
        } else if (per >= 80) {
            grade = 'B';
        } else if (per >= 70) {
            grade = 'C';
        } else if (per >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }
        
        System.out.println("Grade: " + grade);
        
        if (per >= 40) {
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }
        
        sc.close();
    }
}
