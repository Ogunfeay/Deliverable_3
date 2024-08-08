package Unogame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Deck {
    private List<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        String[] colors = {"Red", "Yellow", "Green", "Blue"};
        String[] values = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "Skip", "Reverse", "Draw Two"};

        // Add cards to the deck
        for (String color : colors) {
            for (String value : values) {
                cards.add(new Card(color, value));
                if (!value.equals("0")) {
                    // Add duplicates for non-zero cards
                    cards.add(new Card(color, value));
                }
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards, new Random(System.currentTimeMillis()));
    }

    public Card dealCard() {
        if (!cards.isEmpty()) {
            return cards.remove(0);
        }
        return null;
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }
}
