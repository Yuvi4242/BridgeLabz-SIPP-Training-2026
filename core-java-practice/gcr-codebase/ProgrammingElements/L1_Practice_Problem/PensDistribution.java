import java.util.Scanner;

public class PensDistribution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int pens = 14;
        int students = 3;
        
        int pensPerStudent = pens / students;
        int remainingPens = pens % students;
        
        System.out.println("Pens per student: " + pensPerStudent);
        System.out.println("Remaining pens: " + remainingPens);
        
        sc.close();
    }
}
