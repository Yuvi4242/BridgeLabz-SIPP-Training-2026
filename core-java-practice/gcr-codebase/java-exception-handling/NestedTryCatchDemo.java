import java.util.Scanner;

public class NestedTryCatchDemo {
    public static void main(String[] args) {
        Integer[] arr = {10, 20, 30};
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter index: ");
            int idx = sc.nextInt();
            try {
                int val = arr[idx];
                System.out.print("Enter divisor: ");
                int d = sc.nextInt();
                try {
                    System.out.println("Result: " + (val / d));
                } catch (ArithmeticException e) {
                    System.out.println("Cannot divide by zero!");
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid array index!");
            }
        } finally {
            sc.close();
        }
    }
}
