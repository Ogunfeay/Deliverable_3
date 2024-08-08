package Unogame;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        game.addPlayer(new Player("Player 1"));
        game.addPlayer(new Player("Player 2"));
        game.startGame();

        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            Player currentPlayer = game.getCurrentPlayer();
            System.out.println("\nCurrent player: " + currentPlayer.getName());
            System.out.println("Your hand: " + currentPlayer.getHand());
            System.out.println("Top card on the discard pile: " + game.getTopDiscardCard());
            System.out.print("Enter action (play/draw/exit): ");
            String action = scanner.nextLine().trim().toLowerCase();

            if (action.equals("play")) {
                System.out.print("Enter card color and value (e.g., Red 5): ");
                String[] cardDetails = scanner.nextLine().trim().split(" ");
                
                if (cardDetails.length == 2) {
                    String color = cardDetails[0];
                    String value = cardDetails[1];
                    Card card = new Card(color, value);
                    
                    if (game.processAction(action, card)) {
                        if (currentPlayer.getHand().isEmpty()) {
                            System.out.println(currentPlayer.getName() + " has won the game!");
                            break;
                        }
                        game.nextPlayer();
                    } else {
                        System.out.println("Invalid move. You can't play this card.");
                    }
                } else {
                    System.out.println("Invalid card details.");
                }
            } else if (action.equals("draw")) {
                if (game.processAction(action, null)) {
                    game.nextPlayer();
                }
            } else if (action.equals("exit")) {
                System.out.println("Exiting game.");
                break;
            } else {
                System.out.println("Invalid action.");
            }
        }

        scanner.close();
    }
}
