package model;

public class CreditCard extends Card {
        
    private double maintenance = 0.5f;
    
    public CreditCard(String cardNumber) {
        super(cardNumber);
        super.maintenance = this.maintenance;
    }    
}
