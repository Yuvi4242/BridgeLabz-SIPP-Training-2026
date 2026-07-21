import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CustomerFeedbackAnalyzer {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;
        System.out.println("Enter 5 feedback messages:");
        for (int i = 0; i < 5; i++) {
            String line = br.readLine();
            if (line == null) break;
            if (line.toLowerCase().contains("good")) count++;
        }
        System.out.println("Good Feedback Count = " + count);
    }
}
