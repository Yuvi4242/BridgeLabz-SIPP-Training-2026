import java.util.Scanner;

public class TriangleArea {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter base in cm: ");
        double base = sc.nextDouble();
        System.out.print("Enter height in cm: ");
        double ht = sc.nextDouble();
        
        double areaCm = (base * ht) / 2;
        double areaInches = areaCm / (2.54 * 2.54);
        
        System.out.println("Area in square cm: " + areaCm);
        System.out.println("Area in square inches: " + areaInches);
        
        sc.close();
    }
}
