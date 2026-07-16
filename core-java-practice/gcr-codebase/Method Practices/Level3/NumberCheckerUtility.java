package level3;

/**
 * NumberCheckerUtility - Reusable methods for number classification
 */
public class NumberCheckerUtility {
    
    /**
     * Counts total digits in a number
     * @param n Number to analyze
     * @return Total number of digits
     */
    public static int countDigits(long n) {
        if (n == 0) return 1;
        int count = 0;
        n = Math.abs(n);
        while (n > 0) {
            count++;
            n /= 10;
        }
        return count;
    }
    
    /**
     * Gets array of digits
     * @param n Number to extract digits from
     * @return Array of digits
     */
    public static int[] getDigitsArray(long n) {
        n = Math.abs(n);
        if (n == 0) return new int[]{0};
        
        int digits = countDigits(n);
        int[] arr = new int[digits];
        for (int i = digits - 1; i >= 0; i--) {
            arr[i] = (int)(n % 10);
            n /= 10;
        }
        return arr;
    }
    
    /**
     * Checks if a number is Armstrong number (narcissistic number)
     * @param n Number to check
     * @return true if Armstrong number
     */
    public static boolean isArmstrong(long n) {
        int[] digits = getDigitsArray(n);
        int power = digits.length;
        long sum = 0;
        for (int digit : digits) {
            sum += Math.pow(digit, power);
        }
        return sum == n;
    }
    
    /**
     * Checks if a number is Harshad number (divisible by sum of digits)
     * @param n Number to check
     * @return true if Harshad number
     */
    public static boolean isHarshad(long n) {
        int[] digits = getDigitsArray(n);
        int sum = 0;
        for (int digit : digits) {
            sum += digit;
        }
        return sum > 0 && n % sum == 0;
    }
    
    /**
     * Checks if a number is palindrome
     * @param n Number to check
     * @return true if palindrome
     */
    public static boolean isPalindrome(long n) {
        long original = Math.abs(n);
        long reversed = 0;
        long temp = original;
        while (temp > 0) {
            reversed = reversed * 10 + temp % 10;
            temp /= 10;
        }
        return original == reversed;
    }
    
    /**
     * Checks if a number is prime
     * @param n Number to check
     * @return true if prime
     */
    public static boolean isPrime(long n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (long i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }
    
    /**
     * Checks if a number is Neon number (sum of digits squared equals number)
     * @param n Number to check
     * @return true if Neon number
     */
    public static boolean isNeon(long n) {
        int[] digits = getDigitsArray(n);
        long sum = 0;
        for (int digit : digits) {
            sum += digit;
        }
        return sum * sum == n;
    }
    
    /**
     * Checks if a number is Spy number (sum of digits equals product of digits)
     * @param n Number to check
     * @return true if Spy number
     */
    public static boolean isSpy(long n) {
        int[] digits = getDigitsArray(n);
        int sum = 0;
        long product = 1;
        for (int digit : digits) {
            sum += digit;
            product *= digit;
        }
        return sum == product;
    }
    
    /**
     * Checks if a number is Automorphic (last digits of square equal the number)
     * @param n Number to check
     * @return true if Automorphic
     */
    public static boolean isAutomorphic(long n) {
        long square = n * n;
        long temp = n;
        long divisor = 1;
        while (temp > 0) {
            divisor *= 10;
            temp /= 10;
        }
        return square % divisor == n;
    }
    
    /**
     * Checks if a number is Buzz number (ends with 7 or divisible by 7)
     * @param n Number to check
     * @return true if Buzz number
     */
    public static boolean isBuzz(long n) {
        return n % 10 == 7 || n % 7 == 0;
    }
    
    /**
     * Checks if a number is Perfect number (sum of divisors equals number)
     * @param n Number to check
     * @return true if Perfect number
     */
    public static boolean isPerfect(long n) {
        if (n <= 1) return false;
        long sum = 0;
        for (long i = 1; i < n; i++) {
            if (n % i == 0) sum += i;
        }
        return sum == n;
    }
    
    /**
     * Checks if a number is Abundant number (sum of divisors > number)
     * @param n Number to check
     * @return true if Abundant number
     */
    public static boolean isAbundant(long n) {
        if (n <= 1) return false;
        long sum = 0;
        for (long i = 1; i < n; i++) {
            if (n % i == 0) sum += i;
        }
        return sum > n;
    }
    
    /**
     * Checks if a number is Deficient number (sum of divisors < number)
     * @param n Number to check
     * @return true if Deficient number
     */
    public static boolean isDeficient(long n) {
        if (n <= 1) return false;
        long sum = 0;
        for (long i = 1; i < n; i++) {
            if (n % i == 0) sum += i;
        }
        return sum < n;
    }
}
