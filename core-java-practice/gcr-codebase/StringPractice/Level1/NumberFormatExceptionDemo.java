package StringPractice.Level1.lab1;

public class NumberFormatExceptionDemo {
    public static void main(String[] args) {
        try {
            generateException();
        } catch (NumberFormatException exception) {
            handleException(exception);
        }
    }

    private static void generateException() {
        String value = "12A34";
        int result = Integer.parseInt(value);
        System.out.println("Parsed number: " + result);
    }

    private static void handleException(NumberFormatException exception) {
        System.out.println("NumberFormatException caught: " + exception.getMessage());
    }
}
