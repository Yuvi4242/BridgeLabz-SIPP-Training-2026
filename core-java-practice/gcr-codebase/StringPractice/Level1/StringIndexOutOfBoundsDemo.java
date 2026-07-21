package StringPractice.Level1.lab1;

public class StringIndexOutOfBoundsDemo {
    public static void main(String[] args) {
        try {
            generateException();
        } catch (StringIndexOutOfBoundsException exception) {
            handleException(exception);
        }
    }

    private static void generateException() {
        String text = "BridgeLabz";
        char ch = text.charAt(text.length());
        System.out.println("Character: " + ch);
    }

    private static void handleException(StringIndexOutOfBoundsException exception) {
        System.out.println("StringIndexOutOfBoundsException caught: " + exception.getMessage());
    }
}
