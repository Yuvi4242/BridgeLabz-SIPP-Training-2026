public class MathWizard {
    public int value = 50;
    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
    }
    public static long factorial(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) result *= i;
        return result;
    }
    public static double factorial(double n) {
        return (double)factorial((int)n);
    }
    public static long fibonacci(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        long a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            long t = a + b;
            a = b;
            b = t;
        }
        return b;
    }
    public static long gcd(long a, long b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
    public static long lcm(long a, long b) {
        if (a == 0 || b == 0) return 0;
        return Math.abs((a / gcd(a, b)) * b);
    }
    public static double power(double base, int exp) {
        if (exp == 0) return 1.0;
        long e = Math.abs((long)exp);
        double result = 1.0;
        double b = base;
        while (e > 0) {
            if ((e & 1) == 1) result *= b;
            b *= b;
            e >>= 1;
        }
        return exp < 0 ? 1.0 / result : result;
    }
}

class MathWizardDemo {
    public static void main(String[] args) {
        MathWizard mw = new MathWizard();
        System.out.println(MathWizard.isPrime(29));
        System.out.println(MathWizard.factorial(5));
        System.out.println(MathWizard.factorial(6.0));
        System.out.println(MathWizard.fibonacci(10));
        System.out.println(MathWizard.gcd(54, 24));
        System.out.println(MathWizard.lcm(12, 18));
        System.out.println(MathWizard.power(2, 10));
        int value = 5;
        System.out.println(value);
        System.out.println(mw.value);
    }
}
