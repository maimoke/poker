package therealpoker;

public class Table {
    //Datafield
    private int pot = 0;
    private int turn = 0;
    private int[] card = new int[52];
    
    //Constructor
    public Table() {
        
    }
    public Table(int pot){
        this.pot = pot;
        
    }
    
    //Methods
    public void draw(int card) {
        
    }
    
    public void getCard() {
        
    }
    
    public void clearCard(){
        
    }
    
    public void bet(int money){
        pot += money;
    }
    
}
