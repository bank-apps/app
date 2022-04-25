package model;

public class Main {
    
    public static void main(String[] args) {
        Bank bank = new Bank();
        // UserData userData = new UserData("'87654321V'", "1234", "'Fernando'", "'López Fernández'", "'fernando@gmail.com'", "'Mi casa'", "678349123");     
        // System.out.println(bank.register(userData));
        
        BankAccount from = new BankAccount("ES83764916374817124 1702");
        BankAccount to = new BankAccount("ES477649163779 581120922");
        from.setBalance(50.);
        System.out.println(bank.transfer(from, to, 20.));
        System.out.println(bank.transfer(from, to, 10.));
    }
}
