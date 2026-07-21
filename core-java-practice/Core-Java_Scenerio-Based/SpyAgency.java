import java.util.Scanner;

public class SpyAgency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String secret = sc.nextLine();
        String intercept1 = sc.nextLine();
        String intercept2 = sc.nextLine();
        String log = sc.nextLine();
        String reversed = new StringBuilder(secret).reverse().toString();
        System.out.println(reversed);
        System.out.println(isPalindrome(secret) ? "Palindrome" : "Not Palindrome");
        int vowels = 0;
        int consonants = 0;
        for (char ch : secret.toLowerCase().toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                if ("aeiou".indexOf(ch) >= 0) {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }
        System.out.println(vowels);
        System.out.println(consonants);
        System.out.println(areAnagrams(intercept1, intercept2) ? "Anagram" : "Not Anagram");
        System.out.println(firstNonRepeating(log));
        sc.close();
    }

    private static boolean isPalindrome(String s) {
        String cleaned = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        return cleaned.equals(new StringBuilder(cleaned).reverse().toString());
    }

    private static boolean areAnagrams(String a, String b) {
        String s1 = a.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        String s2 = b.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        if (s1.length() != s2.length()) {
            return false;
        }
        int[] counts = new int[256];
        for (char c : s1.toCharArray()) {
            counts[c]++;
        }
        for (char c : s2.toCharArray()) {
            counts[c]--;
        }
        for (int count : counts) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

    private static char firstNonRepeating(String s) {
        int[] counts = new int[256];
        for (char c : s.toCharArray()) {
            counts[c]++;
        }
        for (char c : s.toCharArray()) {
            if (counts[c] == 1) {
                return c;
            }
        }
        return 0;
    }
}
