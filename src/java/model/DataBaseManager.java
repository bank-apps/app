package model;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class DataBaseManager {

    private static String actualDB = "jdbc:sqlite:database.db";

    static void createNewDatabase(String fileName) {
        String url = "jdbc:sqlite:" + fileName;
        try ( Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                actualDB = url;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    static Connection connect() throws ClassNotFoundException {
        // Cadena de conexión SQLite
        Class.forName("org.sqlite.JDBC");
        Connection conn = null;
        try {
            String url = actualDB;
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    static void Insert(String table, String fields, String values) throws Exception {
        String sql = "INSERT INTO " + table + "(" + fields + ") VALUES(" + values + ")";
        try ( Connection conn = DataBaseManager.connect()) {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }
    }
    
    static void Update(String table, String field, String value, String condition) throws Exception {
        String sql = "UPDATE " + table + " set " + field + " = " + value + " WHERE " + condition;
        try ( Connection conn = DataBaseManager.connect()) {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }
    }

    public static int SelectUserId(String dni) throws ClassNotFoundException {
        String sql = "SELECT id FROM USERS WHERE dni=" + dni;
        try ( Connection conn = connect()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            return rs.getInt("id");
        } catch (SQLException e) {
            return 0;
        }
    }
    
    static String SelectUserPassword(int id) throws Exception{
        String sql = "SELECT password FROM USERS WHERE id=" + id;
        try (Connection conn = connect()){
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            return rs.getString("password");
        } catch (SQLException e) {
            throw new Exception(String.valueOf(e));
        }
    }

    static JSONArray getRecords(String table, String field, String value,
            ArrayList<String> fields) throws Exception {
        String sql = "SELECT ";
        for (int f = 0; f < fields.size() - 1; f++) {
            sql += "\"" + fields.get(f) + "\", ";
        }
        sql += "\"" + fields.get(fields.size() - 1) + "\"";
        sql += " FROM " + "'" + table + "'" + " WHERE " + "\"" + field + "\""
                + " = " + "'" + value + "'";
        try (Connection conn = connect()){
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            JSONArray JSONdata = resultSetToJSON(rs);
            return JSONdata;
        } catch (SQLException e) {
            throw new Exception(String.valueOf(e));
        }
    }
    
    static JSONArray resultSetToJSON(ResultSet rs) throws Exception {
        JSONArray JSONarray = new JSONArray();
        ResultSetMetaData rsmd = rs.getMetaData();
        while(rs.next()) {
            int numColumns = rsmd.getColumnCount();
            JSONObject JSONobj = new JSONObject();
            for (int i=1; i<=numColumns; i++) {
              String name = rsmd.getColumnName(i);
              JSONobj.put(name, rs.getObject(name));
            }
            JSONarray.add(JSONobj);
        }
        return JSONarray;
    }
    
    public static UserData SelectUserByDNI(String dni) throws ClassNotFoundException {
        String sql = "SELECT * FROM USERS WHERE dni=" + dni;
        try (Connection conn = connect()){
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            UserData userData = new UserData(rs.getString("dni"), rs.getString("password"), rs.getString("name"),
            rs.getString("surnames"), rs.getString("email"), rs.getString("address"), rs.getString("phone number"));
            return userData;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    public static ArrayList<BankAccount> SelectBankAccounts(UserAccount account) throws ClassNotFoundException{
        String sql = "SELECT * FROM 'BANK ACCOUNTS' WHERE \"OWNER ID\"=" + DataBaseManager.SelectUserId("'" + account.getData().getDNI() + "'");
        try (Connection conn = connect()){
            ArrayList<BankAccount> bankAccounts = new ArrayList<>();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                BankAccount bankAccount = new BankAccount(rs.getString("IBAN"));
                bankAccount.setBalance(Double.valueOf(rs.getString("BALANCE")));
                bankAccount.setCard(new CreditCard(rs.getString("CARD NUMBER")));
                bankAccounts.add(bankAccount);
            }
            return bankAccounts;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    public static BankAccount GetBankBankAccount() throws ClassNotFoundException{
        String sql = "SELECT * FROM 'BANK ACCOUNTS' WHERE \"OWNER ID\"=-1";
        try (Connection conn = connect()){
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            BankAccount bankBankAccount = new BankAccount(rs.getString("IBAN"));
            bankBankAccount.setBalance(rs.getDouble("BALANCE"));
            return bankBankAccount;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    public static String GetCardStatus(int id) throws ClassNotFoundException{
        String sql = "SELECT \"CARD STATUS\" FROM 'BANK ACCOUNTS' WHERE \"OWNER ID\"=" + id;
        try (Connection conn = connect()){
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            return rs.toString();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
