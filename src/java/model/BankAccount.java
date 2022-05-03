package model;


public class BankAccount {
    
    private final String IBAN;
    private Double balance;
    private Card card;
    public static double maintenence = 1.f;

    public BankAccount(String IBAN) {
        this.IBAN = IBAN;
        this.balance = 0.;
        this.card = null;
    }

    public String getIBAN() {
        return IBAN;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }    
    
     public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }   
    
    public double getMaintenance(){
        if(this.card.getId() != null){
            return 1.5f;
        }else{
            return 1f;
        }
    }
}
