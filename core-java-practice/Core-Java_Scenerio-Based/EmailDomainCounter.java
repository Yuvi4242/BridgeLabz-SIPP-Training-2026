import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class EmailDomainCounter {
    public static void main(String[] args) {
        File f = new File("emails.txt");
        Map<String,Integer> counts = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim(); if (line.isEmpty()) continue;
                int at = line.indexOf('@');
                if (at > 0 && at < line.length()-1) {
                    String domain = line.substring(at+1);
                    counts.put(domain, counts.getOrDefault(domain,0)+1);
                }
            }
            counts.forEach((k,v)-> System.out.println(k + " => " + v));
        } catch (FileNotFoundException e) {
            System.out.println("emails.txt not found");
        } catch (IOException e) {
            System.out.println("Error reading file");
        }
    }
}
