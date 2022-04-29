package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;


public class Bank {

    public Bank() throws ClassNotFoundException {
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
    
    private String GenerateCardNumber(){
        Random random = new Random();
        String country_code = String.format("%07d", random.nextInt(9999999));
        String user_code = String.format("%09d", random.nextInt(999999999));
        String card_code = country_code + user_code;
        return card_code;
    }
    
    public String register(UserData userData) throws ClassNotFoundException {    
        int id = DataBaseManager.SelectUserId(userData.getDNI());

        if(id != 0) {
            return "Este usuario ya existe";
        }
        try {
            // Table USERS
            String fields = "dni,password,name,surnames,email,address,'phone number'";
            String values = String.join(",", userData.getArrayData());
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
        } catch(Exception e) {
            return e.getMessage();
        }
    }
    
    public String login(String dni, String passwd){
        try {
            int uID = DataBaseManager.SelectUserId(dni);
            if (uID != 0) {
                String uPW = DataBaseManager.SelectUserPassword(uID);
                if(uPW.equals(passwd)) {
                    return "OK";
                }
            }
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
        return "El usuario o la contraseña son incorrectas";
    }
    
    public String transfer(BankAccount from, BankAccount to, Double amount) {
        if (amount > from.getBalance()) {
            return "No hay suficiente saldo";
        }
        Double fromOldBalance = from.getBalance();
        from.setBalance(from.getBalance() - amount);
        
        Double toOldBalance = to.getBalance();
        to.setBalance(to.getBalance() + amount);
        try {
            String fields = "'account history'";
            
            // Add From Register (TABLE USER HISTORIES)
            String fromHistory = "'To -> " + to.getIBAN() + " (-" + amount + ")" + " | Old Balance -> " + fromOldBalance 
                    + " | New Balance -> " + from.getBalance() + "'";
            
            DataBaseManager.Update("'user histories'", fields, fromHistory, "iban = '" + from.getIBAN() + "'");
            DataBaseManager.Update("'bank accounts'", "'balance'", from.getBalance().toString(), "iban = '" + from.getIBAN() + "'");
            
            
             // Add To Register (TABLE USER HISTORIES)
            String toHistory = "'From -> " + from.getIBAN() + " (+" + amount + ")" + " | Old Balance -> " + toOldBalance 
                    + " | New Balance -> " + to.getBalance() + "'";            
            
            DataBaseManager.Update("'user histories'", fields, toHistory, "iban = '" + to.getIBAN() + "'");
            DataBaseManager.Update("'bank accounts'", "'balance'", to.getBalance().toString(), "iban ='" + to.getIBAN() + "'");
           
            return "OK";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    public String issueCard(BankAccount account) throws Exception{
        try{
            Card card = new CreditCard(GenerateCardNumber());
            account.setCard(card);
            DataBaseManager.Update("'bank accounts'", "'card number'", "'" + card.getId() + "'", "iban = '" + account.getIBAN() + "'");
            return "OK";
        }catch(Exception e){
            return e.getMessage();
        }  
    }
    
    public String activateCard(BankAccount account) throws Exception{
        try{
            DataBaseManager.Update("'bank accounts'", "'card status'", "'1'", "iban = '" + account.getIBAN() + "'");
            return "OK";
        }catch(Exception e){
            return e.getMessage();
        }
        
    }
    
    public String modifyUserData(UserData data) throws Exception {
        try{
            int userId = DataBaseManager.SelectUserId("'" + data.getDNI() + "'");

            DataBaseManager.Update("users", "password", "'" + data.getPassword() + "'", "id = " + userId);
            DataBaseManager.Update("users", "name", "'" + data.getName() + "'", "id = " + userId);
            DataBaseManager.Update("users", "surnames", "'" + data.getSurnames() + "'", "id = " + userId);
            DataBaseManager.Update("users", "email", "'" + data.getEmail() + "'", "id = " + userId);
            DataBaseManager.Update("users", "address", "'" + data.getAddress() + "'", "id = " + userId);
            DataBaseManager.Update("users", "'phone number'", "'" + data.getPhoneNumber() + "'", "id = " + userId);
            return "OK";
        }catch(Exception e){
            return e.getMessage();
        }
    }
    
    public JSONArray getTransactions(String IBAN) {
        String[] labels = {"ACCOUNT HISTORY"};
        ArrayList<String> columnNames =
                new ArrayList<>(Arrays.asList(labels));
        try {
            return DataBaseManager.getRecords("user histories", "IBAN", IBAN,
                    columnNames);
        } catch (Exception ex) {
            System.out.println("Algo salió mal al cargar tus transacciones");
            System.out.println(ex.toString());
            return null;
        }
    }
}
