package model;

import java.util.ArrayList;

public class UserAccount {
    private UserData userData;
    private ArrayList<BankAccount> bankAccounts;

    public UserAccount(UserData userData) {
        this.userData = userData;
    }

    public UserData getData() {
        return userData;
    }

    public void setData(UserData userData) {
        this.userData = userData;
    }
    
    public void addBankAccount(BankAccount bankAccount) {
        bankAccounts.add(bankAccount);
    }
    
    public void removeBankAccount(BankAccount bankAccount) {
        bankAccounts.remove(bankAccount);
    }
    
}
