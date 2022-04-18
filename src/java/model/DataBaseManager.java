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
        Connection conn = null;
        try {
            String url = actualDB;
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
}
