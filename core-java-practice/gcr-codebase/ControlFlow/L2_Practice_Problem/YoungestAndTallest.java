import java.util.Scanner;

public class YoungestAndTallest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter Amar age: ");
        int age1 = sc.nextInt();
        System.out.print("Enter Amar height: ");
        int h1 = sc.nextInt();
        
        System.out.print("Enter Akbar age: ");
        int age2 = sc.nextInt();
        System.out.print("Enter Akbar height: ");
        int h2 = sc.nextInt();
        
        System.out.print("Enter Anthony age: ");
        int age3 = sc.nextInt();
        System.out.print("Enter Anthony height: ");
        int h3 = sc.nextInt();
        
        int minAge = age1;
        String youngest = "Amar";
        if (age2 < minAge) {
            minAge = age2;
            youngest = "Akbar";
        }
        if (age3 < minAge) {
            minAge = age3;
            youngest = "Anthony";
        }
        
        int maxHeight = h1;
        String tallest = "Amar";
        if (h2 > maxHeight) {
            maxHeight = h2;
            tallest = "Akbar";
        }
        if (h3 > maxHeight) {
            maxHeight = h3;
            tallest = "Anthony";
        }
        
        System.out.println("Youngest: " + youngest);
        System.out.println("Tallest: " + tallest);
        
        sc.close();
    }
}
