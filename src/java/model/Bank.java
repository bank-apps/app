package model;

import java.sql.SQLException;
import java.util.Random;



public class Bank {

    public Bank() {
        DataBaseManager.connect();
    }

    private String GenerateIBAN(){
        Random random = new Random();
        String country_code = "ES";
        String control_code = String.format("%02d", random.nextInt(99));
        String bank_code = "7649";
        String bank_branch_code = "1637";
        String control_code_user = String.format("%02d", random.nextInt(99));
        String bank_account_code_1 = String.format("%5d", random.nextInt(99999));
        String bank_account_code_2 = String.format("%5d", random.nextInt(99999));
        String bank_account_code = bank_account_code_1 + bank_account_code_2;
        String IBAN = country_code + control_code + bank_code + bank_branch_code + control_code_user + bank_account_code;
        return IBAN;
    }
    
    public String register(UserData userData) throws Exception{     
        int id = DataBaseManager.SelectUserId(userData.getDNI());

        if(id != 0){
            return "Este usuario ya existe";
        }
        try{
            // Table USERS
            String fields = "dni,password,name,surnames,email,address,'phone number'";
            String values = String.join(", ", userData.getArrayData());

            DataBaseManager.Insert("users", fields, values);

            // Table BANK ACCOUNTS
            String IBAN = GenerateIBAN();
            fields = "iban,'owner id'";
            int owner_id = DataBaseManager.SelectUserId(userData.getDNI());
            values = "'" + IBAN + "'," + owner_id;
            DataBaseManager.Insert("'bank accounts'", fields, values);

            // Table USER HISTORIES
            fields = "iban";
            values = "'" + IBAN + "'";

            DataBaseManager.Insert("'user histories'", fields, values);  
            return "OK";
        }catch(Exception e){
            return e.getMessage();
        }
    }
    
    public void login(String dni, String passwd){
        
    }
    
    
}