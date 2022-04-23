package model;

public class Main {
    
    public static void main(String[] args) {
        Bank bank = new Bank();
        /*
        UserData userData = new UserData("'87654321V'", "1234", "'Fernando'", "'López Fernández'", "'fernando@gmail.com'", "'Mi casa'", "678349124");        
        System.out.println(bank.register(userData));
        */
        BankAccount from = new BankAccount("ES6776491637244626513871");
        from.setBalance(50.);
        BankAccount to = new BankAccount("ES9176491637335373685119");
        System.out.println(bank.transfer(from, to, 15.));
    }
}
