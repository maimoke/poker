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

    public int credit = 0;
    ArrayList<Card> cardOnHand = new ArrayList<Card>();
    public boolean fold = false;
    public boolean allIn=false;
    public boolean check=false;

    public boolean isCheck() {
        return check;
    }

    public int betThisRound=0;

    public int getBetThisRound() {
        return betThisRound;
    }

    public boolean isFold() {
        return fold;
    }

    public void turnEndResetBet() {
        this.betThisRound = 0;
    }

    Player(int credit) {
        this.credit = credit;
        this.betThisRound=0;
    }
    Player(){
    }
    public void reset()
    {
        this.fold=false;
        this.check=false;
        cardOnHand.clear();
    }

    public int getCredit() {
        return credit;
    }
    
    public void reward(int reward){
        this.credit+=reward;
    }
    
    public void draw(Card card) {
        cardOnHand.add(card);
    }

    public Card getCard(int i) {
        return cardOnHand.get(i);
    }

    public void clearCard() {
        cardOnHand.clear();
    }

    public void fold() {
        this.fold = true;
    }

    public int call(int raise) {
        this.credit = this.credit - raise;
        this.betThisRound=this.betThisRound+raise;
        this.check=true;
        return raise;
    }

    public int raise(int raise) {
        this.credit = this.credit - raise;
        this.betThisRound=this.betThisRound+raise;
        this.check=true;
        return raise;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }
}
