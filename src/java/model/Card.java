package model;


public abstract class Card {
    private final String id;

    public Card(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
