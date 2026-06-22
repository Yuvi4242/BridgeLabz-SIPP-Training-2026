import java.io.*;

public class TryWithResourcesDemo {
    public static void main(String[] args) {
        File file = new File("info.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String first = br.readLine();
            System.out.println(first);
        } catch (IOException e) {
            System.out.println("Error reading file");
        }
    }
}
