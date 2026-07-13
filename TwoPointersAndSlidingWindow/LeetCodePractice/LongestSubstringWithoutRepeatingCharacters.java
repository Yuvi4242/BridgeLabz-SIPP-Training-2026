import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> lastIndex = new HashMap<>();
        int start = 0;
        int maxLen = 0;

        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            if (lastIndex.containsKey(c)) {
                start = Math.max(start, lastIndex.get(c) + 1);
            }
            lastIndex.put(c, end);
            maxLen = Math.max(maxLen, end - start + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters obj = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(obj.lengthOfLongestSubstring("abcabcbb"));
    }
}
