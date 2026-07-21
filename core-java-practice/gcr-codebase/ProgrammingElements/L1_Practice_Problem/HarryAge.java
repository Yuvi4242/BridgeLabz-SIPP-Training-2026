import java.util.Scanner;

public class HarryAge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int birthYear = 2000;
        int currentYear = 2024;
        int age = currentYear - birthYear;
        
        System.out.println("Harry's age: " + age);
        
        sc.close();
    }
}
