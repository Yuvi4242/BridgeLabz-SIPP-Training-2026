import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DailyExpenseLogger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("How many expenses to add? ");
        int n = 0;
        try { n = Integer.parseInt(sc.nextLine().trim()); } catch (Exception e) { System.out.println("Invalid number"); sc.close(); return; }
        File f = new File("expenses.txt");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(f, true))) {
            for (int i = 0; i < n; i++) {
                System.out.print("Enter description: ");
                String desc = sc.nextLine().trim();
                System.out.print("Enter amount: ");
                String amt = sc.nextLine().trim();
                bw.write(desc + " - " + amt);
                bw.newLine();
            }
            System.out.println("Expenses appended to expenses.txt");
        } catch (IOException e) {
            System.out.println("Error writing expenses");
        } finally {
            sc.close();
        }
    }
}
