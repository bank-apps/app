package model;

import java.sql.SQLException;


public class main {
    public static void main(String[] args) throws Exception {
        Bank bank = new Bank();
        
        UserData data = new UserData("'311113411E'", "12333", "'Pepe4'", "'4Martínez Castillo'", "'pepe5mc@hotma3il.com'", "'4i casa'", "12344567489131");
        
        System.out.println("Testing Register:");
        System.out.println(bank.register(data));
        
        System.out.println("Testing Login:");
        System.out.println(bank.login("'311113411E'", "12333"));
    }
}
