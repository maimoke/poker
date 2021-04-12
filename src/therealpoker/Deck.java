package therealpoker;
import java.util.ArrayList;
import java.util.Collections;
public class Deck {     
    private int cardAmount=0;
    ArrayList<Card> cardIndeck = new ArrayList<Card>();
    
    public Deck() {
         cardIndeck.add(new Card(2,4,"2Spade"));
         cardIndeck.add(new Card(3,4,"3Spade"));
         cardIndeck.add(new Card(4,4,"4Spade"));
         cardIndeck.add(new Card(5,4,"5Spade"));
         cardIndeck.add(new Card(6,4,"6Spade"));
         cardIndeck.add(new Card(7,4,"7Spade"));
         cardIndeck.add(new Card(8,4,"8Spade"));
         cardIndeck.add(new Card(9,4,"9Spade"));
         cardIndeck.add(new Card(10,4,"10Spade"));
         cardIndeck.add(new Card(11,4,"jackSpade"));
         cardIndeck.add(new Card(12,4,"queenSpade"));
         cardIndeck.add(new Card(13,4,"kingSpade"));
         cardIndeck.add(new Card(14,4,"aceSpade"));   
         
         cardIndeck.add(new Card(2,3,"2Heart"));
         cardIndeck.add(new Card(3,3,"3Heart"));
         cardIndeck.add(new Card(4,3,"4Heart"));
         cardIndeck.add(new Card(5,3,"5Heart"));
         cardIndeck.add(new Card(6,3,"6Heart"));
         cardIndeck.add(new Card(7,3,"7Heart"));
         cardIndeck.add(new Card(8,3,"8Heart"));
         cardIndeck.add(new Card(9,3,"9Heart"));
         cardIndeck.add(new Card(10,3,"10Heart"));
         cardIndeck.add(new Card(11,3,"jackHeart"));
         cardIndeck.add(new Card(12,3,"queenHeart"));
         cardIndeck.add(new Card(13,3,"kingHeart"));
         cardIndeck.add(new Card(14,3,"aceHeart")); 
         
         cardIndeck.add(new Card(2,2,"2Diamond"));
         cardIndeck.add(new Card(3,2,"3Diamond"));
         cardIndeck.add(new Card(4,2,"4Diamond"));
         cardIndeck.add(new Card(5,2,"5Diamond"));
         cardIndeck.add(new Card(6,2,"6Diamond"));
         cardIndeck.add(new Card(7,2,"7Diamond"));
         cardIndeck.add(new Card(8,2,"8Diamond"));
         cardIndeck.add(new Card(9,2,"9Diamond"));
         cardIndeck.add(new Card(10,2,"10Diamond"));
         cardIndeck.add(new Card(11,2,"jackDiamond"));
         cardIndeck.add(new Card(12,2,"queenDiamond"));
         cardIndeck.add(new Card(13,2,"kingDiamond"));
         cardIndeck.add(new Card(14,2,"aceDiamond")); 
         
         cardIndeck.add(new Card(2,1,"2Club"));
         cardIndeck.add(new Card(3,1,"3Club"));
         cardIndeck.add(new Card(4,1,"4Club"));
         cardIndeck.add(new Card(5,1,"5Club"));
         cardIndeck.add(new Card(6,1,"6Club"));
         cardIndeck.add(new Card(7,1,"7Club"));
         cardIndeck.add(new Card(8,1,"8Club"));
         cardIndeck.add(new Card(9,1,"9Club"));
         cardIndeck.add(new Card(10,1,"10Club"));
         cardIndeck.add(new Card(11,1,"jackClub"));
         cardIndeck.add(new Card(12,1,"queenClub"));
         cardIndeck.add(new Card(13,1,"kingClub"));
         cardIndeck.add(new Card(14,1,"aceClub")); 
         Collections.shuffle(cardIndeck);
    }
    
    
    Card draw(){       
        Card c = cardIndeck.get(cardAmount);
        cardIndeck.remove(cardAmount);
        cardAmount++;
        return c;
    }
    
    void shuffle(){
         Collections.shuffle(cardIndeck);         
    }
    void discard(){
        cardIndeck.remove(cardAmount);
        cardAmount++;
    }
//    public static void main(String[] args) {
//        Deck d= new Deck();
//        for(int i =0;i<d.cardIndeck.size();i++)
//        System.out.println(d.cardIndeck.get(i).getName());
//    }
}
