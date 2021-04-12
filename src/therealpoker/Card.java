package therealpoker;

public class Card{

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

//    @Override
//    public int compareTo(Card o) {
//        if (this.getVolume()>o.getVolume())
//        return 1;
//        else if (this.getVolume()==o.getVolume())
//        {
//         if (this.getSuit()>o.getSuit())
//             return 1;
//         else if (this.getSuit()<o.getSuit())
//             return -1;
//         else return 0;
//        }
//        else
//        return -1;
//    }
}
