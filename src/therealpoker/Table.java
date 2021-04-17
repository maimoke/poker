package therealpoker;

import java.util.ArrayList;

public class Table {

    //Datafield
    private int pot = 0;
    ArrayList<Card> card = new ArrayList<Card>();

    //Constructor
    public Table() {

    }

    public Table(int pot) {
        this.pot = pot;

    }

    
    public int getPot() {
        return pot;
    }
    public void reset(){
        this.pot=0;
        card.clear();
    }

    //Methods
    public void draw(Card cardList) {//Draw card from deck to table
        card.add(cardList);
    }

    public Card getCard(int cardList) {//Check card type
        return card.get(cardList);
    }

    public void clearCard() {//Clear card on table 
        card.clear();
    }

    public int bet(int bet) {//Get bet from Player.class
        pot+=bet;
        return bet;
    }

}
