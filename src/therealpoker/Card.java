package therealpoker;

public class Card{
    public int volume;
    public int suit;
    public String name;

    public Card() {
    }

    public Card(int volume, int suit) {
        this.volume = volume;
        this.suit = suit;
    } 
    
    public Card(int volume, int suit, String name) {
        this.volume = volume;
        this.suit = suit;
        this.name = name;
    }

}