package therealpoker;

class Card {
    private int volume;
    private int type;
    private String name;

    public Card(int volume, int type, String name) {
        this.volume = volume;
        this.type = type;
        this.name = name;
    }

    public Card() {
    }    

    public int getVolume() {
        return volume;
    }

    public int getType() {
        return type;
    }

    public String getName() {
        return name;
    }
       
   
    
    
}
