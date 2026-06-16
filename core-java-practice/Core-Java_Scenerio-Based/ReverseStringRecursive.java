import java.util.Scanner;

public class ReverseStringRecursive {

    public static String reverse(String s, int index) {
        if (index == s.length()) {
            return "";
        }
        return reverse(s, index + 1) + s.charAt(index);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String output = reverse(input, 0);
        System.out.println(output);
        scanner.close();
    }
}
