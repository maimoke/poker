/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package therealpoker;

/**
 *
 * @author Moke
 */
public class Player {
    public int credit=0;
    public int bet=0;
    public int cardNow=0;
    Card[] cardOnHand =new Card[5];
    public boolean fold=false;
    public boolean check=false;
    
    Player(int credit,int bet){
    this.credit=credit;
    }
    
    public void draw(Card card){
        cardOnHand[cardNow]=card;
        cardNow++;
    }
    
    public Card getCard(int i){
        return cardOnHand[i];
    }
    
    public void clearCard(){
        
    }
    
    public void fold(){
        this.fold=true;
    }
    
    public void check(){
        this.check=true;
    }
    
    public void call(){
    }
    
    public int raise(int raise)
    {
        this.credit=this.credit-raise;
        this.bet=this.bet+raise;
        return raise;
    }
}
