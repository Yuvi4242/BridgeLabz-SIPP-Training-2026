import java.util.Scanner;

public class CoffeeCounter {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.print("Enter coffee type (Espresso/Latte/Cappuccino/Mocha) or exit: ");
            String coffee = sc.nextLine();

            if (coffee.equalsIgnoreCase("exit")) {
                System.out.println("Cafe Closed!");
                break;
            }

            int price = 0;

            switch (coffee.toLowerCase()) {

                case "espresso":
                    price = 120;
                    break;

                case "latte":
                    price = 150;
                    break;

                case "cappuccino":
                    price = 180;
                    break;

                case "mocha":
                    price = 200;
                    break;

                default:
                    System.out.println("Invalid Coffee Type!");
                    continue;
            }

            System.out.print("Enter quantity: ");
            int quantity = sc.nextInt();
            sc.nextLine();

            double bill = price * quantity;
            double gst = bill * 18 / 100.0;
            double total = bill + gst;

            System.out.println("Bill Amount : ₹" + bill);
            System.out.println("GST (18%)   : ₹" + gst);
            System.out.println("Total Bill  : ₹" + total);
            System.out.println();
        }

        sc.close();
    }
}