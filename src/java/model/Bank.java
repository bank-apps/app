package model;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;



public class Bank {

    private String BANKIBAN;
    
    public Bank() throws ClassNotFoundException {
        DataBaseManager.connect();
        BANKIBAN = "ES007649000000000000000";
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
    
    public String register(UserData userData) {     
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

            /*
            // Table USER HISTORIES
            fields = "iban";
            values = "'" + IBAN + "'";
            DataBaseManager.Insert("'user histories'", fields, values); 
            */ 
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
                    CollectMaintenance(new UserAccount(DataBaseManager.SelectUserByDNI(dni)));
                    return "OK";
                }
            }
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
        return "El usuario o la contraseña son incorrectas";
    }
    
    
    public String modifyUserData(UserData data) throws Exception {
        try{
            int userId = DataBaseManager.SelectUserId(data.getDNI());

            DataBaseManager.Update("users", "password", data.getPassword(), "id = " + userId);
            DataBaseManager.Update("users", "name", data.getName(), "id = " + userId);
            DataBaseManager.Update("users", "surnames", data.getSurnames(), "id = " + userId);
            DataBaseManager.Update("users", "email", data.getEmail(), "id = " + userId);
            DataBaseManager.Update("users", "address", data.getAddress(), "id = " + userId);
            DataBaseManager.Update("users", "'phone number'", data.getPhoneNumber(), "id = " + userId);
            return "OK";
        }catch(Exception e){
            return e.getMessage();
        }
    }
    
    
    
    public String transfer(BankAccount from, BankAccount to, String recipient, Double amount, String concept) {
        if (amount > from.getBalance()) {
            return "No hay suficiente saldo";
        }
        from.setBalance(from.getBalance() - amount);
        to.setBalance(to.getBalance() + amount);
        try {
            String fields = "'from iban','to iban','recipient','amount','concept','date'";
            String values = "'" + from.getIBAN() + "'" + "," +
                            "'" + to.getIBAN() + "'" + "," + 
                            "'" + recipient + "'" + "," + 
                            "'" + amount + "'" + "," + 
                            "'" + concept + "'" + "," +
                            "'" + getActualDate() + "'";
                            
            DataBaseManager.Insert("'user histories'", fields, values);
            DataBaseManager.Update("'bank accounts'", "'balance'", from.getBalance().toString(), "iban = '" + from.getIBAN() + "'");
            DataBaseManager.Update("'bank accounts'", "'balance'", to.getBalance().toString(), "iban = '" + to.getIBAN() + "'");
            
            return "OK";
        } catch (Exception e) {
            System.out.println("transfer: " + e.getMessage());
            return "Algo ha salido mal durante la transferencia";
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
            account.maintenence += CreditCard.getMaintenance();
            DataBaseManager.Update("'bank acccounts'", "BALANCE", String.valueOf(account.maintenence), "iban = '" + account.getIBAN() + "'");
            DataBaseManager.Update("'bank accounts'", "'card status'", "'1'", "iban = '" + account.getIBAN() + "'");
            return "OK";
        }catch(Exception e){
            return e.getMessage();
        }
    }
    
    public String getTransactions(String IBAN) {
        String[] labels = {"FROM IBAN", "AMOUNT"};
        ArrayList<String> columnNames =
                new ArrayList<>(Arrays.asList(labels));
        try {
            String records = DataBaseManager.getTransferRecords(
                    "user histories", "TO IBAN", IBAN, columnNames);
            return records;
        } catch (Exception ex) {
            System.out.println("Algo salió mal al cargar tus transacciones");
            System.out.println(ex.toString());
            return null;
        }
    }
    
    
    public String AddBankAccount(UserAccount account) throws ClassNotFoundException, Exception{
        try{
            account.addBankAccount(new BankAccount(GenerateIBAN()));
            String IBAN = GenerateIBAN();
            String fields = "iban,'owner id'";
            int owner_id = DataBaseManager.SelectUserId(account.getData().getDNI());
            String values = "'" + IBAN + "'," + owner_id;
            DataBaseManager.Insert("'bank accounts'", fields, values);
            return "OK";
        }catch(Exception e){
            return e.getMessage();
        }
    }
    
    
    public void CollectMaintenance(UserAccount account) throws ClassNotFoundException{
        account.setBankAccounts(DataBaseManager.SelectBankAccounts(account));
        
        for (BankAccount bankAccount : account.getBankAccounts()) {   
            BankAccount cuentaBanco = DataBaseManager.GetBankBankAccount();
            transfer(bankAccount, cuentaBanco, "Banco", bankAccount.getMaintenance(), "Cobro Automático de Cuenta");
        }
    }
    
    
    private String getActualDate() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat();
        return formatter.format(date);
    }
}
