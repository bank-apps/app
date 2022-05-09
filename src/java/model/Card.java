package model;


public abstract class Card {
    private final String id;
    protected static double maintenance;
    
    public Card(String id) {
        this.id = id;
    }

    public static double getMaintenance() {
        return maintenance;
    }

    public String getId() {
        return id;
    }
}
