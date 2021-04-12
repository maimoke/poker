package therealpoker;
import java.util.Random;
public class Deck {
    Card[] cardIndeck = new Card[52];    
    int cardAmount=0;

    public Deck() {
    }
    
    
    Card draw(){       
        Card[] temp = cardIndeck;        
        cardIndeck = new Card[cardIndeck.length-1];
        for (int i = 0; i < cardIndeck.length; i++) {
            cardIndeck[i] = temp[i+1];
        }
        return temp[cardAmount++]; //first out
    }
    
    void shuffle(){
         Random rand = new Random();                   
         for (int i = 0; i < cardIndeck.length; i++) {
         int r = i + rand.nextInt(cardIndeck.length - i);
         Card temp = cardIndeck[r];
             cardIndeck[r] = cardIndeck[i];
             cardIndeck[i] = temp;
        }
         
    }
    void discard(){
        Card[] temp = cardIndeck;        
        cardIndeck = new Card[cardIndeck.length-1];
        for (int i = 0; i < cardIndeck.length; i++) {
            cardIndeck[i] = temp[i+1];
        }
    }
}
