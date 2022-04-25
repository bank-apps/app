package model;

public class BankAccount {
    
    private final String IBAN;
    private Double balance;

    public BankAccount(String IBAN) {
        this.IBAN = IBAN;
        this.balance = 0.;
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
    
}
