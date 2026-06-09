import java.util.Scanner;

public class ProfitLoss {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        double costPrice = 129;
        double sellingPrice = 191;
        
        double profit = sellingPrice - costPrice;
        double profitPercent = (profit / costPrice) * 100;
        
        System.out.println("Profit: " + profit);
        System.out.println("Profit Percentage: " + profitPercent);
        
        sc.close();
    }
}
