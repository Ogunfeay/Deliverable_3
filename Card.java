package Unogame;

public class Card {
    private String color;
    private String value;

    public Card(String color, String value) {
        this.color = color;
        this.value = value;
    }

    public String getColor() {
        return color;
    }

    public String getValue() {
        return value;
    }

    public boolean matches(Card otherCard) {
        return this.color.equalsIgnoreCase(otherCard.getColor()) || this.value.equals(otherCard.getValue());
    }

    @Override
    public String toString() {
        return color + " " + value;
    }
}
