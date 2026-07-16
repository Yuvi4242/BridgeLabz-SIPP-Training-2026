import java.util.Scanner;

public class UniversityFeeInput {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter fee: ");
        double fee = sc.nextDouble();
        System.out.print("Enter discount percentage: ");
        double discountPercent = sc.nextDouble();
        
        double discountAmount = (fee * discountPercent) / 100;
        double finalFee = fee - discountAmount;
        
        System.out.println("Discount Amount: " + discountAmount);
        System.out.println("Final Fee: " + finalFee);
        
        sc.close();
    }
}
