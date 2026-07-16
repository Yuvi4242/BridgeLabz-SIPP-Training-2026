import java.util.Scanner;

public class AveragePCM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int maths = 94;
        int physics = 95;
        int chemistry = 96;
        
        double avg = (maths + physics + chemistry) / 3.0;
        double per = (avg / 100) * 100;
        
        System.out.println("Average: " + avg);
        System.out.println("Percentage: " + per);
        
        sc.close();
    }
}
