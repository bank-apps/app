package model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Bank {

    public Bank() {
        DataBaseManager.connect();
    }

    private String GenerateIBAN() {
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
                    return "OK";
                }
            }
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
        return "El usuario o la contraseña son incorrectas";
    }
    
    private String getActualDate() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat();
        return formatter.format(date);
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
    
    public String modifyUserData(UserData data) throws Exception {
        try {
            int userId = DataBaseManager.SelectUserId("'" + data.getDNI() + "'");

            DataBaseManager.Update("users", "password", "'" + data.getPassword() + "'", "id = " + userId);
            DataBaseManager.Update("users", "name", "'" + data.getName() + "'", "id = " + userId);
            DataBaseManager.Update("users", "surnames", "'" + data.getSurnames() + "'", "id = " + userId);
            DataBaseManager.Update("users", "email", "'" + data.getEmail() + "'", "id = " + userId);
            DataBaseManager.Update("users", "address", "'" + data.getAddress() + "'", "id = " + userId);
            DataBaseManager.Update("users", "'phone number'", "'" + data.getPhoneNumber() + "'", "id = " + userId);
            return "OK";
        } catch(Exception e) {
            return e.getMessage();
        }
    }
}
