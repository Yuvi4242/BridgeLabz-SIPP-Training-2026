import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ProductInventoryChecker {
    public static void main(String[] args) {
        File f = new File("inventory.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim(); if (line.isEmpty()) continue;
                String[] parts = line.split("[-]",2);
                if (parts.length < 2) continue;
                String name = parts[0].trim();
                int qty = 0;
                try { qty = Integer.parseInt(parts[1].trim()); } catch (NumberFormatException e) { continue; }
                if (qty == 0) System.out.println(name + " is out of stock");
            }
        } catch (FileNotFoundException e) {
            System.out.println("inventory.txt not found");
        } catch (IOException e) {
            System.out.println("Error reading inventory");
        }
    }
}
