import java.util.Scanner;

public class UniversityFee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        double fee = 125000;
        double discountPercent = 10;
        
        double discountAmount = (fee * discountPercent) / 100;
        double finalFee = fee - discountAmount;
        
        System.out.println("Discount Amount: " + discountAmount);
        System.out.println("Final Fee: " + finalFee);
        
        sc.close();
    }
}
