package model;

import java.sql.SQLException;


public class main {
    public static void main(String[] args) throws SQLException {
        Bank bank = new Bank();
        
        UserData data = new UserData("'11111112K'", "1233", "'4Pepe'", "'4Martínez Castillo'", "'4pepemc@hotmail.com'", "'Mi casa'", "1234567894");
                
        bank.register(data);
    }
}
