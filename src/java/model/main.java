package model;

import java.sql.SQLException;
import org.json.simple.JSONArray;


public class main {
    public static void main(String[] args) throws Exception {
        Bank bank = new Bank();
        
        UserData data = new UserData("'1111123411E'", "12333", "'Pepe34'", "'4Mart3ínez Castillo'", "'pe3pe4mc@hotma3il.com'", "'4i casa'", "12344567489130");
                
        System.out.println("Testing Register:");
        System.out.println(bank.register(data));
        
        System.out.println("Testing Login:");
        System.out.println(bank.login("'111113411E'", "12333"));
        
        // TEST TO GET TRANSACTIONS AS JSONARRAY
        System.out.println("Testing Transactions:");
        JSONArray JSONtransactions = 
                bank.getTransactions("ES6776491637244626513871");
        System.out.println("Result of getting transactions:");
        System.out.println(JSONtransactions.toJSONString());
    }
}
