package level3;

import java.util.Random;
import java.util.Scanner;

/**
 * OTPGenerator - Generate One Time Password
 */
public class OTPGenerator {
    
    /**
     * Generates a random OTP of specified length
     * @param length Length of OTP
     * @return Generated OTP as string
     */
    public static String generateOTP(int length) {
        Random random = new Random();
        StringBuilder otp = new StringBuilder();
        for (int i = 0; i < length; i++) {
            otp.append(random.nextInt(10));
        }
        return otp.toString();
    }
    
    /**
     * Generates OTP with alphanumeric characters
     * @param length Length of OTP
     * @return Generated alphanumeric OTP
     */
    public static String generateAlphanumericOTP(int length) {
        String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        StringBuilder otp = new StringBuilder();
        for (int i = 0; i < length; i++) {
            otp.append(chars.charAt(random.nextInt(chars.length())));
        }
        return otp.toString();
    }
    
    /**
     * Validates OTP
     * @param otp OTP to validate
     * @param length Expected length
     * @return true if valid
     */
    public static boolean validateOTP(String otp, int length) {
        return otp != null && otp.length() == length && otp.matches("\\d+");
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter OTP length: ");
        int length = sc.nextInt();
        
        String numericOTP = generateOTP(length);
        String alphanumericOTP = generateAlphanumericOTP(length);
        boolean isValid = validateOTP(numericOTP, length);
        
        System.out.println("\n--- OTP Generator ---");
        System.out.println("Numeric OTP: " + numericOTP);
        System.out.println("Alphanumeric OTP: " + alphanumericOTP);
        System.out.println("Is Numeric OTP Valid: " + isValid);
        
        sc.close();
    }
}
