import java.util.Scanner;

public class BalancedParenthesesRecursive {

    public static boolean isBalanced(String s, int index, int count) {
        if (count < 0) {
            return false;
        }
        if (index == s.length()) {
            return count == 0;
        }
        char ch = s.charAt(index);
        if (ch == '(') {
            return isBalanced(s, index + 1, count + 1);
        }
        if (ch == ')') {
            return isBalanced(s, index + 1, count - 1);
        }
        return isBalanced(s, index + 1, count);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        boolean result = isBalanced(input, 0, 0);
        System.out.println(result);
        scanner.close();
    }
}
