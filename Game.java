package Unogame;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Player> players;
    private Deck deck;
    private Player currentPlayer;
    private Card topDiscardCard;
    private String gameState;

    public Game() {
        this.deck = new Deck();
        this.players = new ArrayList<>();
        this.gameState = "NOT_STARTED";
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void startGame() {
        if (players.size() < 2) {
            System.out.println("Not enough players to start the game.");
            return;
        }

        deck.shuffle();

        // Deal initial cards to players
        for (Player player : players) {
            for (int i = 0; i < 7; i++) {
                player.drawCard(deck);
            }
        }

        topDiscardCard = deck.dealCard();
        System.out.println("Top card on the discard pile: " + topDiscardCard);

        currentPlayer = players.get(0);
        gameState = "ONGOING";
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public Card getTopDiscardCard() {
        return topDiscardCard;
    }

    public boolean processAction(String action, Card card) {
        System.out.println("Processing action: " + action);
        System.out.println("Card to play: " + card);
        System.out.println("Top discard card: " + topDiscardCard);

        if (action.equals("play") && card != null) {
            if (currentPlayer.getHand().contains(card) && card.matches(topDiscardCard)) {
                currentPlayer.playCard(card);
                topDiscardCard = card;
                System.out.println(currentPlayer.getName() + " played: " + card);
                return true;
            } else {
                System.out.println("Invalid move. You can't play this card.");
            }
        } else if (action.equals("draw")) {
            if (!deck.isEmpty()) {
                currentPlayer.drawCard(deck);
                return true;
            } else {
                System.out.println("Deck is empty, cannot draw a card.");
            }
        }
        return false;
    }

    public void nextPlayer() {
        int currentIndex = players.indexOf(currentPlayer);
        currentPlayer = players.get((currentIndex + 1) % players.size());
    }
}
