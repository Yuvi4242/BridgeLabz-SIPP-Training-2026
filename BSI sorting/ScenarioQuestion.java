import java.util.Scanner;

public class ScenarioQuestion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of athletes: ");
        int n = scanner.nextInt();

        int[] scores = new int[n];
        System.out.println("Enter the scores:");
        for (int i = 0; i < n; i++) {
            scores[i] = scanner.nextInt();
        }

        int[] bubbleScores = copyArray(scores);
        int swapCount = bubbleSortWithCount(bubbleScores);
        System.out.println("\nBubble Sorted Athlete Scores:");
        printArray(bubbleScores);
        System.out.println("Total swaps: " + swapCount);

        boolean isBestCase = isAlreadySorted(scores);
        if (isBestCase) {
            System.out.println("Best case detected: the array was already sorted.");
        } else {
            System.out.println("Best case not detected: the array needed sorting.");
        }

        int[] insertionScores = copyArray(scores);
        insertionSort(insertionScores);
        System.out.println("\nInsertion Sorted Athlete Scores:");
        printArray(insertionScores);

        int[] medalists = copyArray(scores);
        sortDescending(medalists);
        System.out.println("\nTop 3 Medalists (highest scores):");
        for (int i = 0; i < Math.min(3, medalists.length); i++) {
            System.out.println((i + 1) + ". " + medalists[i]);
        }

        System.out.println("\nPass-by-pass Bubble Sort for [64, 25, 12, 22, 11]");
        int[] fixedArray = {64, 25, 12, 22, 11};
        showBubbleSortPasses(fixedArray);

        scanner.close();
    }

    public static int bubbleSortWithCount(int[] arr) {
        int swaps = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    swaps++;
                }
            }
        }
        return swaps;
    }

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void sortDescending(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[maxIndex]) {
                    maxIndex = j;
                }
            }
            swap(arr, i, maxIndex);
        }
    }

    public static boolean isAlreadySorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static void showBubbleSortPasses(int[] arr) {
        int pass = 1;
        int[] temp = copyArray(arr);
        while (pass <= temp.length) {
            for (int i = 0; i < temp.length - pass; i++) {
                if (temp[i] > temp[i + 1]) {
                    swap(temp, i, i + 1);
                }
            }
            System.out.print("Pass " + pass + ": ");
            printArray(temp);
            pass++;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int[] copyArray(int[] arr) {
        int[] copy = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            copy[i] = arr[i];
        }
        return copy;
    }

    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}

// Time Complexity: O(n^2) for Bubble Sort and Insertion Sort, O(n) extra space for copied arrays.
// Space Complexity: O(n) for the copied arrays and temporary variables.
