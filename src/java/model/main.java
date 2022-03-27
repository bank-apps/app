package model;

import java.sql.SQLException;


public class main {
    public static void main(String[] args) throws SQLException {
        Bank bank = new Bank();
        
        UserData data = new UserData("'11111111K'", "123", "'Pepe'", "'Martínez Castillo'", "'pepemc@hotmail.com'", "'Mi casa'", "123456789");
                
        bank.register(data);
    }
}
