/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package therealpoker;

/**
 *
 * @author acer
 */
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
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    
    
}
