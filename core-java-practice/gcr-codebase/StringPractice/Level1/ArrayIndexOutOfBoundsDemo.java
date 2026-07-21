package StringPractice.Level1.lab1;

public class ArrayIndexOutOfBoundsDemo {
    public static void main(String[] args) {
        try {
            generateException();
        } catch (ArrayIndexOutOfBoundsException exception) {
            handleException(exception);
        }
    }

    private static void generateException() {
        int[] numbers = {1, 2, 3};
        int value = numbers[5];
        System.out.println("Value: " + value);
    }

    private static void handleException(ArrayIndexOutOfBoundsException exception) {
        System.out.println("ArrayIndexOutOfBoundsException caught: " + exception.getMessage());
    }
}
