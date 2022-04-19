package model;

import java.sql.SQLException;


public class main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        
        UserData data = new UserData("'11111111K'", "123", "'Pepe'", "'Martínez Castillo'", "'pepemc@hotmail.com'", "'Mi casa'", "1245");
        UserData data2 = new UserData("'11111111Q'", "1234", "'Pepeee'", "'Martínez Castillo'", "'pepemcccccc@hotmail.com'", "'Mi casa'", "12345");
                
        Bank.register(data);
        Bank.register(data2);
    }
}
