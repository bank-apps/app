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
        
        System.out.println(sql);
        try ( Connection conn = DataBaseManager.connect()) {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }
    }

    static int SelectUserId(String dni) throws ClassNotFoundException {
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
}
