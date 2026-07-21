import java.util.Scanner;

public class TriangleArea {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter base: ");
        double base = sc.nextDouble();
        System.out.print("Enter height: ");
        double height = sc.nextDouble();
        
        double areaCm = (base * height) / 2;
        double areaInches = areaCm / 6.4516;
        
        System.out.println("Area in square cm: " + areaCm);
        System.out.println("Area in square inches: " + areaInches);
        
        sc.close();
    }
}
