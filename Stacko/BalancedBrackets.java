import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

public class BalancedBrackets {
    private static final Map<Character, Character> MATCH_FOR = Map.of(
            ')', '(',
            ']', '[',
            '}', '{'
    );

    public static boolean isValidConfig(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty() || stack.pop() != MATCH_FOR.get(c)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
