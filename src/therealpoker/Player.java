/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package therealpoker;

import java.util.ArrayList;

/**
 *
 * @author Moke
 */
public class Player {
    public int credit=0;
    ArrayList<Card> cardOnHand =new ArrayList<Card>();
    public boolean fold=false;
    public boolean check=false;
    
    Player(int credit){
    this.credit=credit;
    }
    
    public void draw(Card card){
        cardOnHand.add(card);
    }
    
    public Card getCard(int i){
        return cardOnHand.get(i);
    }
    
    public void clearCard(){
        cardOnHand.clear();
    }
    
    public void fold(){
        this.fold=true;
    }
    
    public void check(){
        this.check=true;
    }
    
    public int call(int raise){
        this.credit=this.credit-raise;
        return raise;
    }
    
    public int raise(int raise)
    {
        this.credit=this.credit-raise;
        return raise;
    }
}
