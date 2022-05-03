package model;

public class main {
    public static void main(String[] args) throws Exception {
        Bank bank = new Bank();
       
        bank.issueCard(new BankAccount("ES7676491637977543832894"));
        
        bank.activateCard(new BankAccount("ES7676491637977543832894"));
        
        bank.login("'1111123411E'", "12333");
    }
}
