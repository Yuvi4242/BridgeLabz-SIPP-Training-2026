package StringPractice.Level2.lab1;

import java.util.Random;
import java.util.Scanner;

public class VotingEligibilityChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int count = scanner.nextInt();
        scanner.close();
        int[] ages = generateAges(count);
        System.out.println("Age | Can Vote");
        for (int age : ages) {
            System.out.println(age + " | " + canVote(age));
        }
    }

    private static int[] generateAges(int count) {
        Random random = new Random();
        int[] ages = new int[count];
        for (int i = 0; i < count; i++) {
            ages[i] = 16 + random.nextInt(11);
        }
        return ages;
    }

    private static boolean canVote(int age) {
        return age >= 18;
    }
}
