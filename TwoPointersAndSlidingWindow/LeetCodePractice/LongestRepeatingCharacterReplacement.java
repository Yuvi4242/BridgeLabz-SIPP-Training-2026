public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int start = 0;
        int maxFreq = 0;
        int maxLen = 0;

        for (int end = 0; end < s.length(); end++) {
            int idx = s.charAt(end) - 'A';
            freq[idx]++;
            maxFreq = Math.max(maxFreq, freq[idx]);

            while ((end - start + 1) - maxFreq > k) {
                freq[s.charAt(start) - 'A']--;
                start++;
            }
            maxLen = Math.max(maxLen, end - start + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        LongestRepeatingCharacterReplacement obj = new LongestRepeatingCharacterReplacement();
        System.out.println(obj.characterReplacement("AABABBA", 1));
    }
}
