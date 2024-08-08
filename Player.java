package Unogame;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<Card> hand;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Card> getHand() {
        return hand;
    }

    public void drawCard(Deck deck) {
        Card drawnCard = deck.dealCard();
        if (drawnCard != null) {
            hand.add(drawnCard);
            System.out.println(name + " drew a card.");
        } else {
            System.out.println("No more cards to draw.");
        }
    }

    public boolean playCard(Card card) {
        if (hand.contains(card)) {
            hand.remove(card);
            return true;
        }
        return false;
    }
}
