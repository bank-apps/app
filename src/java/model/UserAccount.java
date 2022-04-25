package model;

import java.util.ArrayList;

public class UserAccount {
    
    private UserData userData;
    private ArrayList<BankAccount> bankAccounts;

    public UserAccount(UserData userData) {
        this.userData = userData;
        /*
        int id = (int) DataBaseManager.SelectUserId(userData.getDNI());
        System.out.println(id);
        String IBAN = (String) DataBaseManager.Select("bank accounts", "iban", "'owner id'=" + id);
        addBankAccount(new BankAccount(IBAN));
        */
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
    
    public BankAccount getBankAccount(String IBAN) {
        for (BankAccount bankAccount : bankAccounts) {
            if (bankAccount.getIBAN().equals(IBAN)) {
                return bankAccount;
            }
        }
        return null;
    }
    
    public BankAccount getBankAccount(int index) {
        return bankAccounts.get(index) != null ? bankAccounts.get(index) : null;
    }
    
}
