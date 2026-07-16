import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class GroceryBillReader {
    public static void main(String[] args) {
        File f = new File("bill.txt");
        int lines = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                lines++;
            }
            System.out.println("Total lines: " + lines);
        } catch (FileNotFoundException e) {
            System.out.println("bill.txt not found");
        } catch (IOException e) {
            System.out.println("Error reading file");
        }
    }
}
