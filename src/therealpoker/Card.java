package therealpoker;

public class Card {

    private int volume;
    private int suit;
    private String name;

    public Card(int volume, int suit, String name) {
        this.volume = volume;
        this.suit = suit;
        this.name = name;
    }

    public Card() {
    }

    public Card(int volume, int suit) {
        this.volume = volume;
        this.suit = suit;
    }

    public int getVolume() {
        return volume;
    }

    public int getSuit() {
        return suit;
    }

    public String getName() {
        return name;
    }
}
