package model;

import java.sql.SQLException;
import org.json.simple.JSONArray;


public class main {
    public static void main(String[] args) throws Exception {
        Bank bank = new Bank();
        
        UserData data = new UserData("'111113411E'", "12333", "'Pepe4'", "'4Martínez Castillo'", "'pepe4mc@hotma3il.com'", "'4i casa'", "12344567489130");
                
        System.out.println("Testing Register:");
        System.out.println(bank.register(data));
        
        System.out.println("Testing Login:");
        System.out.println(bank.login("'111113411E'", "12333"));
        
        // TEST TO GET TRANSACTIONS AS JSONARRAY
        System.out.println("Testing Transactions:");
        JSONArray JSONtransactions = 
                bank.getTransactions("ES6776491637244626513871");
        System.out.println(JSONtransactions.toJSONString());
    }
}
