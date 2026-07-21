import java.util.Scanner;

public class KilometerToMilesInput {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter kilometers: ");
        double km = sc.nextDouble();
        
        double mi = km * 0.621371;
        
        System.out.println(km + " km is " + mi + " miles");
        
        sc.close();
    }
}
