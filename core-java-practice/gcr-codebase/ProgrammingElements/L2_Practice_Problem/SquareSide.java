import java.util.Scanner;

public class SquareSide {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter perimeter: ");
        double per = sc.nextDouble();
        
        double side = per / 4;
        
        System.out.println("Side of square: " + side);
        
        sc.close();
    }
}
