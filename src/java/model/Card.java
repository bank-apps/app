package model;


public abstract class Card {
    private final int id;

    public Card(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
