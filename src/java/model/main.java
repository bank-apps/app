package model;

import java.sql.SQLException;


public class main {
    public static void main(String[] args) throws Exception {
        Bank bank = new Bank();
        
        UserData data = new UserData("'1111123411E'", "12333", "'Pepe34'", "'4Mart3ínez Castillo'", "'pe3pe4mc@hotma3il.com'", "'4i casa'", "12344567489130");
                
        System.out.println(bank.register(data));
    }
}
