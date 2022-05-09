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
    
    static void Insert(String table, String fields, String values) throws Exception {
        String sql = "INSERT INTO " + table + "(" + fields + ") VALUES(" + values + ")";
        try (Connection conn = DataBaseManager.connect()){           
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new Exception(String.valueOf(e));
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
    
    static void UpdateWithIBAN(String table, String field, String value, String IBAN) throws Exception {
        String sql = "UPDATE " + table + " set " + field + " = '" + value + "' WHERE iban = '" + IBAN + "'";
        try ( Connection conn = DataBaseManager.connect()) {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
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

    static String getTransferRecords(String table, String field,
            String value, ArrayList<String> fields) throws Exception {
        String sql = "SELECT ";
        for (int f = 0; f < fields.size() - 1; f++) {
            sql += "\"" + fields.get(f) + "\", ";
        }
        sql += "\"" + fields.get(fields.size() - 1) + "\"";
        sql += " FROM " + "'" + table + "'";
        if (field != null) {
            sql += " WHERE " + "\"" + field + "\"" + " = "
                    + "'" + value + "'";
        }
        System.out.println(sql);
        try (Connection conn = connect()){
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            JSONArray JSONdata = transferResultSetToJSON(rs);
            return rs.toString();
        } catch (SQLException e) {
            throw new Exception(String.valueOf(e));
        }
    }
    
    static JSONArray transferResultSetToJSON(ResultSet rs) throws Exception {
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
        JSONObject result = new JSONObject();
        result.put("transactions", JSONarray);
        System.out.println(result.toString());
        return JSONarray;
    }
}
