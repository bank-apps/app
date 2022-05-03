package model;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

    static Connection connect() {
        // Cadena de conexión SQLite
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
    
    public static int SelectUserId(String dni) {
        String sql = "SELECT id FROM USERS WHERE dni=" + dni;
        try ( Connection conn = connect()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            return rs.getInt("id");
        } catch (SQLException e) {
            return 0;
        }
    }
    
    static int SelectUserIdWithIBAN(String IBAN) {
        String sql = "SELECT \"owner id\" FROM \"BANK ACCOUNTS\" WHERE iban=\"" + IBAN + "\"";
        try ( Connection conn = connect()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            return rs.getInt("owner id");
        } catch (SQLException e) {
            return 0;
        }
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
    
    static String SelectAccountHistory(String IBAN) {
        String sql = "SELECT \"account history\" FROM \"USER HISTORIES\" WHERE iban=\"" + IBAN + "\"";
        try ( Connection conn = connect()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            return rs.getString("account history");
        } catch (SQLException e) {
            return null;
        }
    }
    
    public static String SelectIBANWithID(int id) {
        String sql = "SELECT \"iban\" FROM \"BANK ACCOUNTS\" WHERE \"owner id\"=" + id;
        try (Connection conn = connect()){
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            return rs.getString("iban");
        } catch (SQLException e) {
            return null;
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
    
    static String SelectUserFullNameWithID(int ID) {
        String sql = "SELECT name,surnames FROM 'USERS' WHERE id=" + ID;
        try ( Connection conn = connect()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            String fullName = rs.getString("name") + " " + rs.getString("surnames");
            return fullName;
        } catch (SQLException e) {
            return null;
        }
    }
    
    /*
    static Object Select(String table, String field, String condition) {
        String sql = "SELECT '" + field + "' FROM '" + table + "' WHERE ";
        try ( Connection conn = connect()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            return rs.getObject(field);
        } catch (SQLException e) {
            return null;
        }
    }
    */
}
