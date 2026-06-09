import java.util.Scanner;

public class HeightConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter height in cm: ");
        double ht = sc.nextDouble();
        
        double totalInches = ht / 2.54;
        int feet = (int) totalInches / 12;
        double inches = totalInches % 12;
        
        System.out.println("Height: " + feet + " feet " + inches + " inches");
        
        sc.close();
    }
}
