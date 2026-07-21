package StringPractice.Level2.lab1;

import java.util.Scanner;

public class RockPaperScissorsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of games: ");
        int games = scanner.nextInt();
        scanner.nextLine();
        playGames(scanner, games);
        scanner.close();
    }

    private static void playGames(Scanner scanner, int games) {
        int playerWins = 0;
        int computerWins = 0;
        int draws = 0;
        System.out.println("Game Number | Player Choice | Computer Choice | Winner");
        for (int i = 1; i <= games; i++) {
            System.out.print("Enter choice for game " + i + " (rock/paper/scissors): ");
            String playerChoice = scanner.nextLine().trim().toLowerCase();
            String computerChoice = computerChoice();
            String winner = findWinner(playerChoice, computerChoice);
            if (winner.equals("Player")) {
                playerWins++;
            } else if (winner.equals("Computer")) {
                computerWins++;
            } else {
                draws++;
            }
            System.out.println(i + " | " + playerChoice + " | " + computerChoice + " | " + winner);
        }
        displayResults(games, playerWins, computerWins, draws);
    }

    private static String computerChoice() {
        int choice = (int) (Math.random() * 3);
        if (choice == 0) {
            return "rock";
        }
        if (choice == 1) {
            return "paper";
        }
        return "scissors";
    }

    private static String findWinner(String player, String computer) {
        if (player.equals(computer)) {
            return "Draw";
        }
        if ((player.equals("rock") && computer.equals("scissors")) ||
            (player.equals("paper") && computer.equals("rock")) ||
            (player.equals("scissors") && computer.equals("paper"))) {
            return "Player";
        }
        return "Computer";
    }

    private static void displayResults(int games, int playerWins, int computerWins, int draws) {
        System.out.println("Total Wins: Player=" + playerWins + ", Computer=" + computerWins + ", Draws=" + draws);
        double playerPercentage = games > 0 ? (playerWins * 100.0) / games : 0;
        System.out.println("Player Win Percentage: " + Math.round(playerPercentage) + "%");
    }
}
