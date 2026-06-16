import java.util.Scanner;

public class TowerOfHanoiCountMoves {

    public static int solveHanoi(int n, char source, char auxiliary, char target) {
        if (n == 0) {
            return 0;
        }
        int count = 0;
        count += solveHanoi(n - 1, source, target, auxiliary);
        System.out.println("Move disk " + n + " from " + source + " to " + target);
        count++;
        count += solveHanoi(n - 1, auxiliary, source, target);
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int totalMoves = solveHanoi(n, 'A', 'B', 'C');
        System.out.println(totalMoves);
        scanner.close();
    }
}
