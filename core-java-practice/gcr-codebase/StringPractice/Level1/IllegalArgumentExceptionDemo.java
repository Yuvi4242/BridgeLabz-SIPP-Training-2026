package StringPractice.Level1.lab1;

public class IllegalArgumentExceptionDemo {
    public static void main(String[] args) {
        try {
            generateException();
        } catch (IllegalArgumentException exception) {
            handleException(exception);
        }
    }

    private static void generateException() {
        String text = "JavaPractice";
        String result = text.substring(5, 3);
        System.out.println("Result: " + result);
    }

    private static void handleException(IllegalArgumentException exception) {
        System.out.println("IllegalArgumentException caught: " + exception.getMessage());
    }
}
