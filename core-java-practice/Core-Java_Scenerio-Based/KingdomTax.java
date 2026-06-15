import java.util.Scanner;

public class KingdomTax {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter income: ");
        double income = sc.nextDouble();
        double tax = calculateTax(income);
        String bracket = taxBracket(income);
        System.out.println("Tax Bracket: " + bracket);
        System.out.println("Tax Amount: " + tax);
        double[] incomes = {8200, 10450, 15800, 49500, 52000, 7600, 10900, 51000, 33000, 89000};
        double totalTax = 0;
        for (double value : incomes) {
            totalTax += calculateTax(value);
        }
        System.out.println("Total Tax Collected: " + totalTax);
        sc.close();
    }

    private static double calculateTax(double income) {
        if (income < 10000) {
            return income * 0.05;
        }
        if (income <= 50000) {
            return income * 0.15;
        }
        return income * 0.30;
    }

    private static String taxBracket(double income) {
        if (income < 10000) {
            return "5%";
        }
        if (income <= 50000) {
            return "15%";
        }
        return "30%";
    }
}
