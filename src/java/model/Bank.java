package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Bank {
    
    private Connection connect(){
        // Cadena de conexión SQLite
        String url = "jdbc:sqlite:database.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void register(UserData userData) throws SQLException {
        Connection conn = connect();
        
        
    }
    
    public void login(String dni, String passwd){
        
    }
    
    
}
