public class HospitalBilling {
    public static void main(String[] args) {
        try {
            int items = 0; // simulate zero items which may cause division by zero when computing per-item cost
            int[] patients = {1,2};
            String badNumber = "abc";

            // division-by-zero wrap
            try {
                int cost = 100 / items;
                System.out.println(cost);
            } catch (ArithmeticException e) {
                System.out.println("Billing error: cannot divide by zero items");
            }

            // array out-of-bounds
            try {
                System.out.println(patients[5]);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid patient index");
            }

            // number format
            try {
                Integer.parseInt(badNumber);
            } catch (NumberFormatException e) {
                System.out.println("Bad numeric input provided");
            }
        } catch (Exception e) {
            System.out.println("Hospital billing: unexpected error");
        }
    }
}
