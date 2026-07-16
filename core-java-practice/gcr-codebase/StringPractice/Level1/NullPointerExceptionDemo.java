package StringPractice.Level1.lab1;

public class NullPointerExceptionDemo {
    public static void main(String[] args) {
        try {
            generateException();
        } catch (NullPointerException exception) {
            handleException(exception);
        }
    }

    private static void generateException() {
        String text = null;
        int length = text.length();
        System.out.println("Length: " + length);
    }

    private static void handleException(NullPointerException exception) {
        System.out.println("NullPointerException caught: " + exception.getMessage());
    }
}
