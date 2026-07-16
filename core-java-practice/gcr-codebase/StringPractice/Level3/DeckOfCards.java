package StringPractice.Level3.lab1;

import java.util.Scanner;

public class DeckOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of players: ");
        int players = scanner.nextInt();
        System.out.print("Enter cards per player: ");
        int cardsPerPlayer = scanner.nextInt();
        scanner.close();
        String[] deck = initializeDeck();
        shuffleDeck(deck);
        String[][] playersCards = distributeCards(deck, players, cardsPerPlayer);
        printPlayersCards(playersCards);
    }

    private static String[] initializeDeck() {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        String[] deck = new String[52];
        int index = 0;
        for (int i = 0; i < suits.length; i++) {
            for (int j = 0; j < ranks.length; j++) {
                deck[index++] = ranks[j] + " of " + suits[i];
            }
        }
        return deck;
    }

    private static void shuffleDeck(String[] deck) {
        int n = deck.length;
        for (int i = 0; i < n; i++) {
            int randomCardNumber = i + (int) (Math.random() * (n - i));
            String temp = deck[i];
            deck[i] = deck[randomCardNumber];
            deck[randomCardNumber] = temp;
        }
    }

    private static String[][] distributeCards(String[] deck, int players, int cardsPerPlayer) {
        int totalCards = players * cardsPerPlayer;
        String[][] result = new String[players][cardsPerPlayer];
        int index = 0;
        for (int i = 0; i < players; i++) {
            for (int j = 0; j < cardsPerPlayer; j++) {
                if (index < totalCards && index < deck.length) {
                    result[i][j] = deck[index++];
                } else {
                    result[i][j] = "No card";
                }
            }
        }
        return result;
    }

    private static void printPlayersCards(String[][] playersCards) {
        for (int i = 0; i < playersCards.length; i++) {
            System.out.println("Player " + (i + 1) + ":");
            for (int j = 0; j < playersCards[i].length; j++) {
                System.out.println(playersCards[i][j]);
            }
            System.out.println();
        }
    }
}
