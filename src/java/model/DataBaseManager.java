package model;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class DataBaseManager {
    
    private static String actualDB;
    
    static void createNewDatabase(String fileName) {
        String url = "jdbc:sqlite:" + fileName;
        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                actualDB = url;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    static Connection connect(){
        // Cadena de conexión SQLite
        String url = actualDB;
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    
    static void Insert(String table, String fields, String values){
        String sql = "INSERT INTO " + table + "(" + fields + ") VALUES(" + values + ")";
        try (Connection conn = DataBaseManager.connect()){           
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    static int SelectUserId(String dni){
        String sql = "SELECT id FROM USERS WHERE dni=" + dni;
        try (Connection conn = connect()){
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            return rs.getInt("id");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }
    
    static int SelectUserPassword(int id) throws Exception{
        String sql = "SELECT password FROM USERS WHERE id=" + id;
        try (Connection conn = connect()){
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            return rs.getInt("password");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }
}
