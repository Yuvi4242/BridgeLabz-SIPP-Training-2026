import java.util.Scanner;

public class PurchaseTotal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter unit price: ");
        double price = sc.nextDouble();
        System.out.print("Enter quantity: ");
        int qty = sc.nextInt();
        
        double total = price * qty;
        
        System.out.println("Total purchase price: " + total);
        
        sc.close();
    }
}
