import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SchoolResultPortal {
    // Expected input format per line: Name,mark1,mark2,mark3
    public static void main(String[] args) {
        File input = new File("students.txt");
        File out = new File("report_cards.txt");
        try (Scanner sc = new Scanner(input)) {
            List<String> reports = new ArrayList<>();
            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                if (line.isEmpty()) continue;
                String[] parts = line.split("[,\\s]+", 2);
                String name = parts[0];
                String[] marks = parts.length > 1 ? parts[1].split("[,\\s]+") : new String[0];
                double sum = 0;
                int cnt = 0;
                for (String m : marks) {
                    try { sum += Double.parseDouble(m); cnt++; } catch (NumberFormatException e) { }
                }
                double avg = cnt>0 ? sum / cnt : 0;
                reports.add(String.format("Name: %s | Average: %.2f", name, avg));
            }
            // append to report file
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(out, true))) {
                for (String r : reports) {
                    bw.write(r);
                    bw.newLine();
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Input file students.txt not found");
        } catch (IOException e) {
            System.out.println("Error writing report file");
        }
    }
}
